package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.Courses;

import java.util.List;

@Dao
public interface CoursesDAO {
    //Implementation of courses
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourse(Courses course);

    @Delete
    void deleteCourse(Courses course);

    @Query("Select * from Courses where Courses.id == :course_id")
    LiveData<Courses> getCourse(int course_id);

    @Query("Select * from Courses Order by Courses.id")
    LiveData<List<Courses>> getAllCourses();

    @Update
    void updateCourse(Courses course);

    @Query("Delete from Courses")
    void deleteAllCourses();
}
