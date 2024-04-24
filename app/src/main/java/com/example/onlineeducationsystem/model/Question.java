package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Quiz.class, parentColumns = "quiz_id", childColumns = "quiz_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = CourseSubtopics.class, parentColumns = "id", childColumns = "subtopic_id", onDelete = ForeignKey.CASCADE)})
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int question_id;

    private int quiz_id;
    private String question_text, answerA, answerB, answerC, answerD, correctAnswer;

    private int subtopic_id;

    public Question() {
    }

    public Question(int quiz_id, String question_text, String answerA, String answerB, String answerC, String answerD, String correctAnswer, int subtopic_id) {
        this.quiz_id = quiz_id;
        this.question_text = question_text;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.subtopic_id = subtopic_id;
    }

    public int getSubtopic_id() {
        return subtopic_id;
    }

    public void setSubtopic_id(int subtopic_id) {
        this.subtopic_id = subtopic_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
