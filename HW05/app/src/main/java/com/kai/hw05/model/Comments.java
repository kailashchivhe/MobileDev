package com.kai.hw05.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comments {
    String comment;
    String userId;
    String date;
    String forum;

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
