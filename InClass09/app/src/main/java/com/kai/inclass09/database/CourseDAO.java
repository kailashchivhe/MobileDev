package com.kai.inclass09.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseDAO {
    @Query("SELECT * FROM course_taken")
    List<CourseTaken> getAll();

    @Insert
    void insertAll(CourseTaken... courseTaken);

    @Delete
    void delete(CourseTaken courseTaken);
}
