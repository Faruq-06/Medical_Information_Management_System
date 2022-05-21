package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorsLogin extends AppCompatActivity {
    private Button doctor_button;
    private TextView d_nreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_login);
        doctor_button = findViewById(R.id.button);
        d_nreg = findViewById(R.id.nreg);
    }
    public void doctorLogin(View view)
    {
        finish();
        Intent intent = new Intent(this,DoctorsHomePage.class);
        startActivity(intent);
    }
    public void notRegister(View view)
    {
        finish();
        Intent intent = new Intent(this,DoctorsRegistration.class);
        startActivity(intent);
    }
}