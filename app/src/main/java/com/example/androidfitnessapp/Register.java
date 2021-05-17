package com.example.androidfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    //Declare variables.
    EditText rFullName,rEmail,rPassword,rPhone;
    Button rRegisterButton;
    TextView rLoginButton;
    ProgressBar rProgressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Link variables to components.
        rFullName       = findViewById(R.id.loginLayout);
        rEmail          = findViewById(R.id.rEmail);
        rPassword       = findViewById(R.id.rPassword);
        rPhone          = findViewById(R.id.rPhone);
        rRegisterButton = findViewById(R.id.rRegisterButton);
        rLoginButton    = findViewById(R.id.rLoginButton);
        rProgressBar    = findViewById(R.id.rProgressBar);
        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        //If user not exist.
        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), LandingPage.class));
            finish();
        }

        //When register button clicked.
        rRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from editTexts.
                final String email              = rEmail.getText().toString().trim();
                String password                 = rPassword.getText().toString().trim();
                final String fullName           = rFullName.getText().toString();
                final String phone              = rPhone.getText().toString();
                final FirebaseDatabase database = FirebaseDatabase.getInstance();

                //Error detections.
                if(TextUtils.isEmpty(email)){
                    rEmail.setError("Require an Email.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    rPassword.setError("Require a password.");
                    return;
                }
                if(password.length() < 6){
                    rPassword.setError("Require password to be more than 6 characters.");
                    return;
                }

                //Set progress bar to be visible.
                rProgressBar.setVisibility(View.VISIBLE);

                //Register the user into firebase.
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created successfully.", Toast.LENGTH_SHORT).show();

                            //Set userID.
                            userID = fAuth.getCurrentUser().getUid();
                            //Get "users" reference.
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            //Create and store data using hashmap.
                            Map<String, Object> user = new HashMap<>();
                            //Store values into user hashmap.
                            user.put("e_mail", email);
                            user.put("pass_word", password);
                            user.put("full_name", fullName);
                            user.put("p_hone", phone);
                            user.put("workout_list_monday", "");
                            user.put("workout_list_tuesday", "");
                            user.put("workout_list_wednesday", "");
                            user.put("workout_list_thursday", "");
                            user.put("workout_list_friday", "");
                            user.put("workout_list_saturday", "");
                            user.put("workout_list_sunday", "");
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    System.out.println("successfully created new user" + userID);
                                }
                            });
                            
                            startActivity(new Intent(getApplicationContext(), LandingPage.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error, can't sign you up." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            rProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });



        rLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }
}