package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EntrySelection extends AppCompatActivity {
    Button dbutton;
    Button nbutton;
    Button adbutton;
    Button pbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_selection);
        dbutton = findViewById(R.id.imdoctor);
        nbutton = findViewById(R.id.imnurse);
        adbutton = findViewById(R.id.imadmin);
        pbutton = findViewById(R.id.impatient);
    }
    public void iamAdmin(View view){
        Intent intent = new Intent(this,AdminLogin.class);
        startActivity(intent);
    }
    public void iamDoctor(View view){
        Intent intent = new Intent(this,DoctorsLogin.class);
        startActivity(intent);
    }
    public void iamNurse(View view){
        Intent intent = new Intent(this,NursesLogin.class);
        startActivity(intent);
    }
    public void iamPatient(View view){
        Intent intent = new Intent(this,PatientLogin.class);
        startActivity(intent);
    }
    public void iamReceptionist(View view){
        Intent intent = new Intent(this,ReceptionistLogin.class);
        startActivity(intent);
    }
}