package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.GradeAdapter;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserGrades;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class GradeSection extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_section);

        recyclerView = findViewById(R.id.grades_list);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllQuiz().observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(List<Quiz> quizList) {
                userViewModel.getAllUserGrades().observe(GradeSection.this, new Observer<List<UserGrades>>() {
                    @Override
                    public void onChanged(List<UserGrades> userGradesList) {
                        List<UserGrades> userGrades1 = userGradesList.stream().filter(userGrades2 -> userGrades2.getUser_id() == getIntent().getIntExtra("user_id", -1)).
                                filter(userGrades2 -> userGrades2.getCourse_id() == getIntent().getIntExtra("course_id", -1)).collect(Collectors.toList());
                        GradeAdapter gradeAdapter = new GradeAdapter(quizList.stream().filter(quiz -> quiz.getCourse_id() == getIntent().getIntExtra("course_id", -1)).
                                collect(Collectors.toList()), userGrades1, GradeSection.this);

                        Log.d("Size1: ", String.valueOf(userGrades1.size()));
                        Log.d("Size2: ", String.valueOf(quizList.stream().filter(quiz -> quiz.getCourse_id() == getIntent().getIntExtra("course_id", -1)).
                                collect(Collectors.toList()).size()));
                        recyclerView.setAdapter(gradeAdapter);
                    }
                });
            }
        });

//Grade adapter bir de grade sectiona bax
    }

    public void moveToFeedbackSection(int quiz_id, int grade_id){

        Intent intent = new Intent(GradeSection.this, FeedbackSection.class);

        intent.putExtra("quiz_id", quiz_id);

        intent.putExtra("grade_id", grade_id);

        intent.putExtra("user_id", getIntent().getIntExtra("user_id", -1));

        intent.putExtra("course_id", getIntent().getIntExtra("course_id", -1));

        startActivity(intent);
    }
}