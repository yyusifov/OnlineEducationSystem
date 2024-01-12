package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.StudentInformation;

import java.util.List;

@Dao
public interface StudentDAO {

    //Implementation of student information
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStudentInformation(StudentInformation studentInformation);

    @Delete
    void deleteStudentInformation(StudentInformation studentInformation);

    @Query("Select * from StudentInformation where StudentInformation.id == :student_id")
    LiveData<StudentInformation> getStudentInformation(int student_id);

    @Query("Select * from StudentInformation Order by StudentInformation.id")
    LiveData<List<StudentInformation>> getAllStudentInformation();

    @Update
    void updateStudentInformation(StudentInformation studentInformation);

    @Query("Delete from StudentInformation")
    void deleteAllStudentInformation();

}
