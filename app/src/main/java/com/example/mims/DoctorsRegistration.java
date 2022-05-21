package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorsRegistration extends AppCompatActivity {
    private Button d_button;
    private TextView d_olduser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_registration);
        d_button = findViewById(R.id.buttonDoctor);
        d_olduser=findViewById(R.id.doctortxt);
    }
    public void doctorRegister(View view){
        Intent intent = new Intent(this,DoctorsHomePage.class);
        startActivity(intent);
    }
    public void alreadyRegistered(View view){
        finish();
        Intent intent = new Intent(this,DoctorsLogin.class);
        startActivity(intent);
    }
}