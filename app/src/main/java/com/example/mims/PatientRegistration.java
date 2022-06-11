package com.example.mims;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mims.ModelClasses.PatientModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.sql.StatementEvent;

public class PatientRegistration extends AppCompatActivity {
    private Button p_button;
    private TextView p_olduser;
    EditText fullname;
    EditText age;
    EditText phone;
    EditText email;
    EditText password;

    //for create auth instance
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference nurses = db.collection("Patients");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        p_button = findViewById(R.id.buttonPatient);
        fullname = findViewById(R.id.fullname);
        age = findViewById(R.id.age);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void patientRegister(View view){
        String name = fullname.getText().toString().trim();
        String age1 = age.getText().toString().trim();
        String contact = phone.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String s_key = password.getText().toString().trim();

        PatientModel patientModel = new PatientModel(AES256.encrypt(name),AES256.encrypt(age1),
                AES256.encrypt(contact),AES256.encrypt(e_mail),AES256.encrypt(s_key));
        mAuth.createUserWithEmailAndPassword(e_mail,s_key)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                           // Log.d(TAG, "createUserWithEmail:success");
                            nurses.add(patientModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(PatientRegistration.this, "Authentication successfull",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),PatientHomePage.class);
                            startActivity(intent);

                        }
                        else {
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(PatientRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void alreadyRegistered(View view){
        Intent intent = new Intent(this,PatientLogin.class);
        startActivity(intent);
    }
}