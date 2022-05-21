package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {
    private Button admin_button;
    private TextView notreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        admin_button = findViewById(R.id.buttonAdmin);
        notreg = findViewById(R.id.admintxt);
    }
    public void adminLogin(View view)
    {
        Intent intent = new Intent(this,AdminHomePage.class);
        startActivity(intent);
    }
    public void notRegister(View view){
        Intent intent = new Intent(this,AdminRegistration.class);
        startActivity(intent);
    }
}