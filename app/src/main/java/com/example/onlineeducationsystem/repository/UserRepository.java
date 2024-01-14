package com.example.onlineeducationsystem.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.onlineeducationsystem.data.UserDAO;
import com.example.onlineeducationsystem.data.UserRoleDAO;
import com.example.onlineeducationsystem.model.UserInformation;
import com.example.onlineeducationsystem.model.UserRole;
import com.example.onlineeducationsystem.util.DatabaseRoom;

import java.util.List;

public class UserRepository {
    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;
    public UserRepository(Application application){
        DatabaseRoom databaseRoom = DatabaseRoom.getInstance(application.getApplicationContext());

        userDAO = databaseRoom.getUserDAO();
        userRoleDAO = databaseRoom.getUserRoleDAO();
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
}
