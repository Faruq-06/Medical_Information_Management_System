package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NursesLogin extends AppCompatActivity {
    private Button n_button;
    private TextView nreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurses_login);
        n_button = findViewById(R.id.n_button);
        nreg = findViewById(R.id.n_nreg);
    }
    public void nurseLogin(View view)
    {
        finish();
        Intent intent = new Intent(this,NursesHomePage.class);
        startActivity(intent);
    }
    public void notRegister(View view)
    {
        finish();
        Intent intent = new Intent(this,NursesRegistration.class);
        startActivity(intent);
    }
}