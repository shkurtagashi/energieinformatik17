package com.usi.shkurtagashi.energieinformatik.Reminders;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
//import android.icu.util.Calendar;

import java.util.Calendar;
import java.util.Random;


/**
 * Created by shkurtagashi on 11.02.17.
 */

public class FinalScheduler {

    /********** Day 1 ***********/
//    private Weekday session11 = new Weekday(16, 16, Calendar.WEDNESDAY, "Paper 1 of Session 1");
//    private Weekday session12 = new Weekday(16, 17, Calendar.WEDNESDAY, "Paper 2 of Session 1");
//    private Weekday session13 = new Weekday(16, 18, Calendar.WEDNESDAY, "Paper 3 of Session 1");
//    private Weekday session14 = new Weekday(16, 19, Calendar.WEDNESDAY, "Paper 4 of Session 1");
//    private Weekday session15 = new Weekday(16, 20, Calendar.WEDNESDAY, "Paper 5 of Session 1");

//    private Weekday endOfDay1 = new Weekday(13, 43, Calendar.MONDAY, "Conference Day 1");

    private Weekday session11 = new Weekday(10, 45, Calendar.THURSDAY, "Paper 1 of Session 1");
    private Weekday session12 = new Weekday(11, 0, Calendar.THURSDAY, "Paper 2 of Session 1");
    private Weekday session13 = new Weekday(11, 15, Calendar.THURSDAY, "Paper 3 of Session 1");
    private Weekday session14 = new Weekday(11, 30, Calendar.THURSDAY, "Paper 4 of Session 1");
    private Weekday session15 = new Weekday(11, 45, Calendar.THURSDAY, "Paper 5 of Session 1");

//    private Weekday session2 = new Weekday(14, 30, Calendar.THURSDAY, "Session 2");
    private Weekday session21 = new Weekday(14, 45, Calendar.THURSDAY, "Paper 1 of Session 2");
    private Weekday session22 = new Weekday(15, 0, Calendar.THURSDAY, "Paper 2 of Session 2");
    private Weekday session23 = new Weekday(15, 15, Calendar.THURSDAY, "Paper 3 of Session 2");
    private Weekday session24 = new Weekday(15, 45, Calendar.THURSDAY, "Paper 4 of Session 2");


//    private Weekday session3 = new Weekday(16, 30, Calendar.THURSDAY, "Session 3");
    private Weekday session31 = new Weekday(16, 45, Calendar.THURSDAY, "Paper 1 of Session 3");
    private Weekday session32 = new Weekday(17, 0, Calendar.THURSDAY, "Paper 2 of Session 3");
    private Weekday session33 = new Weekday(17, 15, Calendar.THURSDAY, "Paper 3 of Session 3");
    private Weekday session34 = new Weekday(17, 30, Calendar.THURSDAY, "Paper 4 of Session 3");
    private Weekday session35 = new Weekday(17, 45, Calendar.THURSDAY, "Paper 5 of Session 3");

    private Weekday endOfDay1 = new Weekday(17, 55, Calendar.THURSDAY, "Conference Day 1");

    /********** Day 2 ***********/
//    private Weekday session4 = new Weekday(10, 30, Calendar.FRIDAY, "Session 4");
    private Weekday session41 = new Weekday(10, 50, Calendar.FRIDAY, "Paper 1 of Session 4");
    private Weekday session42 = new Weekday(11, 10, Calendar.FRIDAY, "Paper 2 of Session 4");
    private Weekday session43 = new Weekday(11, 30, Calendar.FRIDAY, "Paper 3 of Session 4");
    private Weekday session44 = new Weekday(11, 50, Calendar.FRIDAY, "Paper 4 of Session 4");

//    private Weekday session5 = new Weekday(13, 30, Calendar.FRIDAY, "Session 5");
    private Weekday session51 = new Weekday(13, 45, Calendar.FRIDAY, "Paper 1 of Session 5");
    private Weekday session52 = new Weekday(14, 0, Calendar.FRIDAY, "Paper 2 of Session 5");
    private Weekday session53 = new Weekday(14, 15, Calendar.FRIDAY, "Paper 3 of Session 5");
    private Weekday session54 = new Weekday(14, 30, Calendar.FRIDAY, "Paper 4 of Session 5");
    private Weekday session55 = new Weekday(14, 45, Calendar.FRIDAY, "Paper 5 of Session 5");

    private Weekday endOfDay2 = new Weekday(14, 55, Calendar.FRIDAY, "Conference Day 2");


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
//
//        Weekday [] reminders = {session1, session2, session3, endOfDay1,
//                session4, session5, endOfDay2};

        Weekday [] reminders = {session11, session12, session13, session14, session15,
                 session21, session22, session23, session24,
                 session31, session32, session33, session34, session35,
                endOfDay1,
                session41, session42, session43, session44,
                session51, session52, session53, session54, session55,
                endOfDay2};

        Random rand = new Random();
        int code;

        for (Weekday w: reminders) {
            code = rand.nextInt(100000000);
            setAlarm(context, code, w.getDescription(), w);
            Log.v("Scheduler", "Session: "+ w.getDescription() + "code: "+code);

        }

//        setAlarm(context, 10, "Session 1", session1);
//        setAlarm(context, 20, "Session 2", session2);
//        setAlarm(context, 30, "Session 3", session3);
//        setAlarm(context, 40, "Session 4", session4);
//        setAlarm(context, 50, "Session 5", session5);
//
//        setAlarm(context, 60, "Conference Day 1", endOfDay1);
//        setAlarm(context, 70, "Conference Day 2", endOfDay2);

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

