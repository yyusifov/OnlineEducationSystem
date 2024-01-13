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

    public UserRole(int role_id, String role_name) {
        this.id = role_id;
        this.role_name = role_name;
    }

    public int getRole_id() {
        return id;
    }

    public void setRole_id(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
