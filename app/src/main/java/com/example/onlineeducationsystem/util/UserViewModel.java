package com.example.onlineeducationsystem.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.onlineeducationsystem.model.CourseDescription;
import com.example.onlineeducationsystem.model.CourseSubtopics;
import com.example.onlineeducationsystem.model.CourseTopics;
import com.example.onlineeducationsystem.model.Courses;
import com.example.onlineeducationsystem.model.Question;
import com.example.onlineeducationsystem.model.Quiz;
import com.example.onlineeducationsystem.model.UserAnswer;
import com.example.onlineeducationsystem.model.UserCourse;
import com.example.onlineeducationsystem.model.UserGrades;
import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.model.UserRole;
import com.example.onlineeducationsystem.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    public static UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
    }

    // UserAnswer implementation
    public LiveData<List<UserAnswer>> getAllUserAnswers(){
        return userRepository.getAllUserAnswers();
    }

    public LiveData<UserAnswer> getUserAnswer(int user_answer_id){
        return userRepository.getUserAnswer(user_answer_id);
    }

    public static void insertUserAnswer(UserAnswer userAnswer){
        userRepository.insertUserAnswer(userAnswer);
    }

    public static void deleteUserAnswer(UserAnswer userAnswer){
        userRepository.deleteUserAnswer(userAnswer);
    }

    public static void deleteAllUserAnswers(){
        userRepository.deleteAllUserAnswers();
    }

    public static void updateUserAnswers(UserAnswer userAnswer){
        userRepository.updateUserAnswers(userAnswer);
    }

    // UserGrades implementation
    public LiveData<List<UserGrades>> getAllUserGrades(){
        return userRepository.getAllUserGrades();
    }

    public LiveData<UserGrades> getUserGrade(int usergrades_id){
        return userRepository.getUserGrade(usergrades_id);
    }

    public static void insertUserGrade(UserGrades userGrades){
        userRepository.insertUserGrades(userGrades);
    }

    public static void deleteUserGrade(UserGrades userGrades){
        userRepository.deleteUserGrade(userGrades);
    }

    public static void deleteAllUserGrades(){
        userRepository.deleteAllUserGrades();
    }

    public static void updateUserGrades(UserGrades userGrades){
        userRepository.updateUserGrades(userGrades);
    }

    // Quiz implementation
    public LiveData<List<Quiz>> getAllQuiz(){
        return userRepository.getAllQuiz();
    }

    public LiveData<Quiz> getQuiz(int quiz_id){
        return userRepository.getQuiz(quiz_id);
    }

    public static void insertQuiz(Quiz quiz){
        userRepository.insertQuiz(quiz);
    }

    public static void deleteQuiz(Quiz quiz){
        userRepository.deleteQuiz(quiz);
    }

    public static void deleteAllQuiz(){
        userRepository.deleteAllQuiz();
    }

    public static void updateQuiz(Quiz quiz){
        userRepository.updateQuiz(quiz);
    }

    // Question implementation
    public LiveData<List<Question>> getAllQuestions(){
        return userRepository.getAllQuestions();
    }

    public LiveData<Question> getQuestion(int question_id){
        return userRepository.getQuestion(question_id);
    }

    public static void insertQuestion(Question question){
        userRepository.insertQuestion(question);
    }

    public static void deleteQuestion(Question question){
        userRepository.deleteQuestion(question);
    }

    public static void deleteAllQuestions(){
        userRepository.deleteAllQuestions();
    }

    public static void updateQuestion(Question question){
        userRepository.updateQuestion(question);
    }

    // UserInformation implementation
    public LiveData<List<UserInformation>> getAllUserInformation(){
        return userRepository.getAllUserInformation();
    }

    public LiveData<UserInformation> getUserInformation(int user_id){
        return userRepository.getUserInformation(user_id);
    }

    public static void insertUserInformation(UserInformation userInformation){
        userRepository.insertUserInformation(userInformation);
    }

    public static void deleteUserInformation(UserInformation userInformation){
        userRepository.deleteUserInformation(userInformation);
    }

    public static void deleteAllUserInformation(){
        userRepository.deleteAllUserInformation();
    }

    public static void updateUserInformation(UserInformation userInformation){
        userRepository.updateUserInformation(userInformation);
    }

    // UserRole implementation
    public LiveData<List<UserRole>> getAllRoles(){
        return userRepository.getAllRoles();
    }

    public LiveData<UserRole> getRole(int role_id){
        return userRepository.getRole(role_id);
    }

    public static void insertRole(UserRole userRole){
        userRepository.insertRole(userRole);
    }

    public static void deleteRole(UserRole userRole){
        userRepository.deleteRole(userRole);
    }

    public static void deleteAllRoles(){
        userRepository.deleteAllRoles();
    }

    public static void updateRole(UserRole userRole){
        userRepository.updateRole(userRole);
    }

    // Courses Implementation
    public LiveData<List<Courses>> getAllCourses(){
        return userRepository.getAllCourses();
    }

    public LiveData<Courses> getCourse(int course_id){
        return userRepository.getCourse(course_id);
    }

    public static void insertCourse(Courses course){
        userRepository.insertCourse(course);
    }

    public static void deleteCourse(Courses course){
        userRepository.deleteCourse(course);
    }

    public static void deleteAllCourses(){
        userRepository.deleteAllCourses();
    }

    public static void updateCourse(Courses course){
        userRepository.updateCourse(course);
    }

    // User Course implementation
    public LiveData<List<UserCourse>> getAllUserCourses(){
        return userRepository.getAllUserCourses();
    }

    public LiveData<UserCourse> getUserCourse(int user_course_id){
        return userRepository.getUserCourse(user_course_id);
    }

    public static void insertUserCourse(UserCourse userCourse){
        userRepository.insertUserCourse(userCourse);
    }

    public static void deleteUserCourse(UserCourse userCourse){
        userRepository.deleteUserCourse(userCourse);
    }

    public static void deleteAllUserCourses(){
        userRepository.deleteAllUserCourses();
    }

    public static void updateUserCourse(UserCourse userCourse){
        userRepository.updateUserCourse(userCourse);
    }

    // Course Topics implementation
    public LiveData<List<CourseTopics>> getAllCourseTopics(){
        return userRepository.getAllCourseTopics();
    }

    public LiveData<CourseTopics> getCourseTopic(int course_topic_id){
        return userRepository.getCourseTopic(course_topic_id);
    }

    public static void insertCourseTopic(CourseTopics courseTopic){
        userRepository.insertCourseTopic(courseTopic);
    }

    public static void deleteCourseTopic(CourseTopics courseTopic){
        userRepository.deleteCourseTopic(courseTopic);
    }

    public static void deleteAllCourseTopics(){
        userRepository.deleteAllCourseTopics();
    }

    public static void updateCourseTopic(CourseTopics courseTopic){
        userRepository.updateCourseTopic(courseTopic);
    }

    // Course Subtopic Implementation
    public LiveData<List<CourseSubtopics>> getAllCourseSubtopics(){
        return userRepository.getAllCourseSubtopics();
    }

    public LiveData<CourseSubtopics> getCourseSubtopic(int course_subtopic_id){
        return userRepository.getCourseSubtopic(course_subtopic_id);
    }

    public static void insertCourseSubtopic(CourseSubtopics courseSubtopic){
        userRepository.insertCourseSubtopic(courseSubtopic);
    }

    public static void deleteCourseSubtopic(CourseSubtopics courseSubtopics){
        userRepository.deleteCourseSubtopic(courseSubtopics);
    }

    public static void deleteAllCourseSubtopics(){
        userRepository.deleteAllCourseSubtopics();
    }

    public static void updateCourseSubtopic(CourseSubtopics courseSubtopics){
        userRepository.updateCourseSubtopic(courseSubtopics);
    }

    // Course Description implementation
    public LiveData<List<CourseDescription>> getAllCourseDescription(){
        return userRepository.getAllCourseDescriptions();
    }

    public LiveData<CourseDescription> getCourseDescription(int course_description_id){
        return userRepository.getCourseDescription(course_description_id);
    }

    public static void insertCourseDescription(CourseDescription courseDescription){
        userRepository.insertCourseDescription(courseDescription);
    }

    public static void deleteCourseDescription(CourseDescription courseDescription){
        userRepository.deleteCourseDescription(courseDescription);
    }

    public static void deleteAllCourseDescription(){
        userRepository.deleteAllCourseDescriptions();
    }

    public static void updateCourseDescription(CourseDescription courseDescription){
        userRepository.updateCourseDescription(courseDescription);
    }
}
