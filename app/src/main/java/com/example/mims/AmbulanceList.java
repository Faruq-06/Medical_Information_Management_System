package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mims.AdapterClasses.AmbulanceAdapter;
import com.example.mims.AdapterClasses.PatientsAdapter;
import com.example.mims.ModelClasses.AmbulanceModel;
import com.example.mims.ModelClasses.PatientModel_show;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AmbulanceList extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    FloatingActionButton floatingActionButton1;

    RecyclerView rcview;
    ArrayList<AmbulanceModel> dataList;
    FirebaseFirestore db;
    AmbulanceAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_list);

        rcview = findViewById(R.id.recycleView);
        floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton1 = findViewById(R.id.floating_subtract_button);

        rcview.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        myadapter = new AmbulanceAdapter(dataList);
        db = FirebaseFirestore.getInstance();

        db.collection("Ambulance").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d: list){
                            AmbulanceModel obj = d.toObject(AmbulanceModel.class);
                            dataList.add(obj);
                        }
                        rcview.setAdapter(myadapter);
                    }
                });
    }
    public void add_Ambulance(View view){

    }
    public void removeAmbulance(View view){

    }
}