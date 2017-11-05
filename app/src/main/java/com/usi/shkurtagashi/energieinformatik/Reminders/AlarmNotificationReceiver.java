package com.usi.shkurtagashi.energieinformatik.Reminders;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.usi.shkurtagashi.energieinformatik.MainActivity;
import com.usi.shkurtagashi.energieinformatik.Papers.PapersActivity;
import com.usi.shkurtagashi.energieinformatik.R;
import com.usi.shkurtagashi.energieinformatik.Survey.Questionnaire;

import java.util.Random;

/**
 *
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("I am in receiver!");

        String session = intent.getExtras().get("Session").toString();


        if(session.equals("Conference Day 1")){
            setNotification2(context, "Survey Time", "Please don't forget to give us your opinion about " + session + "!", 1000097);
        }else if(session.equals("Conference Day 2")){
            setNotification2(context, "Survey Time", "Please don't forget to give us your opinion about " + session + "!", 1000098);
        }else{
            setNotification(context, "Survey Time", "Please don't forget to rate presentations of " + session + "!", session, 1000099);
        }
    }



    public void setNotification(Context context, String title, String content, String session, int notificationID){
        Bundle bundle = new Bundle();

        Random rand = new Random();
        int code = rand.nextInt(100000000);
        System.out.println("code: "+code);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
//        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setAutoCancel(true);
        builder.setOngoing(true);
//        builder.setChannel("Reminders");

        Intent intent = new Intent(context, PapersActivity.class);
        bundle.putString("paper", session);
        intent.putExtras(bundle);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(PapersActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(code, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.logo3);

        //System.out.println("in setNotification");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID, builder.build());

    }

    public void setNotification2(Context context, String title, String content, int notificationID){
        Random rand = new Random();
        int code = rand.nextInt(1000000);
        System.out.println("code: "+code);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
//        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        builder.setAutoCancel(true);
        builder.setOngoing(true);
//        builder.setChannel("Memorable");


        Intent intent = new Intent(context, Questionnaire.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(code, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.drawable.logo3);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID, builder.build());

    }
}
