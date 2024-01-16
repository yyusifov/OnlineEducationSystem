package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserCourse;

import java.util.List;

@Dao
public interface UserCourseDAO {
    //Implementation of UserCourse
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserCourse(UserCourse userCourse);

    @Delete
    void deleteUserCourse(UserCourse userCourse);

    @Query("Select * from UserCourse where UserCourse.id == :userCourse_id")
    LiveData<UserCourse> getUserCourse(int userCourse_id);

    @Query("Select * from UserCourse Order by UserCourse.id")
    LiveData<List<UserCourse>> getAllUserCourses();

    @Update
    void updateUserCourses(UserCourse userCourse);

    @Query("Delete from UserCourse")
    void deleteAllUserCourses();
}
