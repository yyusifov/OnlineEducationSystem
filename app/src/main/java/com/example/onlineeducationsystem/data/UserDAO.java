package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserInformation;

import java.util.List;

@Dao
public interface UserDAO {

    //Implementation of student information
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserInformation(UserInformation userInformation);

    @Delete
    void deleteUserInformation(UserInformation userInformation);

    @Query("Select * from UserInformation where UserInformation.id == :role_id")
    LiveData<UserInformation> getUserInformation(int role_id);

    @Query("Select * from UserInformation Order by UserInformation.id")
    LiveData<List<UserInformation>> getAllUserInformation();

    @Update
    void updateUserInformation(UserInformation userInformation);

    @Query("Delete from UserInformation")
    void deleteAllUserInformation();

}
