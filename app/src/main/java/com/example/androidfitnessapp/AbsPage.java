package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AbsPage extends AppCompatActivity {

    //Declare variables.
    Button absBeginnerButton;
    TextView beginnerAbsText;
    Button absIntermediateButton;
    TextView intermediateAbsText;
    Button absAdvancedButton;
    TextView advancedAbsText;

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
        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        beginnerAbsText.setMovementMethod(new ScrollingMovementMethod());
        intermediateAbsText.setMovementMethod(new ScrollingMovementMethod());
        advancedAbsText.setMovementMethod(new ScrollingMovementMethod());

        absBeginnerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Set userID.
                userID = fAuth.getCurrentUser().getUid();
                //Get "users" reference.
                DocumentReference documentReference = fStore.collection("users").document(userID);
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
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}