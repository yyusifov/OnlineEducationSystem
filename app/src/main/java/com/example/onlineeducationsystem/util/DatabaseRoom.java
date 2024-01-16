package com.example.onlineeducationsystem.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlineeducationsystem.data.CourseDescriptionDAO;
import com.example.onlineeducationsystem.data.CourseSubtopicsDAO;
import com.example.onlineeducationsystem.data.CourseTopicsDAO;
import com.example.onlineeducationsystem.data.CoursesDAO;
import com.example.onlineeducationsystem.data.UserCourseDAO;
import com.example.onlineeducationsystem.data.UserDAO;
import com.example.onlineeducationsystem.data.UserRoleDAO;
import com.example.onlineeducationsystem.model.CourseDescription;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;
import com.example.onlineeducationsystem.model.UserCourse;
import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.model.UserRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserInformation.class, UserRole.class, Courses.class, CourseTopics.class, CourseSubtopics.class, CourseDescription.class, UserCourse.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {

    public static final int number_of_threads = 4;

    public abstract UserDAO getUserDAO();

    public abstract UserRoleDAO getUserRoleDAO();

    public abstract CoursesDAO getCoursesDAO();

    public abstract CourseTopicsDAO getCourseTopicsDAO();

    public abstract CourseSubtopicsDAO getCourseSubtopicsDAO();

    public abstract CourseDescriptionDAO getCourseDescriptionDAO();

    public abstract UserCourseDAO getUserCourseDAO();

    public static volatile DatabaseRoom databaseRoom;

    public static ExecutorService executorService = Executors.newFixedThreadPool(number_of_threads);

    public static DatabaseRoom getInstance(Context context){
        if(databaseRoom == null){
            synchronized (DatabaseRoom.class){
                if(databaseRoom == null){
                    databaseRoom = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "User_Database").build();
                }
            }
        }
        return databaseRoom;
    }
}
