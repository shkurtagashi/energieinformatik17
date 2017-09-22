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
import com.example.shkurtagashi.energieinformatik.Papers.PapersFragment;
import com.example.shkurtagashi.energieinformatik.R;

import java.util.Calendar;
import java.util.Random;

/**
 *
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("I am in receiver!");

        String session = intent.getExtras().get("Session").toString();

        setNotification(context, "Survey Time", "Please don't forget to rate presentations of " + session + "!", 1000098);
    }



    public void setNotification(Context context, String title, String content, int notificationID){
        Random rand = new Random();
        int code = rand.nextInt(100000000);
        System.out.println("code: "+code);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setAutoCancel(false);


        Intent intent = new Intent(context, PapersActivity.class);

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
