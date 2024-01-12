package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class CourseSubtopics {

    @ForeignKey(
            entity = CourseTopics.class,
            parentColumns = "id",
            childColumns = "topic_id",
            onDelete = ForeignKey.CASCADE
    )

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int topic_id;

    private int subtopic_number;

    private String subtopic_name;

    private String subtopic_file;
}
