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
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;

public class GeneralPage extends Fragment {
    private RecyclerView recyclerView;

    private UserViewModel userViewModel;

    private HomePage homePage;

    public GeneralPage() {
        // Required empty public constructor
    }

    public static GeneralPage newInstance(HomePage homePage) {
        GeneralPage fragment = new GeneralPage();
        fragment.setHomePage(homePage);
        return fragment;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(UserViewModel.class);


        userViewModel.getAllCourses().observe(this, new Observer<List<Courses>>() {
            @Override
            public void onChanged(List<Courses> courses) {

                userViewModel.getAllCourseTopics().observe(requireActivity(), new Observer<List<CourseTopics>>() {
                    @Override
                    public void onChanged(List<CourseTopics> courseTopics) {
                        Log.d("num: ", String.valueOf(courseTopics.size()));
                        CourseAdapter courseAdapter = new CourseAdapter(courses, courseTopics, homePage);
                        recyclerView.setAdapter(courseAdapter);
                    }
                });
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_general_page, container, false);

        recyclerView = view.findViewById(R.id.allCourses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
}