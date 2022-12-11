package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity {
    // in ths class we are using the array list to store the data and further use it to show the user
    private static List<QuestionList> javaQuestions(){
        // here we first initialize the array list with question list class
        final List<QuestionList> questionLists = new ArrayList<>();
        // next we are adding the question list variable which we used to store info we add it inside the array list
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        // returning the list because we already declare that it will return the array of list (question list) type
        return questionLists;
    }
    private static List<QuestionList> phpQuestions(){
        // here we first initialize the array list with question list class
        final List<QuestionList> questionLists = new ArrayList<>();
        // next we are adding the question list variable which we used to store info we add it inside the array list
        questionLists.add(new QuestionList("What does PHP stands for ?","Professional Home Page","Hypertext Preprocessor","Preprocessor Homepage","Pretext Hypertext Processor","Hypertext Preprocessor",""));
        questionLists.add(new QuestionList("From Which Tag Descriptive List Starts ?","<LL>","<DD>","<DL>","<DS>","<DL>",""));
        questionLists.add(new QuestionList("From Which Tag Descriptive List Starts ?","<LL>","<DD>","<DL>","<DS>","<DL>",""));
        questionLists.add(new QuestionList("From Which Tag Descriptive List Starts ?","<LL>","<DD>","<DL>","<DS>","<DL>",""));
        questionLists.add(new QuestionList("From Which Tag Descriptive List Starts ?","<LL>","<DD>","<DL>","<DS>","<DL>",""));
        // returning the list because we already declare that it will return the array of list (questionlist) type
        return questionLists;
    }
    private static List<QuestionList> htmlQuestions(){
        // here we first initialize the array list with question list class
        final List<QuestionList> questionLists = new ArrayList<>();
        // next we are adding the question list variable which we used to store info we add it inside the array list
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is default variable of Boolean Variable ?","true","false","null","not Defined","false",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        // returning the list because we already declare that it will return the array of list (question list) type
        return questionLists;
    }
    private static List<QuestionList> androidQuestions(){
        // here we first initialize the array list with question list class
        final List<QuestionList> questionLists = new ArrayList<>();
        // next we are adding the question list variable which we used to store info we add it inside the array list
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is default variable of Boolean Variable ?","true","false","null","not Defined","false",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        questionLists.add(new QuestionList("What is the Size of int Variable ?","16 bit","8 bit","32 bit","64 bit","32 bit",""));
        // returning the list because we already declare that it will return the array of list (question list) type
        return questionLists;
    }
    // We are making a function here with a return type of list (question list)
    // further we will use it to trigger the function which we make the upper side of this class
    public static List<QuestionList> getQuestions(String selectedTopicName){
        // first we get a string and then we using a switch case so that only that function will trigger which is necessary
        switch(selectedTopicName){
            // if user put string  java
            // so the java function will be triggered
            case "JAVA":
                return javaQuestions();
            // if user put string PHP
            // so the PHP function will be triggered
            case "PHP":
                return phpQuestions();
            // if user put string HTML
            // so the HTML function will be triggered
            case "HTML":
                return htmlQuestions();
            // if user put string Android
            // so the Android function will be triggered
            default:
                return androidQuestions();
        }
    }
}