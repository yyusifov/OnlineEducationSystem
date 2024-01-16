package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.CourseDescription;

import java.util.List;

@Dao
public interface CourseDescriptionDAO {
    //Implementation of CourseDescription
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCourseDescription(CourseDescription courseDescription);

    @Delete
    void deleteCourseDescription(CourseDescription courseDescription);

    @Query("Select * from CourseDescription where CourseDescription.id == :courseDescription_id")
    LiveData<CourseDescription> getCourseDescription(int courseDescription_id);

    @Query("Select * from CourseDescription Order by CourseDescription.id")
    LiveData<List<CourseDescription>> getAllCourseDescriptions();

    @Update
    void updateCourseDescription(CourseDescription courseDescription);

    @Query("Delete from CourseDescription")
    void deleteAllCourseDescriptions();
}
