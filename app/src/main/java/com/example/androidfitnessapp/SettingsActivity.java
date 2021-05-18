package com.example.androidfitnessapp;

import android.app.Activity;
import android.content.DialogInterface;
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

    TextView rLanguage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_settings);
        //function for enabling dark mode

        //change actionbar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));



       rLanguage       = findViewById(R.id.rLanguage);


       rLanguage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //show alertdialog to display list of the languages

               showRlanguageDialog();

           }
       });
    }

    private void showRlanguageDialog() {
        //array of languages to choose from

        final String[] listLang = {"English","Irish","Mala"};
        AlertDialog.Builder nBuilder = new AlertDialog.Builder(SettingsActivity.this);
        nBuilder.setTitle("Choose Language...");
        nBuilder.setSingleChoiceItems(listLang, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if( i == 0) {
                    //english
                    setLocae("en");
                    recreate();
                }
                else if( i == 1) {
                    //irish
                    setLocae("ga-rIE");
                    recreate();
                }
                else if( i == 2) {
                    //malay
                    setLocae("CH");
                    recreate();
                }

                dialog.dismiss();
            }
        });

        AlertDialog nDialog = nBuilder.create();
        //show dialog on create
        nDialog.show();

    }

    private void setLocae(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //save data to shared prefeneces

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Language", lang);
        editor.apply();
    }

    public void loadLocale()
    {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Language","");
        setLocae(language);
    }


    public void logoutFunc(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

}