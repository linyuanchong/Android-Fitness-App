package com.example.androidfitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Map;

public class SchedulePage extends AppCompatActivity {

    //Declare variables.
    TextView mondaySchedule;
    TextView tuesdaySchedule;
    TextView wednesdaySchedule;
    TextView thursdaySchedule;
    TextView fridaySchedule;
    TextView saturdaySchedule;
    TextView sundaySchedule;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

        //Link variables to components.
        mondaySchedule             = findViewById(R.id.mondaySchedule);
        tuesdaySchedule             = findViewById(R.id.tuesdaySchedule);
        wednesdaySchedule             = findViewById(R.id.wednesdaySchedule);
        thursdaySchedule             = findViewById(R.id.thursdaySchedule);
        fridaySchedule             = findViewById(R.id.fridaySchedule);
        saturdaySchedule             = findViewById(R.id.saturdaySchedule);
        sundaySchedule             = findViewById(R.id.sundaySchedule);

        mondaySchedule.setMovementMethod(new ScrollingMovementMethod());
        tuesdaySchedule.setMovementMethod(new ScrollingMovementMethod());
        wednesdaySchedule.setMovementMethod(new ScrollingMovementMethod());
        thursdaySchedule.setMovementMethod(new ScrollingMovementMethod());
        fridaySchedule.setMovementMethod(new ScrollingMovementMethod());
        saturdaySchedule.setMovementMethod(new ScrollingMovementMethod());
        sundaySchedule.setMovementMethod(new ScrollingMovementMethod());

        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();
        userID          = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                mondaySchedule.setText(documentSnapshot.getString("workout_list_monday"));
                tuesdaySchedule.setText(documentSnapshot.getString("workout_list_tuesday"));
                wednesdaySchedule.setText(documentSnapshot.getString("workout_list_wednesday"));
                thursdaySchedule.setText(documentSnapshot.getString("workout_list_thursday"));
                fridaySchedule.setText(documentSnapshot.getString("workout_list_friday"));
                saturdaySchedule.setText(documentSnapshot.getString("workout_list_saturday"));
                sundaySchedule.setText(documentSnapshot.getString("workout_list_sunday"));
            }
        });


    }
}