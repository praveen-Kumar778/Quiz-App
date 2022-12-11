package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.ActivityQuizResultBinding;

import java.text.MessageFormat;

public class QuizResult extends AppCompatActivity {
    // Same as other activities we bind the views so that we cannot have to find the views
    ActivityQuizResultBinding quizResultBinding;
    // we are initialize a count integer so that we can implement a press again function using this integer
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizResultBinding = ActivityQuizResultBinding.inflate(getLayoutInflater());
        setContentView(quizResultBinding.getRoot());
        // we are getting the intent from other activity and then going to show it ion this activity
        final int correctAnswer = getIntent().getIntExtra("correct", 0);
        final int incorrectAnswer = getIntent().getIntExtra("incorrect", 0);
        // setting those intents which we get on these two text views
        quizResultBinding.correctAns.setText(MessageFormat.format("Correct Answer : {0}", String.valueOf(correctAnswer)));
        quizResultBinding.incorrectAns.setText(MessageFormat.format("Incorrect Answer : {0}", String.valueOf(incorrectAnswer)));
        // when a user click on start new quiz then the main activity class will be triggered
        quizResultBinding.startNewQuiz.setOnClickListener(v -> {
            startActivity(new Intent(QuizResult.this, MainActivity.class));
            // we finish the activity here so that when a user press back button it will close the app
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        // here first we get count value = 1
        count++;
        // checking if count is 2 then implementing the on back press function
        if(count > 1) {
            super.onBackPressed();
        }// here we are using a handler so that a toast we show a toast to the user of press again to exit and delaying it with 100 millis
        else{
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 count = 1;
                 Toast.makeText(QuizResult.this, "!Press back again to Exit App", Toast.LENGTH_SHORT).show();
             }
         },100);
        }
    }
}