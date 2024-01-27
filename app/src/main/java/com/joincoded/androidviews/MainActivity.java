package com.joincoded.androidviews;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button trueButton, falseButton, nextButton;
    private TextView wrongTextView, gradeTextView, lastly, questionTextView, correctTextView;
    private int currentIndex = 0;
    int total = 0;
    private ArrayList<String> questions;
    private ArrayList<Boolean> answers;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTextView = findViewById(R.id.questionTextView);
        correctTextView = findViewById(R.id.correctTextView);
        wrongTextView = findViewById(R.id.wrongTextView);
        trueButton = findViewById(R.id.trueanswer);
        falseButton = findViewById(R.id.falseanswer);
        nextButton = findViewById(R.id.nextQuestion);
        gradeTextView = findViewById(R.id.gradeTextView);
        lastly = findViewById(R.id.lastly);


        questions = new ArrayList<>();

        questions.add("Othman is an incredible person");

        questions.add("Coded was founded 1y ago");

        questions.add("Kuwait is an english country");

        questions.add("Windows laptops are better than Macbooks");

        questions.add("Riding dirtbikes is the best hobby");

        questions.add("Kuwait is a middle eastern country");

        questions.add("I don't own a private jet");

        questions.add("Islam is the right religion");

        questions.add("Football is the most the most popular sport");


        answers = new ArrayList<>();

        answers.add(true);

        answers.add(false);

        answers.add(false);

        answers.add(false);

        answers.add(true);

        answers.add(true);

        answers.add(true);

        answers.add(true);

        answers.add(true);


        displayQuestion();

        trueButton.setOnClickListener(view -> checkAnswer(true));

        falseButton.setOnClickListener(view -> checkAnswer(false));

        nextButton.setOnClickListener(view -> nextQuestion());
    }

    private void displayQuestion() {
        questionTextView.setText(questions.get(currentIndex));

        gradeTextView.setText(String.valueOf(total));

        correctTextView.setVisibility(View.INVISIBLE);

        wrongTextView.setVisibility(View.INVISIBLE);

        nextButton.setVisibility(View.INVISIBLE);

        trueButton.setVisibility(View.VISIBLE);

        falseButton.setVisibility(View.VISIBLE);

        lastly.setVisibility(View.INVISIBLE);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers.get(currentIndex);

        if (userAnswer == correctAnswer) {

            correctTextView.setVisibility(View.VISIBLE);

            wrongTextView.setVisibility(View.INVISIBLE);

            trueButton.setVisibility(View.INVISIBLE);

            falseButton.setVisibility(View.INVISIBLE);

            nextButton.setVisibility(View.VISIBLE);

            lastly.setVisibility(View.VISIBLE);

            TotalGrades();
        } else {

            correctTextView.setVisibility(View.INVISIBLE);

            wrongTextView.setVisibility(View.VISIBLE);

            trueButton.setVisibility(View.VISIBLE);

            falseButton.setVisibility(View.VISIBLE);

            nextButton.setVisibility(View.INVISIBLE);

        }
    }

    public void TotalGrades() {
        total++;
        gradeTextView.setText(String.valueOf(total));
    }

    private void hideAnswer(){
        questionTextView.setText(questions.get(currentIndex));

        gradeTextView.setText(String.valueOf(total));

        correctTextView.setVisibility(View.VISIBLE);

        wrongTextView.setVisibility(View.VISIBLE);

        nextButton.setVisibility(View.VISIBLE);

        trueButton.setVisibility(View.INVISIBLE);

        falseButton.setVisibility(View.INVISIBLE);

    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex < questions.size()) {
            displayQuestion();
        }
        else {
            hideAnswer();
        }
    }
}