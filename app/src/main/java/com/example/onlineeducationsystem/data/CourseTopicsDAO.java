package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.CourseTopics;

import java.util.List;

public interface CourseTopicsDAO {
    //Implementation of courses
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTopic(CourseTopics topic);

    @Delete
    void deleteTopic(CourseTopics topic);

    @Query("Select * from CourseTopics where CourseTopics.id == :topic_id")
    LiveData<CourseTopics> getTopic(int topic_id);

    @Query("Select * from CourseTopics Order by CourseTopics.id")
    LiveData<List<CourseTopics>> getAllTopics();

    @Update
    void updateTopic(CourseTopics topic);

    @Query("Delete from CourseTopics")
    void deleteAllTopics();
}
