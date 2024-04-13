package com.example.onlineeducationsystem;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.util.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeTest extends AppCompatActivity {

    private TextView questionText;
    private Button variantA, variantB, variantC, variantD, previousButton, finishButton, nextButton;

    private int counter = -1;

    private ArrayList<Integer> isAnswerCorrect;

    private TextView questionNumber;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_test);

        questionNumber = findViewById(R.id.question_number_id);

        isAnswerCorrect = new ArrayList<>();

        questionText = findViewById(R.id.questionText);
        variantA = findViewById(R.id.A_button);
        variantB = findViewById(R.id.B_button);
        variantC = findViewById(R.id.C_button);
        variantD = findViewById(R.id.D_button);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        finishButton = findViewById(R.id.finishButton);


        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(PracticeTest.this.getApplication()).create(UserViewModel.class);

        updateQuestion(true);

        Snackbar.make(questionText, "Course id: " + getIntent().getIntExtra("course_id", -1) + " - quiz_id: " + getIntent().getIntExtra("quiz_id",-5), Snackbar.LENGTH_LONG).show();
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(counter > 0){
                    --counter;

                    boolean next_or_previous = false;
                    updateQuestion(next_or_previous);

                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantA.setTextColor((Color.rgb(246,246,246)));

                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantB.setTextColor((Color.rgb(246,246,246)));

                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantC.setTextColor((Color.rgb(246,246,246)));

                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantD.setTextColor((Color.rgb(246,246,246)));

                    questionNumber.setText("Question " + (counter + 1));

                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    boolean next_or_previous = true;

                    updateQuestion(next_or_previous);

                }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticeTest.this, QuizResult.class);
                intent.putIntegerArrayListExtra("wrong_answers", isAnswerCorrect);
                intent.putExtra("quiz_id", getIntent().getIntExtra("quiz_id", -5));
                intent.putExtra("user_id", getIntent().getIntExtra("user_id", -5));
                intent.putExtra("course_id", getIntent().getIntExtra("course_id", -5));
                startActivity(intent);

            }
        });

        variantA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkAnswer(variantA.getText().toString().trim().toLowerCase());


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

                checkAnswer(variantB.getText().toString().trim().toLowerCase());


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

                checkAnswer(variantC.getText().toString().trim().toLowerCase());


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

                checkAnswer(variantD.getText().toString().trim().toLowerCase());

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

    public void checkAnswer(String user_answer){
        userViewModel.getAllQuestions().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                List<Question> questions1 = questions.stream().filter(question -> question.getQuiz_id() == getIntent().getIntExtra("quiz_id", -1)).collect(Collectors.toList());
                Log.d("user_answer", user_answer);
                Log.d("user_answer2", questions1.get(counter).getCorrectAnswer().trim().toLowerCase());

                isAnswerCorrect = isAnswerCorrect.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

                Snackbar.make(variantA, String.valueOf(isAnswerCorrect), Snackbar.LENGTH_LONG).show();

                if(!(user_answer.equals(questions1.get(counter).getCorrectAnswer().trim().toLowerCase()))) {
                    isAnswerCorrect.add(counter);
                    Log.d("fasg", "Wssup");
                }
            }
        });
    }

    public void updateQuestion(boolean next_or_previous){
        userViewModel.getAllQuestions().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                Snackbar.make(variantA, String.valueOf(questions.size()), Snackbar.LENGTH_LONG).show();
                List<Question> questions1 = questions.stream().filter(question -> question.getQuiz_id() == getIntent().getIntExtra("quiz_id", -1)).collect(Collectors.toList());
                if(counter > 0 || counter < (questions1.size() - 1)) {

                    if(next_or_previous){
                        counter++;
                    }

                    questionText.setText(questions1.get(counter).getQuestion_text());

                    variantA.setText(questions1.get(counter).getAnswerA());
                    variantB.setText(questions1.get(counter).getAnswerB());
                    variantC.setText(questions1.get(counter).getAnswerC());
                    variantD.setText(questions1.get(counter).getAnswerD());

                    variantA.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantA.setTextColor((Color.rgb(246,246,246)));

                    variantB.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantB.setTextColor((Color.rgb(246,246,246)));

                    variantC.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantC.setTextColor((Color.rgb(246,246,246)));

                    variantD.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.CYAN, Color.rgb(92,36,130)}));
                    variantD.setTextColor((Color.rgb(246,246,246)));

                    questionNumber.setText("Question " + (counter + 1));

                }

            }
        });
    }
}