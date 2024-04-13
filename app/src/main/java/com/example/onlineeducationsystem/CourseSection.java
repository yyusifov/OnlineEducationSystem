package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class CourseSection extends Fragment {
    private Button lectures, practice, grades;

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

        grades = view.findViewById(R.id.grades_U);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), TestSection.class);
                if(null == getArguments()){
                    Log.d("courseidmessage", "bundle is null");
                }
                else {
                    Log.d("courseidmessage", "course id: " + getArguments().getInt("course_id", -1));
                    intent.putExtra("course_id", getArguments().getInt("course_id", -1));
                    intent.putExtra("user_id", getArguments().getInt("user_id", -1));
                }
                startActivity(intent);
            }
        });

        lectures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), Lectures.class);
                if(null == getArguments()){
                    Log.d("courseidmessage", "bundle is null");
                }
                else {
                    Log.d("courseidmessage", "course id: " + getArguments().getInt("course_id", -1));
                    intent.putExtra("course_id", getArguments().getInt("course_id", -1));
                }
                startActivity(intent);
            }
        });

        grades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), GradeSection.class);
                if(null == getArguments()){
                    Log.d("courseidmessage", "bundle is null");
                }
                else {
                    Log.d("courseidmessage", "course id: " + getArguments().getInt("course_id", -1));
                    intent.putExtra("course_id", getArguments().getInt("course_id", -1));
                    intent.putExtra("user_id", getArguments().getInt("user_id", -1));
                }
                startActivity(intent);
            }
        });

        return view;
    }
}