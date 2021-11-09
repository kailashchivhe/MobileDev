package com.kai.inclass09.database;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

public class RoomHelper {

    static CourseDatabase courseDatabase;

    static CourseDAO courseDAO;

    public static void init(Context context){
        courseDatabase = Room.databaseBuilder(context, CourseDatabase.class, "course-database").build();
        courseDAO = courseDatabase.courseDao();
    }

    public static void insert( CourseTaken courseTaken ){
        courseDAO.insertAll( courseTaken );
    }

    public static void delete( CourseTaken courseTaken ){
        courseDAO.delete( courseTaken );
    }

    public static List<CourseTaken> getAllCourses(){
        return courseDAO.getAll();
    }
}
