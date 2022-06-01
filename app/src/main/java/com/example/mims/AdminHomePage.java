package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomePage extends AppCompatActivity {
    private CardView doctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        doctors = findViewById(R.id.doctor);
    }
    public void doctorsList(View view){
        Intent intent = new Intent(this,DoctorsList.class);
        startActivity(intent);
    }
}