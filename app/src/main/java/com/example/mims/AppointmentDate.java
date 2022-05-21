package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class AppointmentDate extends AppCompatActivity {
    private DatePicker picker;
    private Button displaydate;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_date);
        picker = findViewById(R.id.datePicker);
        displaydate = findViewById(R.id.date_button);
        textView1 = findViewById(R.id.textView1);
        textView1.setText("Current Date: "+getCurrentDate());

    }
    public String getCurrentDate(){
        StringBuilder builder = new StringBuilder();
        builder.append(picker.getMonth()+1+"/");
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }
    public void selectDate(View view){
        finish();
        textView1.setText("Selected date is: "+getCurrentDate());
        Intent intent = new Intent(this,Appointment.class);
        String sDate = getCurrentDate();
        intent.putExtra(Appointment.EXTRA_MESSAGE,sDate);
        startActivity(intent);
    }
}