package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Appointment extends AppCompatActivity {
    private DatePicker picker;
    private TextView appointment_date;
    //private String apd;
    private String apd;
    public static final String EXTRA_MESSAGE = "message";

    AppointmentDate ad = new AppointmentDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        appointment_date = findViewById(R.id.ViewAppointMentsDate);


    }
    public void dateSelect(View view){

    }
}