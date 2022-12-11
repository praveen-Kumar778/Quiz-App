package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // we make a launch screen which will appear whenever you launch your app
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}