package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NursesRegistration extends AppCompatActivity {
    private Button n_button;
    private TextView n_olduser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses_registration);
        n_button = findViewById(R.id.buttonNurse);
        n_olduser = findViewById(R.id.nursetxt);
    }
    public void nurseRegister(View view){
        finish();
        Intent intent = new Intent(this,NursesHomePage.class);
        startActivity(intent);
    }
    public void alreadyRegistered(View view){
        finish();
        Intent intent = new Intent(this,NursesLogin.class);
        startActivity(intent);
    }
}