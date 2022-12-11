package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.ActivityQuizBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    // First we bind the views so we can skip the part of find by view id to make it easier
    ActivityQuizBinding quizBinding ;
    // Next we are Using List Using Question List Class to perform some activities
    private List<QuestionList> questionLists ;
    // in this variable we actually going to get the current question position
    private int currentQuestionPosition = 0 ;
    // In this string we will get that which option is selected by the user and set it in this string
    private String selectedOptionByUser = "" ;
    // this variable is used to Confirm that if a user selected one option then it will not click another one
    private int selectedOption = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quizBinding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(quizBinding.getRoot());
        // First we are getting the intent which is passed from Main activity the topic name,imageId and setting it inside a string and int
        final String getSelectedTopicName = getIntent().getStringExtra("topic");
        final int getImage = getIntent().getIntExtra("img",0);
        // here we are setting the image and string we get from main activity
        quizBinding.selectedTopic.setText(getSelectedTopicName);
        quizBinding.img.setImageResource(getImage);
        // in this line of code we are using List with a type of QuestionList class var name questionLists to set something inside that
        // inside that questionLists we are using Question activity calling get question function with the selected topic name by the user
        questionLists = QuestionActivity.getQuestions(getSelectedTopicName);
        // here we are using binding to bind with the views and setting all the things which we get from our question lists
        quizBinding.questionsCounter.setText(MessageFormat.format("{0}/{1}", currentQuestionPosition + 1, questionLists.size()));
        quizBinding.questions.setText(questionLists.get(0).getQuestion());
        quizBinding.option1.setText(questionLists.get(0).getOption1());
        quizBinding.option2.setText(questionLists.get(0).getOption2());
        quizBinding.option3.setText(questionLists.get(0).getOption3());
        quizBinding.option4.setText(questionLists.get(0).getOption4());
        // next we are performing some function on the button clicked by the User
        quizBinding.back.setOnClickListener(v ->{
            // if user press back button it will open the main activity
            startActivity(new Intent(QuizActivity.this,MainActivity.class));
        });
        quizBinding.option1.setOnClickListener(v ->{
            // here we will check if the selected option is 0 then run the code and if not then do not run this code
            if(selectedOption == 0) {
                selectedOption = 1 ;
                // here if user click this button and we get the value 0 then we set the selected option string by getting the option string name
                selectedOptionByUser = quizBinding.option1.getText().toString();
                //setting this function if the answer is wrong
                quizBinding.option1.setTextColor(Color.WHITE);
                quizBinding.option1.setBackgroundResource(R.drawable.background_option_red_color);
                // calling the function to check which question is right
                revealAnswer();
                // at last we are setting the user selected answer so we can check which one is correct and which one is incorrect
                questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });
        quizBinding.option2.setOnClickListener(v ->{
            // here we will check if the selected option is 0 then run the code and if not then do not run this code
            if (selectedOption == 0){
                selectedOption = 1 ;
            // here if user click this button and we get the value 0 then we set the selected option string by getting the option string name
            selectedOptionByUser = quizBinding.option2.getText().toString() ;
            //setting this function if the answer is wrong
            quizBinding.option2.setTextColor(Color.WHITE);
            quizBinding.option2.setBackgroundResource(R.drawable.background_option_red_color);
            // calling the function to check which question is right
            revealAnswer();
            // at last we are setting the user selected answer so we can check which one is correct and which one is incorrect
            questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });
        quizBinding.option3.setOnClickListener(v ->{
            // here we will check if the selected option is 0 then run the code and if not then do not run this code
            if (selectedOption == 0) {
                selectedOption = 1 ;
            // here if user click this button and we get the value 0 then we set the selected option string by getting the option string name
                selectedOptionByUser = quizBinding.option3.getText().toString();
            //setting this function if the answer is wrong
                quizBinding.option3.setTextColor(Color.WHITE);
                quizBinding.option3.setBackgroundResource(R.drawable.background_option_red_color);
            // calling the function to check which question is right
                revealAnswer();
            // at last we are setting the user selected answer so we can check which one is correct and which one is incorrect
            questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });
        quizBinding.option4.setOnClickListener(v ->{
            // here we will check if the selected option is 0 then run the code and if not then do not run this code
            if (selectedOption == 0){
                selectedOption = 1 ;
            // here if user click this button and we get the value 0 then we set the selected option string by getting the option string name
            selectedOptionByUser = quizBinding.option4.getText().toString() ;
            //setting this function if the answer is wrong
            quizBinding.option4.setTextColor(Color.WHITE);
            quizBinding.option4.setBackgroundResource(R.drawable.background_option_red_color);
            // calling the function to check which question is right
            revealAnswer();
            // at last we are setting the user selected answer so we can check which one is correct and which one is incorrect
            questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });
        // if a user selected the next btn then perform some function
        quizBinding.nextBtn.setOnClickListener(v ->{
        // if selected option by user is empty means no option is selected by the user
                if(selectedOptionByUser.isEmpty()){
                    // if the selected option is empty then we show the snackbar to show the message to user for select the option
                    Snackbar sb = Snackbar.make(findViewById(android.R.id.content),"Please Select A Option First",Snackbar.LENGTH_SHORT);
                    View view = sb.getView() ;
                    view.setBackgroundColor(Color.RED);
                    sb.show();
                }else{
                    // if the first statement is false then this code will run
                    changeNextQuestion();
                }
        });
    }
    private void changeNextQuestion(){
        // firstly we are increasing the current question position = 1
        currentQuestionPosition++;
        // next we are checking if current question and question list size are same then change the text of next button to submt button
        if((currentQuestionPosition+1) == questionLists.size()){
            quizBinding.nextBtn.setText(R.string.submit_quiz);
        }
        // next here we are checking if the current question is less the questionlist size then run the code
        if(currentQuestionPosition < questionLists.size()){
            // we set the selected option by the user is blank so that again if a user select a question it will store that option text
            selectedOptionByUser = "" ;
            // setting select option is 0 so that the option button will be triggered again
            selectedOption = 0 ;
            // we are setting the all option in the background round white and text also white
            quizBinding.option1.setBackgroundResource(R.drawable.round_back);
            quizBinding.option1.setTextColor(Color.parseColor("#1F6BB8"));
            quizBinding.option2.setBackgroundResource(R.drawable.round_back);
            quizBinding.option2.setTextColor(Color.parseColor("#1F6BB8"));
            quizBinding.option3.setBackgroundResource(R.drawable.round_back);
            quizBinding.option3.setTextColor(Color.parseColor("#1F6BB8"));
            quizBinding.option4.setBackgroundResource(R.drawable.round_back);
            quizBinding.option4.setTextColor(Color.parseColor("#1F6BB8"));
            // here we are setting the text of all the bind views like question and options by using current question position
            quizBinding.questionsCounter.setText(MessageFormat.format("{0}/{1}", currentQuestionPosition + 1, questionLists.size()));
            quizBinding.questions.setText(questionLists.get(currentQuestionPosition).getQuestion());
            quizBinding.option1.setText(questionLists.get(currentQuestionPosition).getOption1());
            quizBinding.option2.setText(questionLists.get(currentQuestionPosition).getOption2());
            quizBinding.option3.setText(questionLists.get(currentQuestionPosition).getOption3());
            quizBinding.option4.setText(questionLists.get(currentQuestionPosition).getOption4());
        }else{
            // when the if part is wrong so else part will trigger and a intent will be called on submit button and open the main activity class
            Intent intent = new Intent(QuizActivity.this,QuizResult.class);
            // putting the correct and incorrect answer inside intent so that we can show it to the users further and pass it to some other activity
            intent.putExtra("correct",getCorrectAnswer());
            intent.putExtra("incorrect",getIncorrectAnswer());
            startActivity(intent);
            finish();
        }
    }

    private int getCorrectAnswer(){
        // here we are starting a loop and then put the correct ans and incorrect ans to check whether it is correct or not
        // if it is correct so it will store the value inside correct Answers and return the correct answer total
        int correctAnswers = 0 ;
        for(int i = 0 ; i < questionLists.size() ; i++){
            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();
            if(getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers ;
    }
    private int getIncorrectAnswer(){
        // here we are starting a loop and then put the correct ans and incorrect ans to check whether it is correct or not
        // if it is incorrect so it will store the value inside incorrect Answers and return the incorrect answer total
        int inCorrectAnswers = 0 ;
        for(int i = 0 ; i < questionLists.size() ; i++){
            final String getUserSelectedAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();
            if(!getUserSelectedAnswer.equals(getAnswer)) {
                // when a user get the wrong answer then we will vibrate the phone
                Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                inCorrectAnswers++;
            }
        }
        return inCorrectAnswers ;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // here when a user press the back button it will finish the activity
        finish();
    }
    private void revealAnswer(){
        // here first we are getting the answer from the question list get answer function and setting it into get answer
        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        // checking if any option have the matching text so it will start that particular condition and leave everything else
        if(quizBinding.option1.getText().toString().equals(getAnswer)){
            quizBinding.option1.setTextColor(Color.WHITE);
            quizBinding.option1.setBackgroundResource(R.drawable.background_option_color);
        }else if (quizBinding.option2.getText().toString().equals(getAnswer)){
            quizBinding.option2.setTextColor(Color.WHITE);
            quizBinding.option2.setBackgroundResource(R.drawable.background_option_color);
        }else if (quizBinding.option3.getText().toString().equals(getAnswer)){
            quizBinding.option3.setTextColor(Color.WHITE);
            quizBinding.option3.setBackgroundResource(R.drawable.background_option_color);
        }else if(quizBinding.option4.getText().toString().equals(getAnswer)){
            quizBinding.option4.setTextColor(Color.WHITE);
            quizBinding.option4.setBackgroundResource(R.drawable.background_option_color);
        }
    }
}