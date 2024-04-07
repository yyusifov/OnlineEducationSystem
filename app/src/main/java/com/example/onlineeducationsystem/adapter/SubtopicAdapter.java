package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.SubtopicSection;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class SubtopicAdapter extends RecyclerView.Adapter<SubtopicAdapter.ViewHolder> {
    private List<CourseSubtopics> courseSubtopicsList;

    private SubtopicSection subtopicSection;
    public SubtopicAdapter(List<CourseSubtopics> courseSubtopicsList, SubtopicSection subtopicSection){
        this.courseSubtopicsList = courseSubtopicsList;

        this.subtopicSection = subtopicSection;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subtopic_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int main_n = this.courseSubtopicsList.get(viewHolder.getAdapterPosition()).getSubtopic_number() / 10;

        int secondary_n = this.courseSubtopicsList.get(viewHolder.getAdapterPosition()).getSubtopic_number() % 10;

        viewHolder.subtopic_name.setText(this.courseSubtopicsList.get(viewHolder.getAdapterPosition()).getSubtopic_name());

        viewHolder.subtopic_number.setText("Subtopic " + main_n + "." + secondary_n);

        viewHolder.subtopic_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtopicSection.openWebPage(courseSubtopicsList.get(viewHolder.getAdapterPosition()).getSubtopic_file());
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.courseSubtopicsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subtopic_name, subtopic_number;

        private MaterialCardView subtopic_object;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subtopic_name = itemView.findViewById(R.id.subtopic_name);

            subtopic_number = itemView.findViewById(R.id.subtopic_number);

            subtopic_object = itemView.findViewById(R.id.subtopic_object);
        }
    }
}
