package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PatientRegistration extends AppCompatActivity {
    private Button p_button;
    private TextView p_olduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        p_button = findViewById(R.id.buttonPatient);

    }
    public void patientRegister(View view){
        Intent intent = new Intent(this,PatientHomePage.class);
        startActivity(intent);
    }
    public void alreadyRegistered(View view){
        Intent intent = new Intent(this,PatientLogin.class);
        startActivity(intent);
    }
}