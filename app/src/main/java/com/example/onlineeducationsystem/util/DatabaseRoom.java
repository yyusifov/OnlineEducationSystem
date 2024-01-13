package com.example.onlineeducationsystem.util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlineeducationsystem.data.StudentDAO;
import com.example.onlineeducationsystem.model.StudentInformation;
import com.example.onlineeducationsystem.model.UserRole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {StudentInformation.class, UserRole.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {

    public static final int number_of_threads = 4;

    public abstract StudentDAO getStudentDAO();

    public static volatile DatabaseRoom databaseRoom;

    public static ExecutorService executorService = Executors.newFixedThreadPool(number_of_threads);

    public static DatabaseRoom getInstance(Context context){
        if(databaseRoom == null){
            synchronized (DatabaseRoom.class){
                if(databaseRoom == null){
                    databaseRoom = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "User_Database").build();
                }
            }
        }
        return databaseRoom;
    }
}
