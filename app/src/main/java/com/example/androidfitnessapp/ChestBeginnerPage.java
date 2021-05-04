package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChestBeginnerPage extends AppCompatActivity {


    /*

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("addWorkout", "addWorkout", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
     */


    //Declare variables.
    Button chestBeginnerButton;
    TextView beginnerChestText;
    Button addWorkout;
    Button scheduleWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_beginner_page);

        //Link variables to components.
        chestBeginnerButton = findViewById(R.id.chestBeginnerButton);
        beginnerChestText = findViewById(R.id.beginnerChestText);
        addWorkout = findViewById(R.id.addWorkout);
        scheduleWorkout = findViewById(R.id.scheduleWorkout);

        beginnerChestText.setMovementMethod(new ScrollingMovementMethod());

        /*
        TODO: create on click listeners for addWorkout and scheduleWorkout.
        add button to add this workout to collection (array of added workout).
        schedule - on click open calendar api to select date and time to be saved
            and activated with notifications.
         */


        /*
        // enable notification below to run on Oreo version or greater
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Workout added", "Workout added", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
         */


        //simple notification to appear in notification overlay when add button is pressed
        // to notify user that it has been added to workout collection
        addWorkout.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String message = "Workout added";
               // code what happens when button is pressed
               // will implement simple notification to test
               NotificationCompat.Builder notificationBuilder =
                       new NotificationCompat.Builder
                               (ChestBeginnerPage.this, "Simple Notification");

               notificationBuilder.setContentTitle("Workout added");
               notificationBuilder.setContentText("You have added \"this\" workout to your collection");
               notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background);
               // removes the notification when it is tapped
               notificationBuilder.setAutoCancel(true);
               notificationBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

               Intent intent = new Intent(ChestBeginnerPage.this, ChestBeginnerPage.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               intent.putExtra("message", message);
               
               PendingIntent pendingIntent =
                       PendingIntent.getActivity(ChestBeginnerPage.this,
                               0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
               notificationBuilder.setContentIntent(pendingIntent);
               NotificationManager notificationManager =
                       (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
               notificationManager.notify(0, notificationBuilder.build());
               //NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ChestBeginnerPage.this);
               //managerCompat.notify(1, notificationBuilder.build());
           }
        });

        scheduleWorkout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // code to open calendar API to go in here
                // TODO: add calendar code to open on click
            }
        });

    }



    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}

