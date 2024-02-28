package com.example.onlineeducationsystem;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineeducationsystem.QuizSetUp.Quiz;

public class PractiseTest extends AppCompatActivity {

    private TextView questionText;
    private Button variantA, variantB, variantC, variantD, previousButton, finishButton, nextButton;

    private Quiz[] questionSet;

    private int counter = 0;

    private boolean[] isAnswerCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_test);

        questionSet = new Quiz[]{new Quiz(1, "What field was Albert Einstein known for?", "Chemistry", "Biology", "Psychology", "Physics", "Physics"),
                new Quiz(2, "Where was Albert Einstein born?", "Berlin", "Munich", "Ulm", "Vienna", "Ulm"),
                new Quiz(3, "Which theory did Albert Einstein develop?", "Theory of Evolution", "Theory of Relativity", "Quantum Theory", "Big Bang Theory", "Theory of Relativity"),
                new Quiz(4, "In which year was Albert Einstein born?", "1850", "1890", "1879", "1905", "1879"),
                new Quiz(5, "What empire was Ulm part of when Albert Einstein was born?", "German Empire", "Ottoman Empire", "Roman Empire", "British Empire", "German Empire")};

        isAnswerCorrect = new boolean[questionSet.length];

        questionText = findViewById(R.id.questionText);
        variantA = findViewById(R.id.A_button);
        variantB = findViewById(R.id.B_button);
        variantC = findViewById(R.id.C_button);
        variantD = findViewById(R.id.D_button);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        finishButton = findViewById(R.id.finishButton);


        questionText.setText(questionSet[0].getQuestionNumber() + " " + questionSet[0].getQuestion());

        variantA.setText(questionSet[0].getAnswerA());
        variantB.setText(questionSet[0].getAnswerB());
        variantC.setText(questionSet[0].getAnswerC());
        variantD.setText(questionSet[0].getAnswerD());

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counter > 0){

                    questionText.setText(questionSet[--counter].getQuestionNumber() + " " + questionSet[counter].getQuestion());

                    variantA.setText(questionSet[counter].getAnswerA());
                    variantB.setText(questionSet[counter].getAnswerB());
                    variantC.setText(questionSet[counter].getAnswerC());
                    variantD.setText(questionSet[counter].getAnswerD());

                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantA.setTextColor((Color.rgb(246,246,246)));

                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantB.setTextColor((Color.rgb(246,246,246)));

                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantC.setTextColor((Color.rgb(246,246,246)));

                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantD.setTextColor((Color.rgb(246,246,246)));
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(counter < (questionSet.length - 1)){
                    questionText.setText(questionSet[++counter].getQuestionNumber() + " " + questionSet[counter].getQuestion());

                    variantA.setText(questionSet[counter].getAnswerA());
                    variantB.setText(questionSet[counter].getAnswerB());
                    variantC.setText(questionSet[counter].getAnswerC());
                    variantD.setText(questionSet[counter].getAnswerD());


                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantA.setTextColor((Color.rgb(246,246,246)));

                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantB.setTextColor((Color.rgb(246,246,246)));

                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantC.setTextColor((Color.rgb(246,246,246)));

                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantD.setTextColor((Color.rgb(246,246,246)));
                }
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PractiseTest.this, QuizResult.class);
                intent.putExtra("StudentAnswers", isAnswerCorrect);
                intent.putExtra("Question_Set", questionSet);
                startActivity(intent);

            }
        });

        variantA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variantA.getText().toString().trim().toLowerCase().equals(questionSet[counter].getCorrectAnswer().trim().toLowerCase())){
                    isAnswerCorrect[counter] = true;
                }
                else{
                    isAnswerCorrect[counter] = false;
                }


                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(246,246,246)}));
                variantA.setTextColor((Color.rgb(92,36,130)));

                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantB.setTextColor((Color.rgb(246,246,246)));

                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantC.setTextColor((Color.rgb(246,246,246)));

                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantD.setTextColor((Color.rgb(246,246,246)));
            }
        });

        variantB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variantB.getText().toString().trim().toLowerCase().equals(questionSet[counter].getCorrectAnswer().trim().toLowerCase())){
                    isAnswerCorrect[counter] = true;
                }
                else{
                    isAnswerCorrect[counter] = false;
                }

                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(246,246,246)}));
                variantB.setTextColor((Color.rgb(92,36,130)));

                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantA.setTextColor((Color.rgb(246,246,246)));

                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantC.setTextColor((Color.rgb(246,246,246)));

                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantD.setTextColor((Color.rgb(246,246,246)));
            }
        });

        variantC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variantC.getText().toString().trim().toLowerCase().equals(questionSet[counter].getCorrectAnswer().trim().toLowerCase())){
                    isAnswerCorrect[counter] = true;
                }
                else{
                    isAnswerCorrect[counter] = false;
                }


                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(246,246,246)}));
                variantC.setTextColor((Color.rgb(92,36,130)));

                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantB.setTextColor((Color.rgb(246,246,246)));

                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantA.setTextColor((Color.rgb(246,246,246)));

                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantD.setTextColor((Color.rgb(246,246,246)));
            }
        });

        variantD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(variantD.getText().toString().trim().toLowerCase().equals(questionSet[counter].getCorrectAnswer().trim().toLowerCase())){
                    isAnswerCorrect[counter] = true;
                }
                else{
                    isAnswerCorrect[counter] = false;
                }

                variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(246,246,246)}));
                variantD.setTextColor((Color.rgb(92,36,130)));

                variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantB.setTextColor((Color.rgb(246,246,246)));

                variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantC.setTextColor((Color.rgb(246,246,246)));

                variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                variantA.setTextColor((Color.rgb(246,246,246)));
            }
        });
    }
}