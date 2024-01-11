package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseSubtopics {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int topic_id;

    private int subtopic_number;

    private String subtopic_name;

    private String subtopic_file;
}
