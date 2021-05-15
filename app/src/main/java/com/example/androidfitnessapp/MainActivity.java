package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "UserReminderChannel";
            String description = "Basic notification for user";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyUser", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            Intent intent = new Intent(MainActivity.this, NotifyReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(System.currentTimeMillis());
            date.add(Calendar.MINUTE, 1);
            date.set(Calendar.SECOND, 0);

            long triggerAt = date.getTimeInMillis();
            long repeatAfter = 60 * 1000;

            alarmManager.set(AlarmManager.RTC_WAKEUP, triggerAt + repeatAfter, pendingIntent);
//            alarmManager.setRepeating(AlarmManager.RTC, triggerAt, repeatAfter, pendingIntent);
        }
    }
}