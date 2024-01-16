package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.CourseSubtopics;

import java.util.List;

@Dao
public interface CourseSubtopicsDAO {
    //Implementation of subtopics
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertSubtopic(CourseSubtopics subtopics);

    @Delete
    void deleteSubtopic(CourseSubtopics subtopic);

    @Query("Select * from CourseSubtopics where CourseSubtopics.id == :subtopic_id")
    LiveData<CourseSubtopics> getSubtopic(int subtopic_id);

    @Query("Select * from CourseSubtopics Order by CourseSubtopics.id")
    LiveData<List<CourseSubtopics>> getAllSubtopics();

    @Update
    void updateSubtopic(CourseSubtopics subtopic);

    @Query("Delete from CourseSubtopics")
    void deleteAllSubtopics();
}
