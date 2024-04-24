package com.example.onlineeducationsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineeducationsystem.R;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.model.UserAnswer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {

    private ArrayList<UserAnswer> userAnswer;

    private List<Question> allQuestions;

    private List<CourseSubtopics> courseSubtopicsList;

    public FeedbackAdapter(ArrayList<UserAnswer> userAnswer,List<Question> allQuestions, List<CourseSubtopics> courseSubtopicsList){
        this.userAnswer = userAnswer;

        this.allQuestions = allQuestions;

        this.courseSubtopicsList = courseSubtopicsList;
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

        List<Question> questions = allQuestions.stream().filter(question -> question.getQuestion_id() == userAnswer.get(viewHolder.getAdapterPosition()).getQuestion_id()).collect(Collectors.toList());

        viewHolder.subtopic_number.setText(String.valueOf(courseSubtopicsList.stream().filter(courseSubtopics -> courseSubtopics.getId() == questions.get(0).getSubtopic_id()).collect(Collectors.toList()).get(0).getSubtopic_number()));
    }

    @Override
    public int getItemCount() {
        return userAnswer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView question_number;

        private TextView question_answer;

        private TextView subtopic_number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            question_number = itemView.findViewById(R.id.feedback_number);

            question_answer = itemView.findViewById(R.id.feedback_text);

            subtopic_number = itemView.findViewById(R.id.subtopic_number_id);
        }
    }
}
