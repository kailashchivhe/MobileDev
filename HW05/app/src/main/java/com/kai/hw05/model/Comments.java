package com.kai.hw05.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comments {
    String comment;
    String userId;
    String date;
    String forum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String userName;

    public Comments(String comment, String userId, String date, String forum, String userName) {
        this.comment = comment;
        this.userId = userId;
        this.date = date;
        this.forum = forum;
        this.userName = userName;
    }

    public Comments(String comment, String userId, String date, String forum) {
        this.comment = comment;
        this.userId = userId;
        this.date = date;
        this.forum = forum;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
