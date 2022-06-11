package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceptionistLogin extends AppCompatActivity {
    private Button r_button;
    private TextView r_newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_login);
        r_button = findViewById(R.id.buttonReceptionist);
        r_newuser = findViewById(R.id.new_user);

    }
    public void receptionistLogin(View view){

        Intent intent = new Intent(this,ReceptionistHomePage.class);
        startActivity(intent);
    }
    public void newUser(View view){
        finish();
        Intent intent = new Intent(this,ReceptionistRegistration.class);
        startActivity(intent);
    }
}