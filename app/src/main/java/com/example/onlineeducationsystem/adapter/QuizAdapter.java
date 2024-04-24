package com.example.onlineeducationsystem.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.TestSection;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserGrades;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    private List<Quiz> getAllQuiz;

    private TestSection testSection;

    private List<UserGrades> userGradesList;

    public QuizAdapter(List<Quiz> getAllQuiz, TestSection testSection, List<UserGrades> userGradesList){
        this.getAllQuiz = getAllQuiz;
        this.testSection = testSection;
        this.userGradesList = userGradesList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quiz_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.quiz_name.setText(getAllQuiz.get(viewHolder.getAdapterPosition()).getQuiz_name());

        viewHolder.start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userGradesList.isEmpty()) {
                    for (int j = 0; j < userGradesList.size(); j++) {
                        Log.d("sssiiizzze", String.valueOf(userGradesList.get(j).getQuiz_id()));
                        if (getAllQuiz.get(viewHolder.getAdapterPosition()).getQuiz_id() != userGradesList.get(j).getQuiz_id()) {
                            testSection.moveToPracticeTest(getAllQuiz.get(viewHolder.getAdapterPosition()).getQuiz_id());
                        } else {
                            Snackbar.make(viewHolder.start_button, "This quiz has already been taken", Snackbar.LENGTH_LONG).show();
                        }
                    }
                }
                else{
                    testSection.moveToPracticeTest(getAllQuiz.get(viewHolder.getAdapterPosition()).getQuiz_id());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return getAllQuiz.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button start_button;
        private TextView quiz_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            start_button = itemView.findViewById(R.id.start_button);

            quiz_name = itemView.findViewById(R.id.quiz_name);
        }
    }
}
