package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LegsPage extends AppCompatActivity {

    //Declare variables.
    Button legsBeginnerButton;
    TextView beginnerLegsText;
    Button legsIntermediateButton;
    TextView intermediateLegsText;
    Button legsAdvancedButton;
    TextView advancedLegsText;
    RadioButton mondayRB;
    RadioButton tuesdayRB;
    RadioButton wednesdayRB;
    RadioButton thursdayRB;
    RadioButton fridayRB;
    RadioButton saturdayRB;
    RadioButton sundayRB;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;


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
        //Radio buttons.
        mondayRB                        = findViewById(R.id.mondayRB);
        tuesdayRB                       = findViewById(R.id.tuesdayRB);
        wednesdayRB                     = findViewById(R.id.wednesdayRB);
        thursdayRB                      = findViewById(R.id.thursdayRB);
        fridayRB                        = findViewById(R.id.fridayRB);
        saturdayRB                      = findViewById(R.id.saturdayRB);
        sundayRB                        = findViewById(R.id.sundayRB);

        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        beginnerLegsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateLegsText.setMovementMethod(new ScrollingMovementMethod());
        advancedLegsText.setMovementMethod(new ScrollingMovementMethod());

        //Alter workout programme.
        legsBeginnerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String beginnerLegsSaveText = beginnerLegsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", beginnerLegsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", beginnerLegsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", beginnerLegsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", beginnerLegsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", beginnerLegsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", beginnerLegsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", beginnerLegsSaveText);
                }
            }
        });

        legsIntermediateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String intermediateLegsSaveText = intermediateLegsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", intermediateLegsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", intermediateLegsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", intermediateLegsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", intermediateLegsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", intermediateLegsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", intermediateLegsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", intermediateLegsSaveText);
                }
            }
        });

        legsAdvancedButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String advancedLegsSaveText = advancedLegsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", advancedLegsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", advancedLegsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", advancedLegsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", advancedLegsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", advancedLegsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", advancedLegsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", advancedLegsSaveText);
                }
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}