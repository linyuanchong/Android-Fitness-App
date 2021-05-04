package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LegsPage extends AppCompatActivity {

    //Declare variables.
    Button legsBeginnerButton;
    TextView beginnerLegsText;
    Button legsIntermediateButton;
    TextView intermediateLegsText;
    Button legsAdvancedButton;
    TextView advancedLegsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_page);

        //Link variables to components.
        legsBeginnerButton             = findViewById(R.id.legsBeginnerButton);
        legsIntermediateButton         = findViewById(R.id.legsIntermediateButton);
        legsAdvancedButton             = findViewById(R.id.legsAdvancedButton);
        beginnerLegsText             = findViewById(R.id.beginnerLegsText);
        intermediateLegsText         = findViewById(R.id.intermediateLegsText);
        advancedLegsText             = findViewById(R.id.advancedLegsText);

        beginnerLegsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateLegsText.setMovementMethod(new ScrollingMovementMethod());
        advancedLegsText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}