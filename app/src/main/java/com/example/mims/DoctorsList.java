package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mims.AdapterClasses.DoctorsAdapter;
import com.example.mims.ModelClasses.DoctorsModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DoctorsList extends AppCompatActivity {
    RecyclerView rcview;
    ArrayList<DoctorsModel> dataList;
    FirebaseFirestore db;
    DoctorsAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);
        rcview = findViewById(R.id.recycleView);

        rcview.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        myadapter = new DoctorsAdapter(dataList);
        rcview.setAdapter(myadapter);
        db = FirebaseFirestore.getInstance();

        db.collection("Doctors").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d: list){
                            DoctorsModel obj = d.toObject(DoctorsModel.class);
                            dataList.add(obj);
                        }
                    }
                });
    }
}