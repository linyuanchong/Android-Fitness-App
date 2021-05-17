package com.example.androidfitnessapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccountPage extends AppCompatActivity {

    TextView accountPageUsername;
    TextView accountPageEmail;
    TextView accountPagePhone;
    TextView accountPageID;
    EditText changesInput;
    Button completeChange;
    Button changeUsername;
    Button changePhone;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    String userEmail;
    boolean isUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        //Link variables to components.
        accountPageUsername             = findViewById(R.id.accountPageUsername);
        accountPageEmail                = findViewById(R.id.accountPageEmail);
        accountPagePhone                = findViewById(R.id.accountPagePhone);
        accountPageID                   = findViewById(R.id.accountPageID);
        changesInput                    = findViewById(R.id.changesInput);
        completeChange                  = findViewById(R.id.completeChange);
        changeUsername                  = findViewById(R.id.changeUsername);
        changePhone                     = findViewById(R.id.changePhone);

        //Create firebase instance.
        fAuth           = FirebaseAuth.getInstance();
        fStore          = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();
        userEmail = fAuth.getCurrentUser().getEmail();

        changesInput.setVisibility(View.GONE);
        completeChange.setVisibility(View.GONE);

        DocumentReference documentReference = fStore.collection("users").document(userID);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                accountPageUsername.setText(documentSnapshot.getString("full_name"));
                accountPageEmail.setText(documentSnapshot.getString("e_mail"));
                accountPagePhone.setText(documentSnapshot.getString("p_hone"));
                accountPageID.setText("ID: " + userID);
            }
        });

        changeUsername.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changesInput.setHint("Input new name here");
                changesInput.setVisibility(View.VISIBLE);
                completeChange.setVisibility(View.VISIBLE);
                isUsername = true;
            }
        });

        changePhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changesInput.setHint("Input new phone number here");
                changesInput.setVisibility(View.VISIBLE);
                completeChange.setVisibility(View.VISIBLE);
                isUsername = false;
            }
        });

        completeChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String changesInputSaveText = changesInput.getText().toString().trim();
                changesInput.setVisibility(View.GONE);
                completeChange.setVisibility(View.GONE);

                if (isUsername == true) {
                    documentReference.update("full_name", changesInputSaveText);
                }
                else if (isUsername == false) {
                    documentReference.update("p_hone", changesInputSaveText);
                }
            }
        });

    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}