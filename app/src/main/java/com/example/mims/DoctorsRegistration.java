package com.example.mims;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mims.ModelClasses.DoctorsRegistrationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorsRegistration extends AppCompatActivity {
    public static final String TAG = "TAG";

    private Button d_button;
    private TextView d_olduser;

    private EditText f_name;
    private EditText fa_name;
    private EditText m_name;
    private EditText age;
    private EditText phone_number;
    private EditText email;
    private EditText address;
    private EditText s_key;

    private FirebaseAuth mAuth;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference doctors = db.collection("Doctors");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_registration);
        d_button = findViewById(R.id.buttonDoctor);
        d_olduser=findViewById(R.id.doctortxt);

        f_name = findViewById(R.id.f_name);
        fa_name = findViewById(R.id.fa_name);
        m_name = findViewById(R.id.m_name);
        age = findViewById(R.id.g_name);
        phone_number = findViewById(R.id.contact);
        email = findViewById(R.id.e_mail);
        address = findViewById(R.id.address);
        s_key = findViewById(R.id.secret_key);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }
    public void doctorRegister(View view){
        finish();

        String fullname = f_name.getText().toString().trim();
        String father_name = fa_name.getText().toString().trim();
        String mother_name = m_name.getText().toString().trim();
        String a_ge = age.getText().toString().trim();
        String Phone = phone_number.getText().toString().trim();
        String E_mail = email.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String password = s_key.getText().toString().trim();


        DoctorsRegistrationModel doctorsRegistrationModel = new DoctorsRegistrationModel(fullname,
                father_name,mother_name,a_ge,Phone,E_mail,Address,password);
        mAuth.createUserWithEmailAndPassword(E_mail,password)
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(TAG, "createUserWithEmail:success");
                    doctors.add(doctorsRegistrationModel);
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(DoctorsRegistration.this, "Authentication successfull",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),DoctorsHomePage.class);
                    startActivity(intent);

                }
                else {
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(DoctorsRegistration.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void alreadyRegistered(View view){
        finish();
        Intent intent = new Intent(this,DoctorsLogin.class);
        startActivity(intent);
    }
}