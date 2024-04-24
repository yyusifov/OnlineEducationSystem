package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserGender;

import java.util.List;

@Dao
public interface UserGenderDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertGender(UserGender userGender);

    @Delete
    void deleteGender(UserGender userGender);

    @Query("Select * from UserGender where usergender.id == :gender_id")
    LiveData<UserGender> getGender(int gender_id);

    @Query("Select * from UserGender Order by UserGender.id")
    LiveData<List<UserGender>> getAllGenders();

    @Update
    void updateGender(UserGender userGender);

    @Query("Delete from UserGender")
    void deleteAllGender();
}
