package com.example.onlineeducationsystem.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlineeducationsystem.data.CourseDescriptionDAO;
import com.example.onlineeducationsystem.data.CourseSubtopicsDAO;
import com.example.onlineeducationsystem.data.CourseTopicsDAO;
import com.example.onlineeducationsystem.data.CoursesDAO;
import com.example.onlineeducationsystem.data.QuestionDAO;
import com.example.onlineeducationsystem.data.QuizDAO;
import com.example.onlineeducationsystem.data.UserAnswerDAO;
import com.example.onlineeducationsystem.data.UserCourseDAO;
import com.example.onlineeducationsystem.data.UserDAO;
import com.example.onlineeducationsystem.data.UserGenderDAO;
import com.example.onlineeducationsystem.data.UserGradesDAO;
import com.example.onlineeducationsystem.data.UserRoleDAO;
import com.example.onlineeducationsystem.model.CourseDescription;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;
import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserAnswer;
import com.example.onlineeducationsystem.model.UserCourse;
import com.example.onlineeducationsystem.model.UserGender;
import com.example.onlineeducationsystem.model.UserGrades;
import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.model.UserRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserInformation.class, UserRole.class, Courses.class, CourseTopics.class, CourseSubtopics.class, CourseDescription.class, UserCourse.class, Quiz.class, Question.class, UserGrades.class, UserAnswer.class, UserGender.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {

    public static final int number_of_threads = 4;

    public abstract UserDAO getUserDAO();

    public abstract UserRoleDAO getUserRoleDAO();

    public abstract CoursesDAO getCoursesDAO();

    public abstract CourseTopicsDAO getCourseTopicsDAO();

    public abstract CourseSubtopicsDAO getCourseSubtopicsDAO();

    public abstract CourseDescriptionDAO getCourseDescriptionDAO();

    public abstract UserCourseDAO getUserCourseDAO();

    public abstract QuizDAO getQuizDAO();

    public abstract QuestionDAO getQuestionDAO();

    public abstract UserGradesDAO getUserGradesDAO();

    public abstract UserAnswerDAO getUserAnswerDAO();

    public abstract UserGenderDAO getUserGenderDAO();

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
