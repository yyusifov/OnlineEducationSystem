package com.example.onlineeducationsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.SubtopicAdapter;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;
import java.util.stream.Collectors;

public class SubtopicSection extends AppCompatActivity {
    private RecyclerView recyclerView;

    private CardView subtopic_frame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_section);

        recyclerView = findViewById(R.id.subtopicList);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int topicId = getIntent().getIntExtra("topic_id", 0);
        //Snackbar.make(recyclerView, String.valueOf(topicId), Snackbar.LENGTH_LONG).show();

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllCourseSubtopics().observe(this, new Observer<List<CourseSubtopics>>() {
            @Override
            public void onChanged(List<CourseSubtopics> courseSubtopics) {
                List<CourseSubtopics> courseSubtopicsArrayList = courseSubtopics.stream().filter(courseSubtopics1 -> courseSubtopics1.getTopic_id() == topicId).collect(Collectors.toList());

                SubtopicAdapter subtopicAdapter = new SubtopicAdapter(courseSubtopicsArrayList, SubtopicSection.this);

                recyclerView.setAdapter(subtopicAdapter);
            }
        });
    }

    public void openWebPage(String url){

        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

}