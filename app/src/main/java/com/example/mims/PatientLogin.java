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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PatientLogin extends AppCompatActivity {
    private Button p_button;
    private TextView p_newuser;

    private TextInputEditText email;
    private TextInputEditText password;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        p_button = findViewById(R.id.button);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void pLogin(View view){
      //  finish();
        //final boolean[] success = {false};
        String e_mail = email.getText().toString().trim();
        String password1 = password.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(e_mail, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                           // Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(getApplicationContext(),PatientHomePage.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(PatientLogin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }
    public void notRegister(View view)
    {
        finish();
        Intent intent = new Intent(this,PatientRegistration.class);
        startActivity(intent);
    }
}