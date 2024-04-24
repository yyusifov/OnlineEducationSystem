package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserGender {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String gender_text;

    public UserGender() {
    }

    public UserGender(String gender_text) {
        this.gender_text = gender_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender_text() {
        return gender_text;
    }

    public void setGender_text(String gender_text) {
        this.gender_text = gender_text;
    }
}
