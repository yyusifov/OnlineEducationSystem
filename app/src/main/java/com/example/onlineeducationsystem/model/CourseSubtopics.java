package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = CourseTopics.class, parentColumns = "id", childColumns = "topic_id", onDelete = ForeignKey.CASCADE))
public class CourseSubtopics {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int topic_id;

    private double subtopic_number;

    private String subtopic_name;

    private String subtopic_file;

    public CourseSubtopics() {
    }

    public CourseSubtopics(int topic_id, float subtopic_number, String subtopic_name, String subtopic_file) {
        this.topic_id = topic_id;
        this.subtopic_number = subtopic_number;
        this.subtopic_name = subtopic_name;
        this.subtopic_file = subtopic_file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSubtopic_number() {
        return subtopic_number;
    }

    public void setSubtopic_number(double subtopic_number) {
        this.subtopic_number = subtopic_number;
    }

    public String getSubtopic_name() {
        return subtopic_name;
    }

    public void setSubtopic_name(String subtopic_name) {
        this.subtopic_name = subtopic_name;
    }

    public String getSubtopic_file() {
        return subtopic_file;
    }

    public void setSubtopic_file(String subtopic_file) {
        this.subtopic_file = subtopic_file;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
