package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminRegistration extends AppCompatActivity {
    private Button adminButton;
    private TextView olduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);
        adminButton = findViewById(R.id.buttonAdmin);
        olduser = findViewById(R.id.admintxt);
    }
    public void adminRegister(View view){
        Intent intent = new Intent(this,AdminHomePage.class);
        startActivity(intent);
    }
    public void alreadyRegistered(View view){
        Intent intent = new Intent(this,AdminLogin.class);
        startActivity(intent);
    }
}