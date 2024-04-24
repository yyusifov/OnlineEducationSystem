package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = UserRole.class, parentColumns = "id", childColumns = "role_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = UserGender.class, parentColumns = "id", childColumns = "gender_id", onDelete = ForeignKey.CASCADE)})
public class UserInformation {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String user_name;

    private String user_firstname;

    private String user_surname;

    private String user_email;

    private int role_id;

    private String user_password;

    private Long creation_date;

    private Long update_date;

    private String phone_number;

    private int gender_id;

    private String birth_date;

    public UserInformation() {
    }

    public UserInformation(String user_name, String user_firstname, String user_surname, String user_email, int role_id, String user_password, Long creation_date, Long update_date, String phone_number, int gender_id, String birth_date) {
        this.user_name = user_name;
        this.user_firstname = user_firstname;
        this.user_surname = user_surname;
        this.user_email = user_email;
        this.role_id = role_id;
        this.user_password = user_password;
        this.creation_date = creation_date;
        this.update_date = update_date;
        this.phone_number = phone_number;
        this.gender_id = gender_id;
        this.birth_date = birth_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getGender_id() {
        return gender_id;
    }

    public void setGender_id(int gender_id) {
        this.gender_id = gender_id;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Long creation_date) {
        this.creation_date = creation_date;
    }

    public Long getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Long update_date) {
        this.update_date = update_date;
    }
}
