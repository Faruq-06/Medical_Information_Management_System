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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdminRegistration extends AppCompatActivity {

    public static final String TAG = "TAG";

    private EditText fullname;
    private EditText father_name;
    private EditText mother_name;
    private EditText age;
    private EditText contact;
    private EditText email;
    private EditText address;
    private EditText secretKey;

    private FirebaseAuth mAuth;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userinfo = db.collection("AdminInfo");


    private Button adminButton;
    private TextView olduser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);
        adminButton = findViewById(R.id.buttonAdmin);
        olduser = findViewById(R.id.admintxt);
        fullname = findViewById(R.id.f_name);
        father_name = findViewById(R.id.fa_name);
        mother_name = findViewById(R.id.m_name);
        age = findViewById(R.id.g_name);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.e_mail);
        address = findViewById(R.id.address);
        secretKey = findViewById(R.id.secret_key);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }

    public void adminRegister(View view){

        String f_name = fullname.getText().toString().trim();
        String fa_name = father_name.getText().toString().trim();
        String m_name = mother_name.getText().toString();
        String phone = contact.getText().toString().trim();
        String add_ress = address.getText().toString().trim();

        String Email = email.getText().toString().trim();
        String password = secretKey.getText().toString().trim();

        AdminRegisterModel adminRegisterModel = new AdminRegisterModel(f_name,fa_name,m_name,phone,add_ress);


        mAuth.createUserWithEmailAndPassword(Email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            userinfo.add(adminRegisterModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(),AdminHomePage.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AdminRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void alreadyRegistered(View view){
        Intent intent = new Intent(this,AdminLogin.class);
        startActivity(intent);
    }
}