package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.Quiz;

import java.util.List;

@Dao
public interface QuizDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuiz(Quiz quiz);

    @Delete
    void deleteQuiz(Quiz quiz);

    @Query("Select * from Quiz where Quiz.quiz_id == :quiz_id")
    LiveData<Quiz> getQuiz(int quiz_id);

    @Query("Select * from Quiz Order by Quiz.quiz_id")
    LiveData<List<Quiz>> getAllQuiz();

    @Update
    void updateQuiz(Quiz quiz);

    @Query("Delete from Quiz")
    void deleteAllQuiz();
}
