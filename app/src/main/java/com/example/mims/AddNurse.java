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
import android.widget.Toast;

import com.example.mims.ModelClasses.AddNurseModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddNurse extends AppCompatActivity {

    TextInputEditText fullname;
    TextInputEditText phone;
    TextInputEditText e_mail;
    TextInputEditText ward;
    TextInputEditText dept;
    TextInputEditText s_key;
    Button button;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private CollectionReference nurses = db.collection("Nurses");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nurse);
        fullname = findViewById(R.id.name);
        phone = findViewById(R.id.phone1);
        e_mail = findViewById(R.id.e_mail);
        ward = findViewById(R.id.ward_no);
        dept = findViewById(R.id.specialize);
        s_key = findViewById(R.id.s_key);

        button = findViewById(R.id.add_nurse);


    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void add(View view){

        String name = fullname.getText().toString().trim();
        String contact = phone.getText().toString().trim();
        String email = e_mail.getText().toString().trim();
        String ward_no = ward.getText().toString().trim();
        String department = dept.getText().toString().trim();
        String password = s_key.getText().toString().trim();

        AddNurseModel addNurseModel = new AddNurseModel(AES256.encrypt(name),
                AES256.encrypt(contact),AES256.encrypt(email),
                AES256.encrypt(ward_no),AES256.encrypt(department),AES256.encrypt(password));
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Log.d(TAG, "createUserWithEmail:success");
                            nurses.add(addNurseModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(AddNurse.this, "Authentication successfull",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),NurseList.class);
                            startActivity(intent);

                        }
                        else {
                           // Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AddNurse.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }
}