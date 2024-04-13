package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.UserAnswer;

import java.util.List;

@Dao
public interface UserAnswerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserAnswer(UserAnswer userAnswer);

    @Delete
    void deleteUserAnswer(UserAnswer userAnswer);

    @Query("Select * from UserAnswer where UserAnswer.user_answer_id == :user_answer_id")
    LiveData<UserAnswer> getUserAnswer(int user_answer_id);

    @Query("Select * from UserAnswer Order by UserAnswer.user_answer_id")
    LiveData<List<UserAnswer>> getAllUserAnswers();

    @Update
    void updateUserAnswer(UserAnswer userAnswer);

    @Query("Delete from UserAnswer")
    void deleteAllUserAnswers();
}
