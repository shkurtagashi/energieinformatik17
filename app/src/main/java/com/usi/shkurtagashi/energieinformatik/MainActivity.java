package com.usi.shkurtagashi.energieinformatik;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.usi.shkurtagashi.energieinformatik.Fragments.AboutFragment;
import com.usi.shkurtagashi.energieinformatik.Fragments.ProfileFragment;
import com.usi.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.usi.shkurtagashi.energieinformatik.Papers.PapersFragment;
import com.usi.shkurtagashi.energieinformatik.Program.ProgramFragment;
import com.usi.shkurtagashi.energieinformatik.Fragments.RegisterFragment;
import com.usi.shkurtagashi.energieinformatik.Speakers.SpeakersFragment;
import com.usi.shkurtagashi.energieinformatik.Fragments.WelcomeFragment;
import com.usi.shkurtagashi.energieinformatik.Reminders.FinalScheduler;
import com.usi.shkurtagashi.energieinformatik.RemoteDataStorage.UploadAlarmReceiver;
import com.usi.shkurtagashi.energieinformatik.User.UsersContract;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    protected DrawerLayout drawerLayout;
    private Toolbar toolbar;
    protected NavigationView navigationView;

    Calendar calendar;
    String weekday;
    SimpleDateFormat dayFormat;
    int month;
    int dayOfMonth;
    FinalScheduler scheduler;

    String android_id;

    private boolean viewIsAtHome;

    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);


//        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
//        contentMain = (View) findViewById(R.layout.content_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displayView(R.id.nav_home);


        //Triger reminders for rating presentations and uploading data
        triggerReminders();

    }

    public void displayView(int viewId) {

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {
            case R.id.nav_home:
                fragment = new WelcomeFragment();
//                title  = "Conference Program";
                viewIsAtHome = true;

                break;
            case R.id.nav_program:
                fragment = new ProgramFragment();
                title  = "Conference Program";
                viewIsAtHome = false;
                break;
            case R.id.nav_speakers:
                fragment = new SpeakersFragment();
                title = "Keynote Speakers";
                viewIsAtHome = false;
                break;

            case R.id.nav_papers:
                fragment = new PapersFragment(); //Change it to papers
                title = "Paper Presentations";
                viewIsAtHome = false;
                break;

            case R.id.nav_register:
                if(checkAndroidID()){
                    fragment = new ProfileFragment();
                    title = "Account Details";

                }else{
                    fragment = new RegisterFragment(); //Change it to papers
                    title = "Create Account";
                }

                viewIsAtHome = false;
                break;

            case R.id.nav_about:
                fragment = new AboutFragment(); //Change it to papers
                title = "About Study";
                viewIsAtHome = false;
                break;


        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (!viewIsAtHome) { //if the current view is not the News fragment
            displayView(R.id.nav_home); //display the News fragment
        } else {
            moveTaskToBack(true);  //If view is in News fragment, exit application
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
        //noinspection SimplifiableIfStatement
//        if (id == R.id.about_study) {
////            Intent i = new Intent(this, AboutActivity.class);
////            startActivity(i);
////            displayView(R.id.);
//        }else if(id == R.id.registration_form){
//            Intent i = new Intent(this, RegisterActivity.class);
//            startActivity(i);
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displayView(item.getItemId());
        return true;

    }

    public void triggerReminders(){
        dayFormat = new SimpleDateFormat("EEEE", Locale.US);
        calendar = Calendar.getInstance();
        weekday = dayFormat.format(calendar.getTime());
        scheduler = new FinalScheduler();
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


        //January - 0
        if(month == Calendar.OCTOBER && dayOfMonth >= 1 && dayOfMonth <= 8){
            Log.v("Homeee", "Alarms Triggered");
            scheduler.createReminder(getApplicationContext());
            uploadDataEveryday();
        }
    }

    public void uploadDataEveryday(){

        // Retrieve a PendingIntent that will perform a broadcast
        Intent intent = new Intent(getApplicationContext(), UploadAlarmReceiver.class);
        AlarmManager am = (AlarmManager) getSystemService(getApplicationContext().ALARM_SERVICE);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        if (cal.getTimeInMillis() > System.currentTimeMillis()) { //if it is more than 19:00 o'clock, trigger it tomorrow
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.GERMANY);

            String time = sdf.format(new Date());
            System.out.println(time + ": Upload alarm triggered for today");

            am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_ONE_SHOT));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.GERMANY);
            Log.v("HOMEEE", "Upload Alarm Triggered for next day");
            cal.add(Calendar.DAY_OF_MONTH, 1); //trigger alarm tomorrow

            am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_ONE_SHOT));
        }
    }

    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    public void expandableButton5(View view) {
        expandableLayout5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout5);
        expandableLayout5.toggle(); // toggle expand and collapse
    }

    public boolean checkAndroidID(){
        boolean exists;

        DatabaseHelper usersDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = usersDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UsersContract.UserEntry.ANDROID_ID
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = UsersContract.UserEntry.ANDROID_ID + " = ?";
        String[] selectionArgs = { android_id };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UsersContract.UserEntry._ID + " ASC";

        Cursor cursor = db.query(
                UsersContract.UserEntry.TABLE_NAME_USERS,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );


        if(cursor.getCount() > 0){
            exists = true;
        } else{
            exists = false;
        }

        cursor.close();
        db.close();
        return exists;
    }
}

