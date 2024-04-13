package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Courses.class, parentColumns = "id", childColumns = "course_id", onDelete = ForeignKey.CASCADE))
public class Quiz {

    @PrimaryKey(autoGenerate = true)
    private int quiz_id;

    private int course_id;

    private String quiz_name;
    private int total_number_of_questions;

    public Quiz() {
    }

    public Quiz(int course_id, int total_number_of_questions, String quiz_name) {
        this.course_id = course_id;
        this.total_number_of_questions = total_number_of_questions;
        this.quiz_name = quiz_name;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTotal_number_of_questions() {
        return total_number_of_questions;
    }

    public void setTotal_number_of_questions(int total_number_of_questions) {
        this.total_number_of_questions = total_number_of_questions;
    }
}
