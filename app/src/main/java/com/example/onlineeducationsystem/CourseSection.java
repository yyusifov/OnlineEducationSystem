package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class CourseSection extends Fragment {
    private Button lectures, practice, graded_test;

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

        lectures = view.findViewById(R.id.lectures_id);

        practice = view.findViewById(R.id.self_check_quiz);

        graded_test = view.findViewById(R.id.graded_assignment);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), PractiseTest.class);

                startActivity(intent);
            }
        });
        return view;
    }
}