package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Courses {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int course_code;

    private String course_name;

    private String course_instructor;

    private int description_id;

    public Courses() {
    }

    public Courses(int course_code, String course_name, String course_instructor, int description_id) {
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_instructor = course_instructor;
        this.description_id = description_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_code() {
        return course_code;
    }

    public void setCourse_code(int course_code) {
        this.course_code = course_code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_instructor() {
        return course_instructor;
    }

    public void setCourse_instructor(String course_instructor) {
        this.course_instructor = course_instructor;
    }

    public int getDescription_id() {
        return description_id;
    }

    public void setDescription_id(int description_id) {
        this.description_id = description_id;
    }
}
