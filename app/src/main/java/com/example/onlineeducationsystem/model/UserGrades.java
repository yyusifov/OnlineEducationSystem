package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = UserInformation.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Quiz.class,
                parentColumns = "quiz_id",
                childColumns = "quiz_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Courses.class,
                parentColumns = "id",
                childColumns = "course_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class UserGrades {
    @PrimaryKey(autoGenerate = true)
    private int grade_id;

    private int user_id;

    private int quiz_id;

    private float grade;

    private int course_id;

    public UserGrades() {
    }

    public UserGrades(int user_id, int quiz_id, int course_id, float grade) {
        this.user_id = user_id;
        this.quiz_id = quiz_id;
        this.grade = grade;
        this.course_id = course_id;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
