package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbsPage extends AppCompatActivity {

    //Declare variables.
    Button absBeginnerButton;
    TextView beginnerAbsText;
    Button absIntermediateButton;
    TextView intermediateAbsText;
    Button absAdvancedButton;
    TextView advancedAbsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_page);

        //Link variables to components.
        absBeginnerButton             = findViewById(R.id.absBeginnerButton);
        absIntermediateButton         = findViewById(R.id.absIntermediateButton);
        absAdvancedButton             = findViewById(R.id.absAdvancedButton);
        beginnerAbsText             = findViewById(R.id.beginnerAbsText);
        intermediateAbsText         = findViewById(R.id.intermediateAbsText);
        advancedAbsText             = findViewById(R.id.advancedAbsText);

        beginnerAbsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateAbsText.setMovementMethod(new ScrollingMovementMethod());
        advancedAbsText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}