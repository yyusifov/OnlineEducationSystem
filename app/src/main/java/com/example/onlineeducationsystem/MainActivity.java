package com.example.onlineeducationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.UserRole;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button signIn;

    private TextView forgotPassword;

    private EditText username, password;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.signIn);

        forgotPassword = findViewById(R.id.forgotPassword);

        username = findViewById(R.id.personUsername);

        password = findViewById(R.id.personPassword);




        userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(UserViewModel.class);



//          UserRole userRole = new UserRole();
//
//          userRole.setId(1);
//
//          userRole.setRole_name("Student");
//
//          UserViewModel.insertRole(userRole);
//
//        UserInformation userInformation = new UserInformation();
//
//        userInformation.setUser_firstname("Yadigar");
//
//        userInformation.setUser_surname("Yusifov");
//
//        userInformation.setUser_password("yadigar313");
//
//        userInformation.setUser_email("yyusifov12087@ada.edu.az");
//
//        userInformation.setUser_name("yyusifov12087");
//
//        userInformation.setRole_id(1);
//
//        userInformation.setCreation_date(new Date().getTime());
//
//        userInformation.setUpdate_date(new Date().getTime());
//
//        UserViewModel.insertUserInformation(userInformation);
//
//        CourseDescription courseDescription = new CourseDescription();
//
//        courseDescription.setDescription("This course will mainly focus on different aspects of Software Product");
//
//        courseDescription.setPassingScore(60.0);
//
//        courseDescription.setSyllabusLink("https://www.cxc.org/SiteAssets/syllabusses/CAPE/CAPE%20History.pdf");
//
//        UserViewModel.insertCourseDescription(courseDescription);
//
//        Courses course = new Courses();
//
//        course.setCourse_code(10259);
//
//        course.setCourse_name("Physics");
//
//        course.setCourse_instructor("Necati Sasmaz");
//
//        course.setDescription_id(2);
//
//        UserViewModel.insertCourse(course);
//
//        CourseTopics courseTopics = new CourseTopics();
//
//        courseTopics.setCourse_id(1);
//
//        courseTopics.setTopic_name("Renaissance Religion and Cartography");
//
//        courseTopics.setTopic_number(9);
//
//        UserViewModel.insertCourseTopic(courseTopics);
//
//        CourseSubtopics courseSubtopics = new CourseSubtopics();
//
//        courseSubtopics.setSubtopic_name("Maps and the Printed World View");
//
//        courseSubtopics.setSubtopic_file("https://jmp.sh/rWiqX4JK");
//
//        courseSubtopics.setSubtopic_number(91);
//
//        courseSubtopics.setTopic_id(9);
//
//        UserViewModel.insertCourseSubtopic(courseSubtopics);
//
//        UserCourse userCourse = new UserCourse();
//
//        userCourse.setCourse_id(2);
//        userCourse.setUser_id(1);
//
//        UserViewModel.insertUserCourse(userCourse);
//
//        Quiz quiz = new Quiz();
//
//        quiz.setQuiz_name("Graded Quiz 1");
//
//        quiz.setCourse_id(1);
//
//        quiz.setTotal_number_of_questions(10);
//
//        UserViewModel.insertQuiz(quiz);

//        Question question = new Question(1, 2, "Around what year was the \"Book of Hours, Use of Paris\" created, marking it as a significant artifact of religious and artistic value?", "1400", "1450", "1493", "1543", "1450", 11);
//
//        UserViewModel.insertQuestion(question);


        userViewModel.getAllRoles().observe(this, new Observer<List<UserRole>>() {
            @Override
            public void onChanged(List<UserRole> userRoles) {
                for (int i = 0; i < userRoles.size(); i++) {
                    Log.d("element " + userRoles.get(i).getId(), userRoles.get(i).getRole_name());
                }
            }
        });
    }

    public void onSignIn(View view){

//        Intent intent = new Intent(MainActivity.this, HomePage.class);
//        startActivity(intent);

        userViewModel.getAllUserInformation().observe(MainActivity.this, userInformation -> {
            for(int i = 0; i < userInformation.size(); i++){
                if(username.getText().toString().trim().equals(userInformation.get(i).getUser_name())
                        && password.getText().toString().trim().equals(userInformation.get(i).getUser_password())){

                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    intent.putExtra("Id_of_entered_user", userInformation.get(i).getId());
                    startActivity(intent);

                }
            }
        });
    }

    public void onForgotPassword(View view){
        Intent intent = new Intent(MainActivity.this, PasswordRecovery.class);

        startActivity(intent);
    }
}