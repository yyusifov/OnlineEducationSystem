package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.model.UserAnswer;

import java.util.ArrayList;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {

    private ArrayList<UserAnswer> userAnswer;
    public FeedbackAdapter(ArrayList<UserAnswer> userAnswer){
        this.userAnswer = userAnswer;
    }

    @NonNull
    @Override
    public FeedbackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feedback_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackAdapter.ViewHolder viewHolder, int i) {
        viewHolder.question_number.setText("Question " + viewHolder.getAdapterPosition() + ": ");

        viewHolder.question_answer.setText(String.valueOf(userAnswer.get(viewHolder.getAdapterPosition()).getFeedback()));
    }

    @Override
    public int getItemCount() {
        return userAnswer.size();
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
