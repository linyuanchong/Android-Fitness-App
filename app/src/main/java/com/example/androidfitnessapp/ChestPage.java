package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChestPage extends AppCompatActivity {

    //Declare variables.
    Button chestBeginnerButton;
    TextView beginnerChestText;
    Button chestIntermediateButton;
    TextView intermediateChestText;
    Button chestAdvancedButton;
    TextView advancedChestText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_page);

        //Link variables to components.
        chestBeginnerButton             = findViewById(R.id.chestBeginnerButton);
        chestIntermediateButton         = findViewById(R.id.chestIntermediateButton);
        chestAdvancedButton             = findViewById(R.id.chestAdvancedButton);
        beginnerChestText             = findViewById(R.id.beginnerChestText);
        intermediateChestText         = findViewById(R.id.intermediateChestText);
        advancedChestText             = findViewById(R.id.advancedChestText);

        beginnerChestText.setMovementMethod(new ScrollingMovementMethod());
        intermediateChestText.setMovementMethod(new ScrollingMovementMethod());
        advancedChestText.setMovementMethod(new ScrollingMovementMethod());
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}