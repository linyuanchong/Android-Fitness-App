package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "UserReminderChannel";
            String description = "User reminder to workout";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyUser", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(MainActivity.this, NotifyReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_NO_CREATE);


            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(System.currentTimeMillis());
            // setting the date to current day and 7am
//            date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_WEEK_IN_MONTH), 7, 0);
            date.add(Calendar.MINUTE, 1);
            date.set(Calendar.SECOND, 0);

            // variables to trigger repeating notifications every minute
            long triggerAt = date.getTimeInMillis();
            long repeatAfter = 60 * 1000;

            // repeating notifications in 1 minute interval
            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerAt + repeatAfter, pendingIntent);
            // repeating notification everyday
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, date, AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }
}