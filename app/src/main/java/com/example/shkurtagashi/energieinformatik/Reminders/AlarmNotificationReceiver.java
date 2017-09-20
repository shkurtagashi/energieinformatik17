package com.example.shkurtagashi.energieinformatik.Reminders;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.example.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.example.shkurtagashi.energieinformatik.R;

import java.util.Calendar;
import java.util.Random;

/**
 *
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String course = intent.getExtras().get("course").toString();
        String questionnaire = intent.getExtras().get("questionnaire").toString();
        System.out.println("Course: "+intent.getExtras().get("course"));
        System.out.println("Questionnaire: "+intent.getExtras().get("questionnaire"));
        System.out.println("I am in receiver!");

        //here for each case we need to reschedule the alarm for next week, and set the notification

        if(course.equals("")){
            if(questionnaire.equals("Session1")){
                setAlarm(context, "", "Session1", 61);
                setNotification(context, "", "Session1", 1000, "Survey Time", "Time to answer questionnaire!", 1000);
            }

            if(questionnaire.equals("Session2")){
                setAlarm(context, "", "Session2", 64);
                setNotification(context, "", "Session2", 4000, "Survey Time", "Time to answer questionnaire!", 4000);
            }

        }

    }


    public void setAlarm(Context context, String course, String questionnaire, int requestCode){

        Intent myIntent = new Intent(context, AlarmNotificationReceiver.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        myIntent.putExtra("course", course);
        myIntent.putExtra("questionnaire", questionnaire);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context, requestCode, myIntent, PendingIntent.FLAG_ONE_SHOT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+604800000, pendingIntent1); //604 800 000 (7 days)
        System.out.println("alarm set for the future");
    }

    public void setNotification(Context context, String course, String questionnaire, int requestCode, String title, String content, int notificationID){
        Random rand = new Random();
        int code = rand.nextInt(100000000);
        System.out.println("code: "+code);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setAutoCancel(true);


        Intent intent = new Intent(context, PapersActivity.class);
        intent.putExtra("questionnaire", questionnaire);
        intent.putExtra("course", course);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(PapersActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(code, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.survey);

        //System.out.println("in setNotification");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID, builder.build());

    }
}
