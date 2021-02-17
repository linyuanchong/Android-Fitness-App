package com.example.androidfitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    //Declare variables.
    EditText lEmail, lPassword;
    Button lLoginButton;
    TextView lRegisterButton;
    ProgressBar lProgressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Link variables to components.
        lEmail          = findViewById(R.id.lEmail);
        lPassword       = findViewById(R.id.lPassword);
        lLoginButton    = findViewById(R.id.lLoginButton);
        lRegisterButton = findViewById(R.id.lRegisterButton);
        lProgressBar    = findViewById(R.id.lProgressBar);
        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();

        lLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from editTexts.
                final String email = lEmail.getText().toString().trim();
                String password = lPassword.getText().toString().trim();

                //Error detections.
                if(TextUtils.isEmpty(email)){
                    lEmail.setError("Require an Email.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    lPassword.setError("Require a password.");
                    return;
                }
                if(password.length() < 6){
                    lPassword.setError("Require password to be more than 6 characters.");
                    return;
                }

                //Set progress bar to be visible.
                lProgressBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LandingPage.class));
                        }
                        else {
                            Toast.makeText(Login.this, "Error, can't log you in. " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            lProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        lRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }
}
