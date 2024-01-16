package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CourseDescription {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String description;

    private String syllabusLink;

    private double passingScore;

    public CourseDescription() {
    }

    public CourseDescription(String description, String syllabusLink, double passingScore) {
        this.description = description;
        this.syllabusLink = syllabusLink;
        this.passingScore = passingScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSyllabusLink() {
        return syllabusLink;
    }

    public void setSyllabusLink(String syllabusLink) {
        this.syllabusLink = syllabusLink;
    }

    public double getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(double passingScore) {
        this.passingScore = passingScore;
    }
}
