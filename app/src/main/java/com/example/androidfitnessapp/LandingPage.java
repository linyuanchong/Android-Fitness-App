package com.example.androidfitnessapp;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class LandingPage extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        createNotificationChannelDaily();
        createNotificationChannelMinute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.topbar_landing_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void logoutFunc(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    public void toChestPage(View view) {
        startActivity(new Intent(getApplicationContext(), ChestPage.class));
        finish();
    }

    public void toArmsPage(View view) {
        startActivity(new Intent(getApplicationContext(), ArmsPage.class));
        finish();
    }

    public void toAbsPage(View view) {
        startActivity(new Intent(getApplicationContext(), AbsPage.class));
        finish();
    }

    public void toLegsPage(View view) {
        startActivity(new Intent(getApplicationContext(), LegsPage.class));
        finish();
    }

    private void createNotificationChannelDaily() {
        Intent intent = new Intent(LandingPage.this, NotifyReceiver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(LandingPage.this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        createNotificationChannel();
        // creating Calendar instance
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(System.currentTimeMillis());
        // setting the date to current day and 7am
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_WEEK_IN_MONTH), 13, 17);
        // variables to trigger repeating notifications every minute
        long triggerAt = date.getTimeInMillis();
        // repeating notification everyday
        alarmManager.setRepeating(AlarmManager.RTC, triggerAt, AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void createNotificationChannelMinute() {

        Intent intent = new Intent(LandingPage.this, NotifyReceiver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(LandingPage.this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        createNotificationChannel();
        // creating Calendar instance
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(System.currentTimeMillis());
        // setting the date to current day and 7am
        date.add(Calendar.MINUTE, 1);
        date.set(Calendar.SECOND, 0);
        // variables to trigger repeating notifications every minute
        long triggerAt = date.getTimeInMillis();
        long repeatAfter = 60 * 1000;
        // repeating notifications in 1 minute interval
        alarmManager.setRepeating(AlarmManager.RTC, triggerAt, repeatAfter, pendingIntent);
    }

    public void createNotificationChannel() {
        CharSequence name = "UserReminderChannel";
        String description = "Basic notification for user";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("notifyUser", name, importance);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel.setDescription(description);
        }

        NotificationManager notificationManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager = getSystemService(NotificationManager.class);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }
    }

}