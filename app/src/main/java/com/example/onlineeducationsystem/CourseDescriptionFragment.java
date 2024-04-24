package com.example.onlineeducationsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.CourseDescription;
import com.example.onlineeducationsystem.util.UserViewModel;

public class CourseDescriptionFragment extends Fragment {

    private TextView description_text;

    private Button link_button;

    public CourseDescriptionFragment() {
        // Required empty public constructor
    }
    public static CourseDescriptionFragment newInstance() {
        CourseDescriptionFragment fragment = new CourseDescriptionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_description, container, false);

        description_text = view.findViewById(R.id.course_description_txt);

        link_button = view.findViewById(R.id.syllabus_link);

        UserViewModel userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(UserViewModel.class);

        userViewModel.getCourseDescription(getArguments().getInt("description_id")).observe(requireActivity(), new Observer<CourseDescription>() {
            @Override
            public void onChanged(CourseDescription courseDescription) {
                description_text.setText(courseDescription.getDescription());
            }
        });

        link_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.getCourseDescription(getArguments().getInt("description_id")).observe(requireActivity(), new Observer<CourseDescription>() {
                    @Override
                    public void onChanged(CourseDescription courseDescription) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);

                        intent.setData(Uri.parse(courseDescription.getSyllabusLink()));

                        startActivity(intent);
                    }
                });
            }
        });


        return view;
    }
}