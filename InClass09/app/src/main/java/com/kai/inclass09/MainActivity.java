package com.kai.inclass09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kai.inclass09.database.CourseTaken;
import com.kai.inclass09.database.RoomHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoomHelper.init( getApplicationContext() );
        CourseTaken courseTaken = new CourseTaken();
        courseTaken.CourseNumber = "ITCS 5180";
        courseTaken.courseTitle = "Mobile App";
        courseTaken.creditHours = 3;
        courseTaken.letterGrade = "A";
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomHelper.insert(courseTaken);
                Log.d("MainActivity", "onCreate: insert " + RoomHelper.getAllCourses().toString() );
                RoomHelper.delete( courseTaken );
                Log.d("MainActivity", "onCreate: delete " + RoomHelper.getAllCourses().toString() );
            }
        }).start();
    }
}