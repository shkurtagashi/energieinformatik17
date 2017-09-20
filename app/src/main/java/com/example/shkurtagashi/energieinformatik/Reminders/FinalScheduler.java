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

    /* Creation of the courses - BEGIN */

    //Linear Algebra on Monday and  Wednesday from 8:30 until 10:15
    public Weekday session1 = new Weekday(17, 34, Calendar.TUESDAY);
    public Weekday session2 = new Weekday(17, 35, Calendar.TUESDAY);
    public Weekday session3 = new Weekday(15, 25, Calendar.TUESDAY);

    public Weekday session4 = new Weekday(10, 55, Calendar.TUESDAY);
    public Weekday session5 = new Weekday(10, 25, Calendar.TUESDAY);


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
        setAlarm(context, "", "Session1", 10, session1, 0, 0);
        setAlarm(context, "", "Session2", 20, session2, 0, 0);
        setAlarm(context, "", "Session3", 20, session3, 0, 0);
        setAlarm(context, "", "Session4", 20, session4, 0, 0);
        setAlarm(context, "", "Session5", 20, session5, 0, 0);
    }

    public void setAlarm(Context context, String course, String questionnaire, int requestCode, Weekday weekday, int hourAddition, int minuteAddition){
        Intent myIntent = new Intent(context, AlarmNotificationReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        myIntent.putExtra("course", course);
        myIntent.putExtra("questionnaire", questionnaire);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context, requestCode, myIntent, PendingIntent.FLAG_ONE_SHOT);
        Calendar calendar1 = createCalendar(weekday.getDay2(),weekday.getHour()+hourAddition, weekday.getMinute()+minuteAddition);

        if (calendar1.getTimeInMillis() > System.currentTimeMillis()) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), pendingIntent1);
        } else {
            calendar1.add(java.util.Calendar.DAY_OF_MONTH, 7);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar1.getTimeInMillis(), pendingIntent1);
        }

    }






}

