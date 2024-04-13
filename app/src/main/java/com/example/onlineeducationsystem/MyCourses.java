package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.adapter.CourseAdapter;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;
import com.example.onlineeducationsystem.model.UserCourse;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyCourses extends Fragment {

    private RecyclerView recyclerView;

    private HomePage homePage;

    public MyCourses() {
    }

    public static MyCourses newInstance(HomePage homePage) {
        MyCourses fragment = new MyCourses();
        fragment.setHomePage(homePage);
        return fragment;
    }

    private void setHomePage(HomePage homePage){
        this.homePage = homePage;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int user_id = this.getArguments().getInt("Id_of_entered_user", 15);

        Log.d("User_id", String.valueOf(user_id));

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(UserViewModel.class);

        userViewModel.getAllUserCourses().observe(requireActivity(), new Observer<List<UserCourse>>() {
            @Override
            public void onChanged(List<UserCourse> userCourses) {
                List<Integer> user_courses_id = new ArrayList<>();
                for(int i = 0; i < userCourses.size(); i++){
                    if(userCourses.get(i).getUser_id() == user_id){
                        user_courses_id.add(userCourses.get(i).getCourse_id());
                        Log.d("Courses_taken_with_id", String.valueOf(userCourses.get(i).getCourse_id()));
                    }
                }

                List<Courses> user_courses = new ArrayList<>();

                List<CourseTopics> course_topics = new ArrayList<>();
                userViewModel.getAllCourses().observe(requireActivity(), new Observer<List<Courses>>() {
                    @Override
                    public void onChanged(List<Courses> courses) {
                        for (int i = 0; i < courses.size(); i++) {
                            if(user_courses_id.contains(courses.get(i).getId())){
                                user_courses.add(courses.get(i));
                                Log.d("Courses_taken", String.valueOf(courses.get(i).getCourse_name()));
                            }
                        }

                        userViewModel.getAllCourseTopics().observe(requireActivity(), new Observer<List<CourseTopics>>() {
                            @Override
                            public void onChanged(List<CourseTopics> courseTopics) {
                                for (int j = 0; j < course_topics.size(); j++) {
                                    if(user_courses_id.contains(course_topics.get(j).getCourse_id())){
                                        course_topics.add(course_topics.get(j));
                                        Log.d("Courses_topics", String.valueOf(course_topics.get(j).getTopic_name()));
                                    }
                                }

                                CourseAdapter courseAdapter = new CourseAdapter(user_courses, courseTopics, homePage, 0);
                                recyclerView.setAdapter(courseAdapter);

                            }
                        });

                    }
                });
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);

        recyclerView = view.findViewById(R.id.myCourses);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));


        return view;
    }
}