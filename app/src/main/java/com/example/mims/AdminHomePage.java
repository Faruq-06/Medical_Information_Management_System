package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminHomePage extends AppCompatActivity {
    private CardView doctors;
    private CardView nurses;
    private CardView hstat;
    private CardView patient1;
    private CardView ambulance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        doctors = findViewById(R.id.doctor);
        nurses = findViewById(R.id.nurse);
        hstat = findViewById(R.id.stat);
        patient1 = findViewById(R.id.patient);
        ambulance = findViewById(R.id.ambulance);
    }
    public void doctorsList(View view){
        Intent intent = new Intent(this,DoctorsList.class);
        startActivity(intent);
    }
    public void nursesList(View view){
        Intent intent = new Intent(this,NurseList.class);
        startActivity(intent);
    }
    public void patient_List(View view){
        Intent intent = new Intent(this,PatientList.class);
        startActivity(intent);

    }
    public void findAmbulance(View view){
        Intent intent = new Intent(this,AmbulanceList.class);
        startActivity(intent);
    }

    public void h_statistics(View view){
        Intent intent = new Intent(this,HospitalStat.class);
        startActivity(intent);

    }


}