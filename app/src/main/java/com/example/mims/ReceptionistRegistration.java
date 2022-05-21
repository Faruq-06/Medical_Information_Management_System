package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceptionistRegistration extends AppCompatActivity {
    private Button r_button;
    private TextView r_olduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_registration);
        r_button = findViewById(R.id.buttonReceptionist);
        r_olduser = findViewById(R.id.receptionisttxt);
    }
    public void receptionistRegister(View view){
        finish();
        Intent intent = new Intent(this,ReceptionistHomePage.class);
        startActivity(intent);
    }
    public void alreadyRegistered(View view){
        finish();
        Intent intent = new Intent(this,ReceptionistLogin.class);
        startActivity(intent);
    }
}