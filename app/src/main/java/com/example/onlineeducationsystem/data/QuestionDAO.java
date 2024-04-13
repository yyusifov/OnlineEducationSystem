package com.example.onlineeducationsystem.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlineeducationsystem.model.Question;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuestion(Question question);

    @Delete
    void deleteQuestion(Question question);

    @Query("Select * from Question where Question.question_id == :question_id")
    LiveData<Question> getQuestion(int question_id);

    @Query("Select * from Question Order by Question.question_id")
    LiveData<List<Question>> getAllQuestions();

    @Update
    void updateQuestion(Question question);

    @Query("Delete from Question")
    void deleteAllQuestions();
}
