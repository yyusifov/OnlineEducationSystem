package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseTopics {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int course_id;

    private int topic_number;

    private String topic_name;

    public CourseTopics() {
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTopic_number() {
        return topic_number;
    }

    public void setTopic_number(int topic_number) {
        this.topic_number = topic_number;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }
}
