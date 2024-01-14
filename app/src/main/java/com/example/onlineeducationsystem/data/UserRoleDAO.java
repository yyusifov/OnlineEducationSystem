package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserRole;

import java.util.List;

@Dao
public interface UserRoleDAO {
    //Implementation of student role
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRole(UserRole role);

    @Delete
    void deleteRole(UserRole role);

    @Query("Select * from UserRole where UserRole.id == :role_id")
    LiveData<UserRole> getRole(int role_id);

    @Query("Select * from UserRole Order by UserRole.id")
    LiveData<List<UserRole>> getAllRoles();

    @Update
    void updateRole(UserRole role);

    @Query("Delete from UserRole")
    void deleteAllRoles();
}
