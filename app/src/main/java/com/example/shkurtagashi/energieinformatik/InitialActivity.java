package com.example.shkurtagashi.energieinformatik;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shkurtagashi.energieinformatik.LocalDataStorage.DatabaseHelper;
import com.example.shkurtagashi.energieinformatik.User.UsersContract.UserEntry;

public class InitialActivity extends AppCompatActivity {

    public String android_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

//        Intent intent;
//
//        //Check Database, if user already registered direct to HomeActivity, otherwise direct to Register Form Activity
//        if (checkAndroidID()) {
//            intent = new Intent(this, MainActivity.class);
//        }
////        } else {
//////            intent = new Intent(this, RegisterActivity.class);
////        }
//        startActivity(intent);
//        finish();
    }


    public boolean checkAndroidID(){
        boolean exists;

        DatabaseHelper usersDbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = usersDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UserEntry.ANDROID_ID
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = UserEntry.ANDROID_ID + " = ?";
        String[] selectionArgs = { android_id };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserEntry._ID + " ASC";

        Cursor cursor = db.query(
                UserEntry.TABLE_NAME_USERS,                     // The table to query
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
