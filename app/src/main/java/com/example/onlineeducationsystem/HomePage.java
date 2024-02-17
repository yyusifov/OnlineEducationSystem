package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.CourseAdapter;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;
import com.example.onlineeducationsystem.util.UserViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomePage extends AppCompatActivity {

    private RecyclerView recyclerView;

    private UserViewModel userViewModel;

    private BottomNavigationView navigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        navigationBar = findViewById(R.id.navBar);

        recyclerView = findViewById(R.id.allCourses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(HomePage.this.getApplication()).create(UserViewModel.class);

        userViewModel.getAllCourses().observe(this, new Observer<List<Courses>>() {
            @Override
            public void onChanged(List<Courses> courses) {

                userViewModel.getAllCourseTopics().observe(HomePage.this, new Observer<List<CourseTopics>>() {
                    @Override
                    public void onChanged(List<CourseTopics> courseTopics) {
                        Log.d("num: ", String.valueOf(courseTopics.size()));
                        CourseAdapter courseAdapter = new CourseAdapter(courses, courseTopics);
                        recyclerView.setAdapter(courseAdapter);
                    }
                });
            }
        });

        navigationBar.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.home_page){
                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, GeneralPage.newInstance()).commit();
            }
            else if(item.getItemId() == R.id.myCourses){
                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, MyCourses.newInstance()).commit();
            }
            else if(item.getItemId() == R.id.aboutSystem){

            }
            else if(item.getItemId() == R.id.profileSection){

            }


            return true;
        });
    }
}