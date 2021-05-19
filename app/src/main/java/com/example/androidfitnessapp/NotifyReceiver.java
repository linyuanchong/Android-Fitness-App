package com.example.androidfitnessapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotifyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, "notifyUser")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle("Workout reminder")
                .setContentText("Visit the app to start working out")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());
    }
}
