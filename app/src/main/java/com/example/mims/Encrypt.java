package com.example.mims;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class Encrypt extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        String originalString = "howtodoinjava.com";

        String encryptedString = AES256.encrypt(originalString);
        Log.d("encryptedString",encryptedString);
        String decryptedString = AES256.decrypt(encryptedString);
        Log.d("dec",decryptedString);
    }
}