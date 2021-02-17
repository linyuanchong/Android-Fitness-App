package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArmsPage extends AppCompatActivity {

    //Declare variables.
    Button armsBeginnerButton;
    TextView beginnerArmsText;
    Button armsIntermediateButton;
    TextView intermediateArmsText;
    Button armsAdvancedButton;
    TextView advancedArmsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_page);

        //Link variables to components.
        armsBeginnerButton             = findViewById(R.id.armsBeginnerButton);
        armsIntermediateButton         = findViewById(R.id.armsIntermediateButton);
        armsAdvancedButton             = findViewById(R.id.armsAdvancedButton);
        beginnerArmsText             = findViewById(R.id.beginnerArmsText);
        intermediateArmsText         = findViewById(R.id.intermediateArmsText);
        advancedArmsText             = findViewById(R.id.advancedArmsText);

        beginnerArmsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateArmsText.setMovementMethod(new ScrollingMovementMethod());
        advancedArmsText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}