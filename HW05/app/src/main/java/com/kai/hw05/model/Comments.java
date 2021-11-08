package com.kai.hw05.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comments {
    String comment;
    String userId;
    String date;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Comments(String comment, String userId) {
        this.comment = comment;
        this.userId = userId;
        this.date = dtf.format(LocalDateTime.now());
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

    @Override
    public String toString() {
        return "Comments{" +
                "comment='" + comment + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
