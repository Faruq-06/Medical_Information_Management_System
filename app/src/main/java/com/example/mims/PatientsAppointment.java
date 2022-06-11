package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mims.ModelClasses.AppointmentModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class PatientsAppointment extends AppCompatActivity {
    TextInputLayout textInputLayout;
    AutoCompleteTextView autoCompleteTextView;
    TextInputLayout textInputLayout1;
    AutoCompleteTextView autoCompleteTextView1;
    TextInputEditText fullname;
    TextInputEditText Y_age;

    TimePicker timePicker;
    Button appointment;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_appointment);

        textInputLayout = findViewById(R.id.menu);
        autoCompleteTextView = findViewById(R.id.drop_items);
        textInputLayout1 = findViewById(R.id.genderlayout);
        autoCompleteTextView1 = findViewById(R.id.gender);
        timePicker = findViewById(R.id.timepicker);
        appointment = findViewById(R.id.appointment1);
        fullname = findViewById(R.id.name);
        Y_age = findViewById(R.id.age);
        String [] dept = {"Neurology","Urology","Anesthesiology","Cardiology","Burn Center","ODP",
                "Medicine","ENT","Hematology","Orthopedics","Physiotherapy"};
        String [] gender = {"Male","Female"};
        ArrayAdapter<String> itemAdapter =
                new ArrayAdapter<>(PatientsAppointment.this,R.layout.dept_list,dept);
        autoCompleteTextView.setAdapter(itemAdapter);
        ArrayAdapter<String> itemAdapter1 =
                new ArrayAdapter<>(PatientsAppointment.this,R.layout.dept_list,gender);
        autoCompleteTextView1.setAdapter(itemAdapter1);
        timePicker.setIs24HourView(true);





    }
    public void appointment(View view){

        String name = fullname.getText().toString().trim();
        String department = textInputLayout.getEditText().getText().toString().trim();
        String age = Y_age.getText().toString().trim();

        String gender = textInputLayout1.getEditText().getText().toString().trim();
        int hrs = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();
        int token =  new Random().nextInt(1000) + 1000;

        String hours = String.valueOf(hrs);
        String minutes = String.valueOf(min);

        String token_Number = String.valueOf(token);

        AppointmentModel appointmentModel = new AppointmentModel(department,name,age,
                gender,hours+":"+minutes,token_Number);

        if(timePicker.getCurrentHour()<=14){
            db.collection("Appointment").document(name).set(appointmentModel).
                    addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(getApplicationContext(),"Appointment taken succesfully",
                            Toast.LENGTH_SHORT).show();

                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"choose the time before 2:00pm",
                    Toast.LENGTH_SHORT).show();
        }

    }
}