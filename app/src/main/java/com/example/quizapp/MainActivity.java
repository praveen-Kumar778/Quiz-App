package com.example.quizapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //First we have to find the views of every xml file so to make it easier i use the binding feature
    //It will automatically bind the views between xml and java
    ActivityMainBinding mainBinding ;
    // putting the topic name so we can fetch the data from list using this string
    private String selectedTopicName = "" ;
    //it is used here to put the image inside the image view
    int resId = 0 ;
    int count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // here we bind the view with the layout
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        SharedPreferences preferences = getSharedPreferences("check", Context.MODE_PRIVATE);
        String checking = preferences.getString("topicName","");
        if(checking.isEmpty()) {

            // here we are performing the actions when a user click on the buttons
            mainBinding.javaLayout.setOnClickListener(v -> {
                // next we are setting the topic name , image  and the background of java layout
                selectedTopicName = "JAVA";
                resId = R.drawable.java;
                mainBinding.javaLayout.setBackgroundResource(R.drawable.background_selected);
                mainBinding.androidLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.htmlLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.phpLayout.setBackgroundResource(R.drawable.round_back);
                //When a user select any topic ten the button will be enabled
                mainBinding.startBtn.setEnabled(true);
                mainBinding.startBtn.setBackgroundResource(R.drawable.round_start);
            });

            mainBinding.phpLayout.setOnClickListener(v -> {
                // next we are setting the topic name , image  and the background of Php layout
                selectedTopicName = "PHP";
                resId = R.drawable.php;
                mainBinding.phpLayout.setBackgroundResource(R.drawable.background_selected);
                mainBinding.androidLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.htmlLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.javaLayout.setBackgroundResource(R.drawable.round_back);
                //When a user select any topic ten the button will be enabled
                mainBinding.startBtn.setEnabled(true);
                mainBinding.startBtn.setBackgroundResource(R.drawable.round_start);
            });
            mainBinding.htmlLayout.setOnClickListener(v -> {
                // next we are setting the topic name , image  and the background of HTML layout
                selectedTopicName = "HTML";
                resId = R.drawable.html_icon;
                mainBinding.htmlLayout.setBackgroundResource(R.drawable.background_selected);
                mainBinding.androidLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.phpLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.javaLayout.setBackgroundResource(R.drawable.round_back);
                //When a user select any topic ten the button will be enabled
                mainBinding.startBtn.setEnabled(true);
                mainBinding.startBtn.setBackgroundResource(R.drawable.round_start);
            });
            mainBinding.androidLayout.setOnClickListener(v -> {
                // next we are setting the topic name , image  and the background of Android layout
                selectedTopicName = "ANDROID";
                resId = R.drawable.android;
                mainBinding.androidLayout.setBackgroundResource(R.drawable.background_selected);
                mainBinding.phpLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.htmlLayout.setBackgroundResource(R.drawable.round_back);
                mainBinding.javaLayout.setBackgroundResource(R.drawable.round_back);
                //When a user select any topic ten the button will be enabled
                mainBinding.startBtn.setEnabled(true);
                mainBinding.startBtn.setBackgroundResource(R.drawable.round_start);
            });

            mainBinding.startBtn.setOnClickListener(v -> {
                // when a user click on start button if user doesn't selected any topic the if statement implement and show a snackbar with the message
                if (selectedTopicName.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "!Please Select A Topic First", Snackbar.LENGTH_SHORT);
                    View view = snackbar.getView();
                    view.setBackgroundColor(Color.RED);
                    snackbar.show();
                }// If user doesn't select anything so we start the intent and open that particular file which we save in the string
                else {
                    // we are passing the intent of topic and the image so that we can use it in other activity
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    // here we are clearing the last task which is in que and implementing the new task  from start
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("topicName", selectedTopicName);
                    editor.putInt("img",resId);
                    editor.apply();
                }
            });
        }else{
            startActivity(new Intent(MainActivity.this,QuizActivity.class));
        }
    }
    @Override
    public void onBackPressed() {
        // when a user press the back button it will trigger alert dialog builder and show a dialog box with title icon name and message with two buttons
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setIcon(R.drawable.quizicon);
            alert.setTitle("Quiz App");
            alert.setMessage("Thanks for using the App.\nPlease give 'Rate & Review' this app as your feedback and suggestions.\nFor more improvement in App.")
                    .setCancelable(true)
                    // next we are performing some action when a user click on positive or either negative button
                    .setPositiveButton("Exit", (dialog, which) -> finish());
            if(count == 0){
                alert.setNegativeButton("RATE AND REVIEW", (dialog,which) ->{
                        Toast.makeText(MainActivity.this, "Nothing Happens on Rate and Review", Toast.LENGTH_SHORT).show();
                        count++;
                });
            }
            // finally showing the alert dialog box to the user
            alert.show();
        }
}