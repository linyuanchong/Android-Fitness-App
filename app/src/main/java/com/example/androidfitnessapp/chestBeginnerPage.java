package com.example.androidfitnessapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class chestBeginnerPage extends AppCompatActivity {

    //Declare variables.
    Button chestBeginnerButton, chestBeginnerButtonSchedule, chestBeginnerButtonSave;
    TextView beginnerChestText;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_beginner_page);

        //Link variables to components.
        chestBeginnerButton             = findViewById(R.id.chestBeginnerButton);
        chestBeginnerButtonSchedule             = findViewById(R.id.chestBeginnerButtonSchedule);
        chestBeginnerButtonSave             = findViewById(R.id.chestBeginnerButtonSave);
        beginnerChestText             = findViewById(R.id.beginnerChestText);

        beginnerChestText.setMovementMethod(new ScrollingMovementMethod());

        // on click beginner workout - open new intent
        chestBeginnerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), chestBeginnerPage.class));
            }
        });
        
        chestBeginnerButtonSchedule.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //getting current day,month and year.
                Calendar calendar = Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(chestBeginnerPage.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day)
                    {
                        edittext.setText("" + day + " - " + (month+1) + " - " + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void backHomeFunc(View view) {
        startActivity(new Intent(getApplicationContext(), LandingPage.class));
    }

}
