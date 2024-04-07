package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.LecturesAdapter;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.util.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Lectures extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LecturesAdapter lecturesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lectures);

        recyclerView = findViewById(R.id.subtopicList);

        Snackbar.make(recyclerView, String.valueOf(getIntent().getIntExtra("course_id", 0)), Snackbar.LENGTH_LONG).show();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllCourseTopics().observe(this, new Observer<List<CourseTopics>>() {
            @Override
            public void onChanged(List<CourseTopics> courseTopics) {

                lecturesAdapter = new LecturesAdapter(courseTopics, Lectures.this);

                recyclerView.setAdapter(lecturesAdapter);
            }
        });


    }

    public void moveToSubtopicSection(int topic_id){
        Intent intent = new Intent(Lectures.this, SubtopicSection.class);

        intent.putExtra("topic_id", topic_id);

        startActivity(intent);
    }
}