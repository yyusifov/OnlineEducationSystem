package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserGrades;

import java.util.List;

@Dao
public interface UserGradesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserGrades(UserGrades userGrades);

    @Delete
    void deleteUserGrades(UserGrades userGrades);

    @Query("Select * from UserGrades where UserGrades.grade_id == :grade_id")
    LiveData<UserGrades> getUserGrades(int grade_id);

    @Query("Select * from UserGrades Order by UserGrades.grade_id")
    LiveData<List<UserGrades>> getAllUserGrades();

    @Update
    void updateUserGrade(UserGrades userGrades);

    @Query("Delete from UserGrades")
    void deleteAllUserGrades();
}
