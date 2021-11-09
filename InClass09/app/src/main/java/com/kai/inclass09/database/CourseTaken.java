package com.kai.inclass09.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="course_taken")
public class CourseTaken {
    @PrimaryKey(autoGenerate = true)
    public int rid;

    @ColumnInfo(name = "credit_hours")
    public  double creditHours;

    @ColumnInfo(name = "course_number")
    public String CourseNumber;

    @ColumnInfo(name = "course_title")
    public String courseTitle;

    @ColumnInfo(name = "letter_grade")
    public String letterGrade;

    @Override
    public String toString() {
        return "CourseTaken{" +
                "rid=" + rid +
                ", creditHours=" + creditHours +
                ", CourseNumber='" + CourseNumber + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", letterGrade='" + letterGrade + '\'' +
                '}';
    }
}
