package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class ReceptionistHomePage extends AppCompatActivity {
    CardView data_entry1;
    CardView ambulance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptionist_home_page);
        data_entry1 = findViewById(R.id.data_Entry);
        ambulance = findViewById(R.id.ambulance);
    }
    public void entryData(View view){

        Intent intent = new Intent(this, DataEntry.class);
        startActivity(intent);
        /*Intent intent = new Intent(this,DailyPatientEntry.class);
        startActivity(intent);*/
    }
    public void ambulanceList(View view){
        Intent intent = new Intent(this,AmbulanceList.class);
        startActivity(intent);
    }
}