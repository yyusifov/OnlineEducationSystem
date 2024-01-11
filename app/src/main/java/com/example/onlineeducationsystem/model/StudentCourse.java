package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentCourse {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int student_id;

    private int course_code;
}
