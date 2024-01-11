package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class StudentInformation {
    @ForeignKey(
            entity = StudentRole.class,
            parentColumns = "id",
            childColumns = "role_id",
            onDelete = ForeignKey.CASCADE
    )

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String user_name;

    private String student_firstname;

    private String student_surname;

    private String student_email;

    private int role_id;

    private String student_password;

    private Date creation_date;

    private Date update_date;

    public StudentInformation() {
    }

    public StudentInformation(String user_name, String student_firstname, String student_surname, String student_email, int role_id, String student_password, Date creation_date, Date update_date) {
        this.user_name = user_name;
        this.student_firstname = student_firstname;
        this.student_surname = student_surname;
        this.student_email = student_email;
        this.role_id = role_id;
        this.student_password = student_password;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public int getStudent_id() {
        return id;
    }

    public void setStudent_id(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStudent_firstname() {
        return student_firstname;
    }

    public void setStudent_firstname(String student_firstname) {
        this.student_firstname = student_firstname;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
