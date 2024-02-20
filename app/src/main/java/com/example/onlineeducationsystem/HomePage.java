package com.example.onlineeducationsystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

            }
            else if(item.getItemId() == R.id.profileSection){

            }


            return true;
        });
    }

    public void moveToCourseSection(){
        CourseSection courseSection = CourseSection.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.homePage, courseSection).commit();
    }
}