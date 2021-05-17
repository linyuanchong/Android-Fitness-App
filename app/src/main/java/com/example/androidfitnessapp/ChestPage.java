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

public class ChestPage extends AppCompatActivity {

    //Declare variables.
    Button chestBeginnerButton;
    TextView beginnerChestText;
    Button chestIntermediateButton;
    TextView intermediateChestText;
    Button chestAdvancedButton;
    TextView advancedChestText;
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
        setContentView(R.layout.activity_chest_page);

        //Link variables to components.
        chestBeginnerButton             = findViewById(R.id.chestBeginnerButton);
        chestIntermediateButton         = findViewById(R.id.chestIntermediateButton);
        chestAdvancedButton             = findViewById(R.id.chestAdvancedButton);
        beginnerChestText               = findViewById(R.id.beginnerChestText);
        intermediateChestText           = findViewById(R.id.intermediateChestText);
        advancedChestText               = findViewById(R.id.advancedChestText);
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

        beginnerChestText.setMovementMethod(new ScrollingMovementMethod());
        intermediateChestText.setMovementMethod(new ScrollingMovementMethod());
        advancedChestText.setMovementMethod(new ScrollingMovementMethod());

        //Alter workout programme.
        chestBeginnerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String beginnerChestSaveText = beginnerChestText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", beginnerChestSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", beginnerChestSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", beginnerChestSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", beginnerChestSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", beginnerChestSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", beginnerChestSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", beginnerChestSaveText);
                }
            }
        });

        chestIntermediateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String intermediateChestSaveText = intermediateChestText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", intermediateChestSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", intermediateChestSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", intermediateChestSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", intermediateChestSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", intermediateChestSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", intermediateChestSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", intermediateChestSaveText);
                }
            }
        });

        chestAdvancedButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                final String advancedChestSaveText = advancedChestText.getText().toString().trim();
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);

                if (mondayRB.isChecked()) {
                    documentReference.update("workout_list_monday", advancedChestSaveText);
                }
                else if (tuesdayRB.isChecked()) {
                    documentReference.update("workout_list_tuesday", advancedChestSaveText);
                }
                else if (wednesdayRB.isChecked()) {
                    documentReference.update("workout_list_wednesday", advancedChestSaveText);
                }
                else if (thursdayRB.isChecked()) {
                    documentReference.update("workout_list_thursday", advancedChestSaveText);
                }
                else if (fridayRB.isChecked()) {
                    documentReference.update("workout_list_friday", advancedChestSaveText);
                }
                else if (saturdayRB.isChecked()) {
                    documentReference.update("workout_list_saturday", advancedChestSaveText);
                }
                else if (sundayRB.isChecked()) {
                    documentReference.update("workout_list_sunday", advancedChestSaveText);
                }
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

    public void print() {
        System.out.println("dsadsdsdsaasdsdsadad");
    }

}