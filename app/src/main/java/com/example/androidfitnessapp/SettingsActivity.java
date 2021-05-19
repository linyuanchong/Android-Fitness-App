package com.example.androidfitnessapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    TextView sLogoutButton;
    TextView sEditProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_settings);
        //function for enabling dark mode

        sLogoutButton       =      findViewById(R.id.logoutButton);
        sEditProfileButton  =      findViewById(R.id.EditProfileButton);


        //change actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        TextView changeLang = findViewById(R.id.Language);
        changeLang.setOnClickListener(view -> showRlanguageDialog());

        sLogoutButton.setOnClickListener(
                v -> logoutFunc()
        );

        sEditProfileButton.setOnClickListener(
                v -> startActivity(new Intent(getApplicationContext(), AccountPage.class))
        );

    }

    private void showRlanguageDialog() {
        //array of languages to choose from
        final String[] listLang = {"English","Irish","Chinese"};
        AlertDialog.Builder nBuilder = new AlertDialog.Builder(SettingsActivity.this);
        nBuilder.setTitle("Choose Language...");
        nBuilder.setSingleChoiceItems(listLang, -1, (dialogInterface, i) -> {
            if( i == 0) {
                //english
                setLocale("en");
                recreate();
            }
            else if( i == 1) {
                //irish
                setLocale("ga");
                recreate();
            }
            else if( i == 2) {
                //malay
                setLocale("za");
                recreate();
            }
            dialogInterface.dismiss();
        });

        AlertDialog nDialog = nBuilder.create();
        //show dialog on create
        nDialog.show();

    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale()
    {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }


    public void logoutFunc() {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

}