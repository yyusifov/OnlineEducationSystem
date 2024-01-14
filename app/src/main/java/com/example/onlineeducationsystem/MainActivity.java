package com.example.onlineeducationsystem;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.model.UserRole;
import com.example.onlineeducationsystem.util.UserViewModel;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel userViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(UserViewModel.class);

//          UserRole userRole = new UserRole();
//
//          userRole.setId(1);
//
//          userRole.setRole_name("Student");
//
//          UserViewModel.insertRole(userRole);

        UserInformation userInformation = new UserInformation();

        userInformation.setUser_firstname("Yadigar");

        userInformation.setUser_surname("Yusifov");

        userInformation.setUser_password("yadigar313");

        userInformation.setUser_email("yyusifov12087@ada.edu.az");

        userInformation.setUser_name("yyusifov12087");

        userInformation.setRole_id(5);

        userInformation.setCreation_date(new Date().getTime());

        userInformation.setUpdate_date(new Date().getTime());

        UserViewModel.insertUserInformation(userInformation);

        userViewModel.getAllRoles().observe(this, new Observer<List<UserRole>>() {
            @Override
            public void onChanged(List<UserRole> userRoles) {
                for (int i = 0; i < userRoles.size(); i++) {
                    Log.d("element " + userRoles.get(i).getId(), userRoles.get(i).getRole_name());
                }
            }
        });
    }
}