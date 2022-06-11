package com.example.mims;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mims.ModelClasses.AddNurseModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class NurseUpdate extends AppCompatActivity {

    TextInputEditText fullname;
    TextInputEditText p_hone;
    TextInputEditText e_mail;
    TextInputEditText w_ard;
    TextInputEditText d_ept;
    TextInputEditText s_key;
    String id;

    Button button;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_update);

        fullname = findViewById(R.id.name);
        p_hone = findViewById(R.id.phone1);
        e_mail = findViewById(R.id.e_mail);
        w_ard = findViewById(R.id.ward_no);
        d_ept = findViewById(R.id.specialize);
        s_key = findViewById(R.id.s_key);

        button = findViewById(R.id.add_nurse);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                /*AddNurseModel addNurseModel = new AddNurseModel(AES256.encrypt(fullname.getText().toString()),
                        AES256.encrypt(phone.getText().toString()),AES256.encrypt(e_mail.getText().toString()),
                        AES256.encrypt(ward.getText().toString()),
                        AES256.encrypt(dept.getText().toString()),AES256.encrypt(s_key.getText().toString()));*/

                HashMap<String, Object> users = new HashMap<>();
                users.put("fullname",AES256.encrypt(fullname.getText().toString() ));
                users.put("phone",AES256.encrypt(p_hone.getText().toString() ));
                users.put("email",AES256.encrypt(e_mail.getText().toString() ));
                users.put("speciality",AES256.encrypt(d_ept.getText().toString() ));
                users.put("w_number",AES256.encrypt(w_ard.getText().toString() ));
                users.put("password",AES256.encrypt(s_key.getText().toString() ));

                FirebaseFirestore.getInstance().collection("Nurses")
                        .document(id).update(users)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(NurseUpdate.this,"Data Updated succesfully",
                                        Toast.LENGTH_LONG).show();
                                startActivity(new Intent(NurseUpdate.this,NurseList.class));
                            }
                        });
            }
        });
        /*mFirebaseFirestore
                .collection("users")
                .document(mFirebaseAuth.getUid())
                .update(userMap)*/



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            String email = extras.getString("email");
            String ward = extras.getString("ward");
            String pass = extras.getString("pass");
            String dept = extras.getString("dept");
            String phone = extras.getString("phone");
             id = extras.getString("id");

            fullname.setText(AES256.decrypt(name));
            e_mail.setText(AES256.decrypt(email));
            w_ard.setText(AES256.decrypt(ward));
            s_key.setText(AES256.decrypt(pass));
            d_ept.setText(AES256.decrypt(dept));
            p_hone.setText(AES256.decrypt(phone));




        }
    }
}