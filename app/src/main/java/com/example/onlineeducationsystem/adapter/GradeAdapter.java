package com.example.onlineeducationsystem.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.GradeSection;
import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserGrades;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.ViewHolder> {

    private List<UserGrades> userGradesList;

    private List<Quiz> quizList;

    private GradeSection gradeSection;

    public GradeAdapter(List<Quiz> quizList, List<UserGrades> userGradesList, GradeSection gradeSection){
        this.userGradesList = userGradesList;
        this.quizList = quizList;
        this.gradeSection = gradeSection;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grade_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("quizlist_size", String.valueOf(quizList.size()));
        for (int j = 0; j < quizList.size(); j++) {
            if(quizList.get(j).getQuiz_id() == userGradesList.get(viewHolder.getAdapterPosition()).getQuiz_id()){
                Log.d("quizlist_size", "it works!");
                viewHolder.quiz_name_for_grade.setText(quizList.get(j).getQuiz_name());
            }
        }
        viewHolder.grade.setText(String.valueOf(userGradesList.get(viewHolder.getAdapterPosition()).getGrade()));


        viewHolder.grade_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gradeSection.moveToFeedbackSection(userGradesList.get(viewHolder.getAdapterPosition()).getQuiz_id(), userGradesList.get(viewHolder.getAdapterPosition()).getGrade_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.userGradesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quiz_name_for_grade;

        private TextView grade;

        private MaterialCardView grade_object;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quiz_name_for_grade = itemView.findViewById(R.id.quiz_name_for_grade);
            grade = itemView.findViewById(R.id.grade_id);
            grade_object = itemView.findViewById(R.id.grade_object);
        }
    }
}
