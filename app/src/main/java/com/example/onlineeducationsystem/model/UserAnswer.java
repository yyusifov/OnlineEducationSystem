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
        ),
        @ForeignKey(
                entity = UserGrades.class,
                parentColumns = "grade_id",
                childColumns = "grade_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Question.class,
                parentColumns = "question_id",
                childColumns = "question_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class UserAnswer {
    @PrimaryKey(autoGenerate = true)
    private int user_answer_id;

    private int grade_id;
    private int user_id;

    private int course_id;

    private int quiz_id;

    private int question_id;

    private String question_text;

    private String correct_answer;

    private String feedback;

    public UserAnswer() {
    }

    public UserAnswer(int user_id, int course_id, int quiz_id, int grade_id, int question_id, String question_text, String correct_answer, String feedback) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.quiz_id = quiz_id;
        this.question_id = question_id;
        this.question_text = question_text;
        this.correct_answer = correct_answer;
        this.feedback = feedback;
        this.grade_id = grade_id;
    }

    public int getUser_answer_id() {
        return user_answer_id;
    }

    public void setUser_answer_id(int user_answer_id) {
        this.user_answer_id = user_answer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }
}
