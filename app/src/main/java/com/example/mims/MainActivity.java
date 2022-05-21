package com.example.mims;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button w_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Chandanaish Health Complex");

        w_button = findViewById(R.id.w_button);
    }
    public void Selection(View view){
        finish();
        Intent intent = new Intent(this,EntrySelection.class);
        startActivity(intent);
    }
}