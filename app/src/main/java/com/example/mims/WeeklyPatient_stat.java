package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class WeeklyPatient_stat extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String[] DAYS = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    int x=0,y1=180,x2=1,y2=300,x3=2,y3=250,x4=3,y4=220,x5=4,y5=228,x6=5,y6=149,x7=6,y7=279;


    Button show;

    BarChart barChart;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_patient_stat);
       // barChart=findViewById(R.id.idBarChart);
        barChart=findViewById(R.id.idBarChart);
       // show = findViewById(R.id.show_btn);
        showBar();
        //drawBarchart();

    }
    public void showBar(){

        DocumentReference docRef = db.collection("Stat").document("week");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("List",documentSnapshot.toString());
                if(documentSnapshot.exists()){
                    // Log.d("Data",documentSnapshot.getString("Saturday"));
                    y7 = Integer.parseInt(documentSnapshot.getString("Saturday"));
                    y1= Integer.parseInt(documentSnapshot.getString("Sunday"));

                    //String decday= AES256.decrypt(documentSnapshot.getString("Monday"));
                    y2 = Integer.parseInt(documentSnapshot.getString("Monday"));
                    y3 = Integer.parseInt((documentSnapshot.getString("Tuesday")));
                    y4 = Integer.parseInt(documentSnapshot.getString("Wednesday"));
                    y5= Integer.parseInt(documentSnapshot.getString("Thursday"));
                    y6 = Integer.parseInt(documentSnapshot.getString("Friday"));
                    drawBarchart();

                }
            }
        });

    }
    private void drawBarchart() {

        ArrayList<BarEntry> barEntries=new ArrayList<>();
        // barEntries.add(new BarEntry(0,10));
        barEntries.add(new BarEntry(x,y1));
        barEntries.add(new BarEntry(x2,y2));
        barEntries.add(new BarEntry(x3,y3));
        barEntries.add(new BarEntry(x4,y4));
        barEntries.add(new BarEntry(x5,y5));
        barEntries.add(new BarEntry(x6,y6));
        barEntries.add(new BarEntry(x7,y7));


        //barEntries.add(new BarEntry(7,20));
        BarDataSet set=new BarDataSet(barEntries,"DataSet");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);
        set.getLabel();
        BarData data=new BarData(set);
        barChart.setData(data);
        configureChartAppearance();
        barChart.invalidate();
        barChart.animateY(500);
    }
    private void configureChartAppearance() {
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return DAYS[(int) value];
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}