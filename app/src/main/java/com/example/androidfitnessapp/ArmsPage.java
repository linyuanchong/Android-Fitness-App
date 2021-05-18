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

public class ArmsPage extends AppCompatActivity {

    //Declare variables.
    Button armsBeginnerButton;
    TextView beginnerArmsText;
    Button armsIntermediateButton;
    TextView intermediateArmsText;
    Button armsAdvancedButton;
    TextView advancedArmsText;
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
        setContentView(R.layout.activity_arms_page);

        //Link variables to components.
        armsBeginnerButton             = findViewById(R.id.armsBeginnerButton);
        armsIntermediateButton         = findViewById(R.id.armsIntermediateButton);
        armsAdvancedButton             = findViewById(R.id.armsAdvancedButton);
        beginnerArmsText             = findViewById(R.id.beginnerArmsText);
        intermediateArmsText         = findViewById(R.id.intermediateArmsText);
        advancedArmsText             = findViewById(R.id.advancedArmsText);
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

        beginnerArmsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateArmsText.setMovementMethod(new ScrollingMovementMethod());
        advancedArmsText.setMovementMethod(new ScrollingMovementMethod());

        //Alter workout programme.
        armsBeginnerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String beginnerArmsSaveText = beginnerArmsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", beginnerArmsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", beginnerArmsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", beginnerArmsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", beginnerArmsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", beginnerArmsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", beginnerArmsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", beginnerArmsSaveText);
                }
            }
        });

        armsIntermediateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String intermediateArmsSaveText = intermediateArmsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", intermediateArmsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", intermediateArmsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", intermediateArmsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", intermediateArmsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", intermediateArmsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", intermediateArmsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", intermediateArmsSaveText);
                }
            }
        });

        armsAdvancedButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String advancedArmsSaveText = advancedArmsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", advancedArmsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", advancedArmsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", advancedArmsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", advancedArmsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", advancedArmsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", advancedArmsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", advancedArmsSaveText);
                }
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}