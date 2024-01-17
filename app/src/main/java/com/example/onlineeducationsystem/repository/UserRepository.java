package com.example.onlineeducationsystem.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

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
import com.example.onlineeducationsystem.util.DatabaseRoom;

import java.util.List;

public class UserRepository {
    private final UserDAO userDAO;
    private final CoursesDAO coursesDAO;
    private final UserRoleDAO userRoleDAO;
    private final UserCourseDAO userCourseDAO;
    private final CourseTopicsDAO courseTopicsDAO;
    private final CourseSubtopicsDAO courseSubtopicsDAO;
    private final CourseDescriptionDAO courseDescriptionDAO;

    public UserRepository(Application application){

        DatabaseRoom databaseRoom = DatabaseRoom.getInstance(application.getApplicationContext());

        userDAO = databaseRoom.getUserDAO();
        userRoleDAO = databaseRoom.getUserRoleDAO();
        coursesDAO = databaseRoom.getCoursesDAO();
        userCourseDAO = databaseRoom.getUserCourseDAO();
        courseTopicsDAO = databaseRoom.getCourseTopicsDAO();
        courseSubtopicsDAO = databaseRoom.getCourseSubtopicsDAO();
        courseDescriptionDAO = databaseRoom.getCourseDescriptionDAO();

    }

    // User Information operations are set below:
    public LiveData<List<UserInformation>> getAllUserInformation(){
        return userDAO.getAllUserInformation();
    }

    public LiveData<UserInformation> getUserInformation(int user_id){
        return userDAO.getUserInformation(user_id);
    }

    public void insertUserInformation(UserInformation userInformation){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.insertUserInformation(userInformation);
            }
        });
    }

    public void updateUserInformation(UserInformation userInformation){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.updateUserInformation(userInformation);
            }
        });
    }

    public void deleteUserInformation(UserInformation userInformation){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.deleteUserInformation(userInformation);
            }
        });
    }

    public void deleteAllUserInformation(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDAO.deleteAllUserInformation();
            }
        });
    }

    // User Role operations are set below:

    public LiveData<List<UserRole>> getAllRoles(){
        return userRoleDAO.getAllRoles();
    }

    public LiveData<UserRole> getRole(int role_id){
        return userRoleDAO.getRole(role_id);
    }

    public void insertRole(UserRole userRole){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userRoleDAO.insertRole(userRole);
            }
        });
    }

    public void updateRole(UserRole userRole){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userRoleDAO.updateRole(userRole);
            }
        });
    }

    public void deleteRole(UserRole userRole){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userRoleDAO.deleteRole(userRole);
            }
        });
    }

    public void deleteAllRoles(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userRoleDAO.deleteAllRoles();
            }
        });
    }

    // Courses operations are set below:

    public LiveData<List<Courses>> getAllCourses(){
        return coursesDAO.getAllCourses();
    }

    public LiveData<Courses> getCourse(int course_id){
        return coursesDAO.getCourse(course_id);
    }

    public void insertCourse(Courses course){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                coursesDAO.insertCourse(course);
            }
        });
    }

    public void updateCourse(Courses course){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                coursesDAO.updateCourse(course);
            }
        });
    }

    public void deleteCourse(Courses course){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                coursesDAO.deleteCourse(course);
            }
        });
    }

    public void deleteAllCourses(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                coursesDAO.deleteAllCourses();
            }
        });
    }

    // CourseDescription operations are set below:

    public LiveData<List<CourseDescription>> getAllCourseDescriptions(){
        return courseDescriptionDAO.getAllCourseDescriptions();
    }

    public LiveData<CourseDescription> getCourseDescription(int courseDescriptionId){
        return courseDescriptionDAO.getCourseDescription(courseDescriptionId);
    }

    public void insertCourseDescription(CourseDescription courseDescription){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseDescriptionDAO.insertCourseDescription(courseDescription);
            }
        });
    }

    public void updateCourseDescription(CourseDescription courseDescription){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseDescriptionDAO.updateCourseDescription(courseDescription);
            }
        });
    }

    public void deleteCourseDescription(CourseDescription courseDescription){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseDescriptionDAO.deleteCourseDescription(courseDescription);
            }
        });
    }

    public void deleteAllCourseDescriptions(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseDescriptionDAO.deleteAllCourseDescriptions();
            }
        });
    }

    // User Course operations are set below:

    public LiveData<List<UserCourse>> getAllUserCourses(){
        return userCourseDAO.getAllUserCourses();
    }

    public LiveData<UserCourse> getUserCourse(int user_course_id){
        return userCourseDAO.getUserCourse(user_course_id);
    }

    public void insertUserCourse(UserCourse userCourse){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userCourseDAO.insertUserCourse(userCourse);
            }
        });
    }

    public void updateUserCourse(UserCourse userCourse){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userCourseDAO.updateUserCourses(userCourse);
            }
        });
    }

    public void deleteUserCourse(UserCourse userCourse){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userCourseDAO.deleteUserCourse(userCourse);
            }
        });
    }

    public void deleteAllUserCourses(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userCourseDAO.deleteAllUserCourses();
            }
        });
    }

    // Course Topics operations are set below:

    public LiveData<List<CourseTopics>> getAllCourseTopics(){
        return courseTopicsDAO.getAllTopics();
    }

    public LiveData<CourseTopics> getCourseTopic(int course_topic_id){
        return courseTopicsDAO.getTopic(course_topic_id);
    }

    public void insertCourseTopic(CourseTopics courseTopic){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseTopicsDAO.insertTopic(courseTopic);
            }
        });
    }

    public void updateCourseTopic(CourseTopics courseTopic){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseTopicsDAO.updateTopic(courseTopic);
            }
        });
    }

    public void deleteCourseTopic(CourseTopics courseTopic){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseTopicsDAO.deleteTopic(courseTopic);
            }
        });
    }

    public void deleteAllCourseTopics(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseTopicsDAO.deleteAllTopics();
            }
        });
    }

    // Course Subtopics are set below:

    public LiveData<List<CourseSubtopics>> getAllCourseSubtopics(){
        return courseSubtopicsDAO.getAllSubtopics();
    }

    public LiveData<CourseSubtopics> getCourseSubtopic(int course_subtopic_id){
        return courseSubtopicsDAO.getSubtopic(course_subtopic_id);
    }

    public void insertCourseSubtopic(CourseSubtopics courseSubtopics){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseSubtopicsDAO.insertSubtopic(courseSubtopics);
            }
        });
    }

    public void updateCourseSubtopic(CourseSubtopics courseSubtopics){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseSubtopicsDAO.updateSubtopic(courseSubtopics);
            }
        });
    }

    public void deleteCourseSubtopic(CourseSubtopics courseSubtopics){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseSubtopicsDAO.deleteSubtopic(courseSubtopics);
            }
        });
    }

    public void deleteAllCourseSubtopics(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                courseSubtopicsDAO.deleteAllSubtopics();
            }
        });
    }
}
