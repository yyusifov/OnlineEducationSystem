package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Quiz.class, parentColumns = "quiz_id", childColumns = "quiz_id", onDelete = ForeignKey.CASCADE))
public class Question {

    @PrimaryKey(autoGenerate = true)
    private int question_id;

    private int subtopic_number;
    private int quiz_id;
    private int questionNumber;
    private String question_text, answerA, answerB, answerC, answerD, correctAnswer;



    public Question(int quiz_id, int questionNumber, String question_text, String answerA, String answerB, String answerC, String answerD, String correctAnswer, int subtopic_number) {
        this.quiz_id = quiz_id;
        this.questionNumber = questionNumber;
        this.question_text = question_text;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.subtopic_number = subtopic_number;
    }

    public int getSubtopic_number() {
        return subtopic_number;
    }

    public void setSubtopic_number(int subtopic_number) {
        this.subtopic_number = subtopic_number;
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
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
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
