package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class PatientHomePage extends AppCompatActivity {
    CardView paybill;
    CardView ambulance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_patient_home_page);
        paybill = findViewById(R.id.pay_bill);
        ambulance = findViewById(R.id.ambulance);
    }
    public void payBill(View view){
        Intent intent = new Intent(this,PayMent.class);
        startActivity(intent);
    }
    public void bookAppointment(View view){
        Intent intent = new Intent(this,PatientsAppointment.class);
        startActivity(intent);
    }
    public void ambulanceList(View view){
        Intent intent = new Intent(this,AmbulanceList.class);
        startActivity(intent);
    }
    public void findDoctors(View view){

    }
}