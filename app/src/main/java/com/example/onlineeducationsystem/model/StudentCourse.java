package com.example.onlineeducationsystem.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = StudentInformation.class,
                parentColumns = "id",
                childColumns = "student_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Courses.class,
                parentColumns = "id",
                childColumns = "course_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class StudentCourse {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int student_id;

    private int course_id;
}
