package com.example.androidfitnessapp;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class LandingPage extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        //Link variables to components.
        toolbar                         = findViewById(R.id.toolbar);
        drawer                          = findViewById(R.id.drawer_layout);
        navigationView                  = findViewById(R.id.nav_view);

        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        setSupportActionBar(toolbar);

        //Set userID.
        userID = fAuth.getCurrentUser().getUid();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
                if (id==R.id.nav_home){
                    startActivity(new Intent(getApplicationContext(), LandingPage.class));
                }
                else if (id==R.id.nav_account){
                    startActivity(new Intent(getApplicationContext(), AccountPage.class));
                }
                else if (id==R.id.nav_schedule){
                    startActivity(new Intent(getApplicationContext(), SchedulePage.class));
                }
                else if (id==R.id.nav_settings){
                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                }
                else if (id==R.id.nav_logout){
                    FirebaseAuth.getInstance().signOut();//logout
                    startActivity(new Intent(getApplicationContext(), Login.class));
                    finish();
                }
                //This is for maintaining the behavior of the Navigation view
                NavigationUI.onNavDestinationSelected(menuItem,navController);
                //This is for closing the drawer after acting on it
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        createNotificationChannel();
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
    private void createNotificationChannel() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "UserReminderChannel";
            String description = "Basic notification for user";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyUser", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            Intent intent = new Intent(LandingPage.this, NotifyReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(LandingPage.this, 0, intent, 0);

            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);


//          Calendar date = Calendar.getInstance();
//          date.setTimeInMillis(System.currentTimeMillis());
//          setting the date to current day and 7am
//          date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_WEEK_IN_MONTH), 7, 0);
//          date.add(Calendar.MINUTE, 1);
//          date.set(Calendar.SECOND, 0);

//          variables to trigger repeating notifications every minute
//          long triggerAt = date.getTimeInMillis();
//          long repeatAfter = 60 * 1000;

//          repeating notifications in 1 minute interval
//          alarmManager.setRepeating(AlarmManager.RTC, triggerAt, repeatAfter, pendingIntent);
//          repeating notification everyday
//          alarmManager.setRepeating(AlarmManager.RTC, date, AlarmManager.INTERVAL_DAY, pendingIntent);


            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(System.currentTimeMillis());
//          setting the date to current day and 7am
            date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_WEEK_IN_MONTH), 13, 17);
//          date.add(Calendar.MINUTE, 1);
//          date.set(Calendar.HOUR, 13);
//          date.set(Calendar.MINUTE, 15);

//          variables to trigger repeating notifications every minute
            long triggerAt = date.getTimeInMillis();
            long repeatAfter = 60 * 1000;

//          repeating notifications in 1 minute interval
//          alarmManager.setRepeating(AlarmManager.RTC, triggerAt, repeatAfter, pendingIntent);
//          repeating notification everyday
            alarmManager.setRepeating(AlarmManager.RTC, triggerAt, AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }
}