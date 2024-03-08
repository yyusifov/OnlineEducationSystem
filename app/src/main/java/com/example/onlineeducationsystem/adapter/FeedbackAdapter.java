package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.QuizSetUp.QuizAnswer;
import com.example.onlineeducationsystem.R;

import java.util.ArrayList;
import java.util.Comparator;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {

    private ArrayList<QuizAnswer> quizAnswer;
    public FeedbackAdapter(ArrayList<QuizAnswer> quizAnswer){
        this.quizAnswer = quizAnswer;

        Comparator<QuizAnswer> comparator = new Comparator<QuizAnswer>() {
            @Override
            public int compare(QuizAnswer t1, QuizAnswer t2) {
                return t1.getQuestion_number() - t2.getQuestion_number();
            }
        };

        this.quizAnswer.sort(comparator);
    }

    @NonNull
    @Override
    public FeedbackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackAdapter.ViewHolder viewHolder, int i) {
        viewHolder.question_number.setText("Question " + quizAnswer.get(i).getQuestion_number() + ": ");

        viewHolder.question_answer.setText(quizAnswer.get(i).getQuestion_answer());
    }

    @Override
    public int getItemCount() {
        return quizAnswer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView question_number;

        private TextView question_answer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            question_number = itemView.findViewById(R.id.feedback_number);

            question_answer = itemView.findViewById(R.id.feedback_text);
        }
    }
}
