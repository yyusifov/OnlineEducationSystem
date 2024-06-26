package com.example.onlineeducationsystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineeducationsystem.model.Courses;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePage extends AppCompatActivity {

    private BottomNavigationView navigationBar;

    private Bundle bundle;

    private CourseSection courseSection;

    private GeneralPage generalPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        navigationBar = findViewById(R.id.navBar);


        bundle = new Bundle();

        bundle.putInt("Id_of_entered_user", getIntent().getIntExtra("Id_of_entered_user", 1));

        generalPage = GeneralPage.newInstance(HomePage.this);

        courseSection = CourseSection.newInstance();


        generalPage.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.homePage, generalPage).commit();

        navigationBar.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.home_page){
                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, generalPage).commit();
            }
            else if(item.getItemId() == R.id.myCourses){
                MyCourses myCourses = MyCourses.newInstance(HomePage.this);

                myCourses.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, myCourses).commit();
            }
            else if(item.getItemId() == R.id.aboutSystem){
                AboutMe aboutMe = AboutMe.newInstance();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("user_id", getIntent().getIntExtra("Id_of_entered_user", -5));
                aboutMe.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, aboutMe).commit();
            }
            else if(item.getItemId() == R.id.profileSection){
                MyProfile myProfile = MyProfile.newInstance();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("user_id", getIntent().getIntExtra("Id_of_entered_user", -5));
                myProfile.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.homePage, myProfile).commit();
            }


            return true;
        });
    }

    public void moveToCourseSection(Courses courses){
        CourseSection courseSection = CourseSection.newInstance();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("course_id", courses.getId());
        bundle1.putInt("user_id", getIntent().getIntExtra("Id_of_entered_user", -5));
        courseSection.setArguments(bundle1);
        getSupportFragmentManager().beginTransaction().replace(R.id.homePage, courseSection).commit();
    }

    public void moveToDescriptionSection(Courses courses){
        CourseDescriptionFragment courseDescriptionFragment = CourseDescriptionFragment.newInstance();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("course_id", courses.getId());
        bundle1.putInt("user_id", getIntent().getIntExtra("Id_of_entered_user", -5));
        bundle1.putInt("description_id", courses.getDescription_id());
        courseDescriptionFragment.setArguments(bundle1);
        getSupportFragmentManager().beginTransaction().replace(R.id.homePage, courseDescriptionFragment).commit();

    }
}