package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mims.AdapterClasses.DoctorsAdapter;
import com.example.mims.AdapterClasses.NurseAdapter;
import com.example.mims.ModelClasses.DoctorsModel;
import com.example.mims.ModelClasses.NurseModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class NurseList extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    RecyclerView rcview;
    ArrayList<NurseModel> dataList;
    FirebaseFirestore db;
    NurseAdapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_list);

        rcview = findViewById(R.id.recycleView);
        floatingActionButton = findViewById(R.id.floating_action_button);

        rcview.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        myadapter = new NurseAdapter(dataList,this);
        db = FirebaseFirestore.getInstance();

        db.collection("Nurses").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d: list){
                            dataList.add(new NurseModel(
                                    d.getString("fullname"),
                                    d.getString("phone"),
                                    d.getString("w_number"),
                                    d.getString("email"),
                                    d.getString("speciality"),
                                    d.getString("password"),

                                    d.getId()
                            ));
                        }
                        rcview.setAdapter(myadapter);
                    }
                });

    }
    public void addNurse(View view){
        finish();
        Intent intent = new Intent(this,AddNurse.class);
        startActivity(intent);

    }
    public void removeNurse(View view){
        finish();

    }
}