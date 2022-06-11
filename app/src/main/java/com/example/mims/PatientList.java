package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mims.AdapterClasses.NurseAdapter;
import com.example.mims.AdapterClasses.PatientsAdapter;
import com.example.mims.ModelClasses.NurseModel;
import com.example.mims.ModelClasses.PatientModel;
import com.example.mims.ModelClasses.PatientModel_show;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class PatientList extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    FloatingActionButton floatingActionButton1;

    RecyclerView rcview;
    ArrayList<PatientModel_show> dataList;
    FirebaseFirestore db;
    PatientsAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        rcview = findViewById(R.id.recycleView);
        floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton1 = findViewById(R.id.floating_subtract_button);

        rcview.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        myadapter = new PatientsAdapter(dataList);
        db = FirebaseFirestore.getInstance();

        db.collection("Patients").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d: list){
                            PatientModel_show obj = d.toObject(PatientModel_show.class);
                            dataList.add(obj);
                        }
                        rcview.setAdapter(myadapter);
                    }
                });
    }
    public void addpatient(View view){

    }
    public void removePatient(View view){

    }
}