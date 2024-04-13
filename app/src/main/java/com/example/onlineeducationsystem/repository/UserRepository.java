package com.example.onlineeducationsystem.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.onlineeducationsystem.data.CourseDescriptionDAO;
import com.example.onlineeducationsystem.data.CourseSubtopicsDAO;
import com.example.onlineeducationsystem.data.CourseTopicsDAO;
import com.example.onlineeducationsystem.data.CoursesDAO;
import com.example.onlineeducationsystem.data.QuestionDAO;
import com.example.onlineeducationsystem.data.QuizDAO;
import com.example.onlineeducationsystem.data.UserAnswerDAO;
import com.example.onlineeducationsystem.data.UserCourseDAO;
import com.example.onlineeducationsystem.data.UserDAO;
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
import com.example.onlineeducationsystem.model.UserGrades;
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

    private final QuestionDAO questionDAO;

    private final QuizDAO quizDAO;

    private final UserGradesDAO userGradesDAO;

    private final UserAnswerDAO userAnswerDAO;
    public UserRepository(Application application){

        DatabaseRoom databaseRoom = DatabaseRoom.getInstance(application.getApplicationContext());

        userDAO = databaseRoom.getUserDAO();
        userRoleDAO = databaseRoom.getUserRoleDAO();
        coursesDAO = databaseRoom.getCoursesDAO();
        userCourseDAO = databaseRoom.getUserCourseDAO();
        courseTopicsDAO = databaseRoom.getCourseTopicsDAO();
        courseSubtopicsDAO = databaseRoom.getCourseSubtopicsDAO();
        courseDescriptionDAO = databaseRoom.getCourseDescriptionDAO();
        quizDAO = databaseRoom.getQuizDAO();
        questionDAO = databaseRoom.getQuestionDAO();
        userGradesDAO = databaseRoom.getUserGradesDAO();
        userAnswerDAO = databaseRoom.getUserAnswerDAO();

    }

    // UserAnswer operations are set below
    public LiveData<List<UserAnswer>> getAllUserAnswers(){
        return userAnswerDAO.getAllUserAnswers();
    }

    public LiveData<UserAnswer> getUserAnswer(int user_answer_id){
        return userAnswerDAO.getUserAnswer(user_answer_id);
    }

    public void insertUserAnswer(UserAnswer userAnswer){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userAnswerDAO.insertUserAnswer(userAnswer);
            }
        });
    }

    public void updateUserAnswers(UserAnswer userAnswer){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userAnswerDAO.updateUserAnswer(userAnswer);
            }
        });
    }

    public void deleteUserAnswer(UserAnswer userAnswer){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userAnswerDAO.deleteUserAnswer(userAnswer);
            }
        });
    }

    public void deleteAllUserAnswers(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userAnswerDAO.deleteAllUserAnswers();
            }
        });
    }

    // UserGrades operations are set below
    public LiveData<List<UserGrades>> getAllUserGrades(){
        return userGradesDAO.getAllUserGrades();
    }

    public LiveData<UserGrades> getUserGrade(int grade_id){
        return userGradesDAO.getUserGrades(grade_id);
    }

    public void insertUserGrades(UserGrades userGrades){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userGradesDAO.insertUserGrades(userGrades);
            }
        });
    }

    public void updateUserGrades(UserGrades userGrades){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userGradesDAO.updateUserGrade(userGrades);
            }
        });
    }

    public void deleteUserGrade(UserGrades userGrades){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userGradesDAO.deleteUserGrades(userGrades);
            }
        });
    }

    public void deleteAllUserGrades(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                userGradesDAO.deleteAllUserGrades();
            }
        });
    }

    // Question operations are set below:
    public LiveData<List<Question>> getAllQuestions(){
        return questionDAO.getAllQuestions();
    }

    public LiveData<Question> getQuestion(int question_id){
        return questionDAO.getQuestion(question_id);
    }

    public void insertQuestion(Question question){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                questionDAO.insertQuestion(question);
            }
        });
    }

    public void updateQuestion(Question question){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                questionDAO.updateQuestion(question);
            }
        });
    }

    public void deleteQuestion(Question question){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                questionDAO.deleteQuestion(question);
            }
        });
    }

    public void deleteAllQuestions(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                questionDAO.deleteAllQuestions();
            }
        });
    }

    // Quiz operations are set below:
    public LiveData<List<Quiz>> getAllQuiz(){
        return quizDAO.getAllQuiz();
    }

    public LiveData<Quiz> getQuiz(int quiz_id){
        return quizDAO.getQuiz(quiz_id);
    }

    public void insertQuiz(Quiz quiz){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                quizDAO.insertQuiz(quiz);
            }
        });
    }

    public void updateQuiz(Quiz quiz){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                quizDAO.updateQuiz(quiz);
            }
        });
    }

    public void deleteQuiz(Quiz quiz){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                quizDAO.deleteQuiz(quiz);
            }
        });
    }

    public void deleteAllQuiz(){
        DatabaseRoom.executorService.execute(new Runnable() {
            @Override
            public void run() {
                quizDAO.deleteAllQuiz();
            }
        });
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
