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

import com.example.mims.ModelClasses.DoctorsRegistrationModel;
import com.example.mims.ModelClasses.NurseRegistrationModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.remote.Stream;

public class NursesRegistration extends AppCompatActivity {
    private Button n_button;
    private TextView n_olduser;

    public static final String TAG = "TAG";

    private Button add_button;
    //private TextView d_olduser;

    private EditText f_name;
    private EditText fa_name;
    private EditText speciality;
    private EditText word_number;
    private EditText email;
    private EditText address;
    private EditText contact;
    // private EditText speciality;
    private EditText s_key;

    //for create auth instance
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference nurses = db.collection("Nurses");

    //private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses_registration);

        f_name = findViewById(R.id.fullname);
        fa_name = findViewById(R.id.father_name);
        speciality = findViewById(R.id.speciality);
        word_number = findViewById(R.id.w_number);
        contact = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        s_key = findViewById(R.id.password);


        n_button = findViewById(R.id.buttonNurse);
       // n_olduser = findViewById(R.id.nursetxt);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nurseRegister(View view){
        finish();

        String fullname = f_name.getText().toString().trim();
        String father_name = fa_name.getText().toString().trim();
        String speciality1 = speciality.getText().toString().trim();
        String word = word_number.getText().toString().trim();
        String phone = contact.getText().toString().trim();
        String e_mail = email.getText().toString().trim();
        String address1 = address.getText().toString().trim();
        String password = s_key.getText().toString().trim();
        NurseRegistrationModel nurseRegistrationModel = new NurseRegistrationModel(AES256.encrypt(fullname),
                AES256.encrypt(father_name),AES256.encrypt(word),AES256.encrypt(speciality1),
                AES256.encrypt(phone),AES256.encrypt(e_mail),AES256.encrypt(address1),AES256.encrypt(password));
        mAuth.createUserWithEmailAndPassword(e_mail,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            nurses.add(nurseRegistrationModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(NursesRegistration.this, "Authentication successfull",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),NursesHomePage.class);
                            startActivity(intent);

                        }
                        else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(NursesRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        /*NurseRegistrationModel nurseRegistrationModel = new NurseRegistrationModel(fullname,father_name,word,
                speciality1,phone,e_mail,address1,password);
        mAuth.createUserWithEmailAndPassword(e_mail,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            nurses.add(nurseRegistrationModel);
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(NursesRegistration.this, "Authentication successfull",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),NursesHomePage.class);
                            startActivity(intent);
                        }
                        else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(NursesRegistration.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

    }
    public void alreadyRegistered(View view){
        finish();
        Intent intent = new Intent(this,NursesLogin.class);
        startActivity(intent);
    }
}