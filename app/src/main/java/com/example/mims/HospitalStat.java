package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalStat extends AppCompatActivity {
    private Button p_entry;
    private Button u_satisfaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_stat);
        p_entry = findViewById(R.id.patient_entry);
        u_satisfaction = findViewById(R.id.user_satisfaction);
    }
    public void weekly_patient(View view){
        Intent intent = new Intent(this,WeeklyPatient_stat.class);
        startActivity(intent);

    }
    public void user_satisfaction(View view){

    }
}