package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.Lectures;
import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.ViewHolder> {
    private List<CourseTopics> lectures;

    private Lectures lectures_class;

    public LecturesAdapter(List<CourseTopics> lectures, Lectures lectures_class){
        this.lectures = lectures;

        this.lectures_class = lectures_class;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lecture_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.lecture_name.setText(lectures.get(i).getTopic_name());

        viewHolder.lecture_number.setText("Lecture " + lectures.get(i).getTopic_number());

        viewHolder.lecture_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lectures_class.moveToSubtopicSection(lectures.get(i).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lectures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lecture_name, lecture_number;

        private MaterialCardView lecture_object;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lecture_name = itemView.findViewById(R.id.lecture_name);

            lecture_number = itemView.findViewById(R.id.subtopic_number);

            lecture_object = itemView.findViewById(R.id.lecture_object);
        }
    }
}
