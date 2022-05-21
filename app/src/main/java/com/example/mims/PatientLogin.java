package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PatientLogin extends AppCompatActivity {
    private Button p_button;
    private TextView p_newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

    }
    public void pLogin(View view){
        finish();
        Intent intent = new Intent(this,PatientHomePage.class);
        startActivity(intent);
    }
    public void notRegister(View view)
    {
        finish();
        Intent intent = new Intent(this,PatientRegistration.class);
        startActivity(intent);
    }
}