package com.kai.inclass09.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CourseTaken.class}, version = 1)
public abstract class CourseDatabase extends RoomDatabase {
    public abstract CourseDAO courseDao();
}
