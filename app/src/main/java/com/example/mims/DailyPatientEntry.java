package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mims.ModelClasses.DailyPatientModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DailyPatientEntry extends AppCompatActivity {
    EditText xc;
    Spinner sp;
    Button button;
    String XC;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;
    ArrayList<DailyPatientModel> dataList;
    private static final String[] DAYS = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_patient_entry);
        xc = findViewById(R.id.x);
        //ss = findViewById(R.id.sp_show);
        sp = findViewById(R.id.spinner);
        button = findViewById(R.id.set);
        mAuth = FirebaseAuth.getInstance();
        dataList = new ArrayList<>();

        ArrayAdapter aa = new ArrayAdapter(this, R.layout.my_selected_item,DAYS);
        aa.setDropDownViewResource(R.layout.drop_down_item);

        sp.setAdapter(aa);

    }
    public void set_now(View view){
        String a = sp.getSelectedItem().toString().trim();
        //ss.setText(a);

        String XC = xc.getText().toString().trim();
        //XC = Integer.parseInt(SX);
        // int YC = Integer.parseInt(SY);


        //Model m = new Model(XC);
        DocumentReference washingtonRef = db.collection("Stat").document("week");
        if(sp.getSelectedItem().equals("SUN")){
            //y1=XC;
            washingtonRef.update("Sunday", XC+"");

        }
        else if(sp.getSelectedItem().equals("MON")){
            washingtonRef.update("Monday", XC+"");
            //y2=XC;
        }
        else if(sp.getSelectedItem().equals("SAT")){
            washingtonRef.update("Saturday", XC+"");
            //y7=XC;

        }
        else if(sp.getSelectedItem().equals("TUE")){
            washingtonRef.update("Tuesday", XC+"");
           // y3=XC;
        }
        else if(sp.getSelectedItem().equals("FRI")){
            washingtonRef.update("Friday", XC+"");
           // y6=XC;
        }
        else if(sp.getSelectedItem().equals("THU")){
            washingtonRef.update("Thursday", XC+"");
           // y4=XC;

        }
        else if(sp.getSelectedItem().equals("WED")){
            washingtonRef.update("Wednesday", XC+"");
           // y5=XC;
        }

    }
}