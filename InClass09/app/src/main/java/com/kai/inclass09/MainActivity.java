package com.kai.inclass09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kai.inclass09.database.CourseTaken;
import com.kai.inclass09.database.RoomHelper;

/*
 * Name: Kailash Chivhe & Ankit Vaity
 * Assignment: InClass09
 * MainActivity
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomHelper.init( getApplicationContext() );

        CourseTaken courseTaken = new CourseTaken();
        courseTaken.CourseNumber = "ITCS 6114";
        courseTaken.courseTitle = "DSA";
        courseTaken.creditHours = 2;
        courseTaken.letterGrade = "B";

        new Thread(new Runnable() {
            @Override
            public void run() {
//                RoomHelper.insert(courseTaken);
//                RoomHelper.insert(courseTaken);
//                RoomHelper.insert(courseTaken);
//                RoomHelper.insert(courseTaken);
                Log.d("MainActivity", "onCreate: insert " + RoomHelper.getAllCourses().toString() );
//                RoomHelper.delete( courseTaken );
                Log.d("MainActivity", "onCreate: delete " + RoomHelper.getAllCourses().toString() );
            }
        }).start();
    }
}