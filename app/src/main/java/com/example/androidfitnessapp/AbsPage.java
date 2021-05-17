package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

<<<<<<< Updated upstream
import com.google.android.gms.tasks.OnSuccessListener;
=======
>>>>>>> Stashed changes
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

<<<<<<< Updated upstream
import java.util.HashMap;
import java.util.Map;

=======
>>>>>>> Stashed changes
public class AbsPage extends AppCompatActivity {

    //Declare variables.
    Button absBeginnerButton;
    TextView beginnerAbsText;
    Button absIntermediateButton;
    TextView intermediateAbsText;
    Button absAdvancedButton;
    TextView advancedAbsText;
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

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;


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
<<<<<<< Updated upstream
=======
        //Radio buttons.
        mondayRB                        = findViewById(R.id.mondayRB);
        tuesdayRB                       = findViewById(R.id.tuesdayRB);
        wednesdayRB                     = findViewById(R.id.wednesdayRB);
        thursdayRB                      = findViewById(R.id.thursdayRB);
        fridayRB                        = findViewById(R.id.fridayRB);
        saturdayRB                      = findViewById(R.id.saturdayRB);
        sundayRB                        = findViewById(R.id.sundayRB);

>>>>>>> Stashed changes
        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        beginnerAbsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateAbsText.setMovementMethod(new ScrollingMovementMethod());
        advancedAbsText.setMovementMethod(new ScrollingMovementMethod());

<<<<<<< Updated upstream
        absBeginnerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
=======
        //Alter workout programme.
        absBeginnerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String beginnerAbsSaveText = beginnerAbsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", beginnerAbsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", beginnerAbsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", beginnerAbsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", beginnerAbsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", beginnerAbsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", beginnerAbsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", beginnerAbsSaveText);
                }
            }
        });

        absIntermediateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String intermediateAbsSaveText = intermediateAbsText.getText().toString().trim();
>>>>>>> Stashed changes
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);
<<<<<<< Updated upstream
                //Create and store data using hashmap.
                Map<String, Object> user = new HashMap<>();
                //Store values into user hashmap.
                user.put("workout_list", beginnerAbsText.toString());
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        System.out.println("successfully created new user" + userID);
                    }
                });
=======

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", intermediateAbsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", intermediateAbsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", intermediateAbsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", intermediateAbsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", intermediateAbsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", intermediateAbsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", intermediateAbsSaveText);
                }
            }
        });

        absAdvancedButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String advancedAbsSaveText = advancedAbsText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", advancedAbsSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", advancedAbsSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", advancedAbsSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", advancedAbsSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", advancedAbsSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", advancedAbsSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", advancedAbsSaveText);
                }
>>>>>>> Stashed changes
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}