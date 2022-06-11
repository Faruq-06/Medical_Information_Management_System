package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataEntry extends AppCompatActivity {
    Button patient_btn;
    Button ambulance_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        patient_btn = findViewById(R.id.patient_entry);
        ambulance_btn = findViewById(R.id.ambulance);
    }
    public void dailyPatient(View view){
        Intent intent = new Intent(this,DailyPatientEntry.class);
        startActivity(intent);
    }
    public void addAmbulance(View view){

    }
}