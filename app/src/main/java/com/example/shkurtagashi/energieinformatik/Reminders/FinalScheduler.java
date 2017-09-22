package com.example.shkurtagashi.energieinformatik.Reminders;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
//import android.icu.util.Calendar;

import com.example.shkurtagashi.energieinformatik.MainActivity;
import com.example.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.example.shkurtagashi.energieinformatik.R;

import java.util.Calendar;
import java.util.Random;


/**
 * Created by shkurtagashi on 11.02.17.
 */

public class FinalScheduler {

    /* Creation of the SESSIONS - BEGIN */

    public Weekday session1 = new Weekday(11, 59, Calendar.MONDAY);
    public Weekday session2 = new Weekday(15, 59, Calendar.MONDAY);
    public Weekday session3 = new Weekday(17, 59, Calendar.MONDAY);
    public Weekday session4 = new Weekday(11, 59, Calendar.TUESDAY);
    public Weekday session5 = new Weekday(14, 59, Calendar.TUESDAY);

//    private Weekday session1 = new Weekday(15, 55, Calendar.FRIDAY);
//    private Weekday session2 = new Weekday(15, 56, Calendar.FRIDAY);
//    private Weekday session3 = new Weekday(15, 57, Calendar.FRIDAY);
//    private Weekday session4 = new Weekday(15, 58, Calendar.FRIDAY);
//    private Weekday session5 = new Weekday(15, 59, Calendar.FRIDAY);


    private Calendar createCalendar(int day, int hour, int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.SECOND, 0);

        return calendar;
    }

      /* Creation of the reminder for rating presentations */

    /********** Reminder **********/
    public void createReminder(Context context) {
        setAlarm(context, 10, "Session 1", session1);
        setAlarm(context, 20, "Session 2", session2);
        setAlarm(context, 30, "Session 3", session3);
        setAlarm(context, 40, "Session 4", session4);
        setAlarm(context, 50, "Session 5", session5);
    }

    public void setAlarm(Context context, int requestCode, String session, Weekday weekday){
        Intent myIntent = new Intent(context, AlarmNotificationReceiver.class);
        myIntent.putExtra("Session", session);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context, requestCode, myIntent, PendingIntent.FLAG_ONE_SHOT);
        Calendar calendar1 = createCalendar(weekday.getDay2(),weekday.getHour(), weekday.getMinute());

        if (calendar1.getTimeInMillis() > System.currentTimeMillis()) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), pendingIntent1);
        } else {
            calendar1.add(java.util.Calendar.DAY_OF_MONTH, 7);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), pendingIntent1);
        }

    }






}

