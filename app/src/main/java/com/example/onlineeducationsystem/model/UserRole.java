package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserRole {
    @PrimaryKey
    private int id;

    private String role_name;

    public UserRole() {
    }

    public UserRole(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
