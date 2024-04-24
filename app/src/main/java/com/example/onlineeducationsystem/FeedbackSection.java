package com.example.onlineeducationsystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.FeedbackAdapter;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.model.UserAnswer;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeedbackSection extends AppCompatActivity {

    private RecyclerView recyclerView;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_section);

        recyclerView = findViewById(R.id.feedback_list);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllUserAnswers().observe(this, new Observer<List<UserAnswer>>() {
            @Override
            public void onChanged(List<UserAnswer> userAnswers) {
                userViewModel.getAllQuestions().observe(FeedbackSection.this, new Observer<List<Question>>() {
                    @Override
                    public void onChanged(List<Question> questions) {
                        userViewModel.getAllCourseSubtopics().observe(FeedbackSection.this, new Observer<List<CourseSubtopics>>() {
                            @Override
                            public void onChanged(List<CourseSubtopics> courseSubtopics) {
                                FeedbackAdapter feedbackAdapter = new FeedbackAdapter((ArrayList<UserAnswer>) userAnswers.stream().filter(userAnswer ->
                                                userAnswer.getUser_id() == getIntent().getIntExtra("user_id",-5))
                                        .filter(userAnswer -> userAnswer.getQuiz_id() == getIntent().getIntExtra("quiz_id", -5))
                                        .filter(userAnswer -> userAnswer.getCourse_id() == getIntent().getIntExtra("course_id", -5))
                                        .filter(userAnswer -> userAnswer.getGrade_id() == getIntent().getIntExtra("grade_id", -5))
                                        .collect(Collectors.toList()), questions.stream().filter(question -> question.getQuiz_id() == getIntent().getIntExtra("quiz_id", -5)).collect(Collectors.toList()), courseSubtopics);

                                recyclerView.setAdapter(feedbackAdapter);
                            }
                        });
                    }
                });
            }
        });

    }
}