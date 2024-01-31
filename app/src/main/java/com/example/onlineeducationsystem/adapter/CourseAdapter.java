package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;

import java.util.List;
import java.util.stream.Collectors;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<Courses> allCourses;

    private List<CourseTopics> allCourseTopics;

    public CourseAdapter(List<Courses> allCourses, List<CourseTopics> allCourseTopics){
        this.allCourses = allCourses;
        this.allCourseTopics = allCourseTopics;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(allCourses.get(position).getCourse_name().length() > 14){
            holder.courseName.setText(allCourses.get(position).getCourse_name().substring(0,15) + ".");
        }
        else{
            holder.courseName.setText(allCourses.get(position).getCourse_name());
        }

        int lecture_number = allCourseTopics.stream().filter(n -> n.getCourse_id() == allCourses.get(position).getId()).collect(Collectors.toList()).size();

        holder.lectureNumber.setText(String.valueOf(lecture_number));
    }

    @Override
    public int getItemCount() {
        return allCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseName, lectureNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseName);
            lectureNumber = itemView.findViewById(R.id.lectureNumber);
        }
    }
}
