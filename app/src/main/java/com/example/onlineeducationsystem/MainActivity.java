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

        signIn = findViewById(R.id.confirm_password);

        forgotPassword = findViewById(R.id.forgotPassword);

        username = findViewById(R.id.personUsername);

        password = findViewById(R.id.personPassword);




        userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(UserViewModel.class);

//        UserViewModel.deleteAllCourses();
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
//        userInformation.setUser_firstname("Akram");
//
//        userInformation.setUser_surname("Bayramli");
//
//        userInformation.setUser_password("akram313");
//
//        userInformation.setUser_email("abayramli14526@ada.edu.az");
//
//        userInformation.setUser_name("abayramli14526");
//
//        userInformation.setRole_id(1);
//
//        userInformation.setCreation_date(new Date().getTime());
//
//        userInformation.setUpdate_date(new Date().getTime());
//
//        UserViewModel.insertUserInformation(userInformation);

//        CourseDescription courseDescription = new CourseDescription();
//
//        courseDescription.setDescription("This course will mainly focus on different aspects of Software Product");
//
//        courseDescription.setPassingScore(60.0);
//
//        courseDescription.setSyllabusLink("https://www.lehman.edu/faculty/rbettiol/lehman_teaching/2018mat175/MAT175-dept-syllabus.pdf");
//
//        UserViewModel.insertCourseDescription(courseDescription);
//
//        Courses course = new Courses();
//
//        course.setCourse_code(10258);
//
//        course.setCourse_name("Calculus 1");
//
//        course.setCourse_instructor("Yagub Aliyev");
//
//        course.setDescription_id(1);
//
//        UserViewModel.insertCourse(course);
//
//        CourseTopics courseTopics = new CourseTopics();
//
//        courseTopics.setCourse_id(1);
//
//        courseTopics.setTopic_name("Integral");
//
//        courseTopics.setTopic_number(1);
//
//        UserViewModel.insertCourseTopic(courseTopics);
//
//        CourseSubtopics courseSubtopics = new CourseSubtopics();
//
//        courseSubtopics.setSubtopic_name("Limit Subtopic 1");
//
//        courseSubtopics.setSubtopic_file("Link for subtopic 1");
//
//        courseSubtopics.setSubtopic_number(11);
//
//        courseSubtopics.setTopic_id(1);
//
//        UserViewModel.insertCourseSubtopic(courseSubtopics);
//
//        UserCourse userCourse = new UserCourse();
//
//        userCourse.setCourse_id(1);
//        userCourse.setUser_id(2);
//
//        UserViewModel.insertUserCourse(userCourse);

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