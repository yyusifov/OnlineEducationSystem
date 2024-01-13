package com.example.onlineeducationsystem.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    public static UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
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
}
