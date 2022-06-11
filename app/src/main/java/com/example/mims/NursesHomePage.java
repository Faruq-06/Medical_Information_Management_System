package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NursesHomePage extends AppCompatActivity {
    CardView ambulance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses_home_page);
        ambulance = findViewById(R.id.ambulance);
    }
    public void listAmbulance(View view){
        Intent intent = new Intent(this,AmbulanceList.class);
        startActivity(intent);
    }
}