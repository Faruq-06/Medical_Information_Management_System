package com.example.mims;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mims.ModelClasses.AddDoctorsModel;
import com.example.mims.ModelClasses.DoctorsRegistrationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Add_Doctors extends AppCompatActivity {

    public static final String TAG = "TAG";

    private Button add_button;
    //private TextView d_olduser;

    private EditText f_name;
    private EditText fa_name;
    private EditText m_name;
    private EditText age;
    private EditText phone_number;
    private EditText email;
    private EditText address;
   // private EditText speciality;
    private EditText s_key;

    private FirebaseAuth mAuth;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference doctors = db.collection("Doctors");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctors);
        f_name = findViewById(R.id.fullname);
        fa_name = findViewById(R.id.father_name);
        m_name = findViewById(R.id.mother_name);
        age = findViewById(R.id.age);
        phone_number = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        //speciality = findViewById(R.id.specialist);
        s_key = findViewById(R.id.password);
        add_button = findViewById(R.id.add_doctor);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


    }
    public void addDoctorsInfo(View view){
        finish();

        String fullname = f_name.getText().toString().trim();
        String father_name = fa_name.getText().toString().trim();
        String mother_name = m_name.getText().toString().trim();
        String a_ge = age.getText().toString().trim();
        String Phone = phone_number.getText().toString().trim();
        String E_mail = email.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String password = s_key.getText().toString().trim();
       // String speciality1 = speciality.getText().toString().trim();


        AddDoctorsModel adddoctorsModel = new AddDoctorsModel(fullname,
                father_name,mother_name,a_ge,Phone,E_mail,Address,password);
        mAuth.createUserWithEmailAndPassword(E_mail,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            doctors.add(adddoctorsModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Add_Doctors.this, "Authentication successfull",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),DoctorsList.class);
                            startActivity(intent);

                        }
                        else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Add_Doctors.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}