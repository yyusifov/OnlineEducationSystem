package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.QuizAdapter;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserGrades;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class TestSection extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_section);
        TextView quiz_frame = findViewById(R.id.quiz_frame);
        //Snackbar.make(quiz_frame, String.valueOf(getIntent().getIntExtra("course_id", -1)), Snackbar.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.myRecyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllQuiz().observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(List<Quiz> quizzes) {
                userViewModel.getAllUserGrades().observe(TestSection.this, new Observer<List<UserGrades>>() {
                    @Override
                    public void onChanged(List<UserGrades> userGrades) {
                        Log.d("maymay", String.valueOf(userGrades.size()));
                        List<UserGrades> userGrades1 = userGrades.stream().filter(userGrades2 -> userGrades2.getUser_id() == getIntent().getIntExtra("user_id", -1)).
                                filter(userGrades2 -> userGrades2.getCourse_id() == getIntent().getIntExtra("course_id", -1)).collect(Collectors.toList());
                        QuizAdapter quizAdapter = new QuizAdapter(quizzes.stream().filter(quiz -> quiz.getCourse_id() == getIntent().getIntExtra("course_id", -1)).
                                collect(Collectors.toList()), TestSection.this, userGrades1);
                        recyclerView.setAdapter(quizAdapter);
                    }
                });
            }
        });

    }

    public void moveToPracticeTest(int quiz_id){
        Intent intent = new Intent(TestSection.this,PracticeTest.class);
        intent.putExtra("quiz_id", quiz_id);
        intent.putExtra("course_id", getIntent().getIntExtra("course_id", -1));
        intent.putExtra("user_id", getIntent().getIntExtra("user_id", -1));
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TestSection.this, HomePage.class);

        intent.putExtra("Id_of_entered_user", getIntent().getIntExtra("user_id", -1));

        startActivity(intent);
    }
}