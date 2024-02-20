package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CourseSection extends Fragment {

    public CourseSection() {
        // Required empty public constructor
    }

    public static CourseSection newInstance() {
        CourseSection fragment = new CourseSection();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_section, container, false);

        return view;
    }
}