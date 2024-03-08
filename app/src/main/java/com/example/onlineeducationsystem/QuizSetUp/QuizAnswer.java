package com.example.onlineeducationsystem.QuizSetUp;

public class QuizAnswer {
    private String question_answer;

    private int question_number;

    public QuizAnswer() {
    }

    public QuizAnswer(String question_answer, int question_number) {
        this.question_answer = question_answer;
        this.question_number = question_number;
    }


    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }
}
