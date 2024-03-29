package com.kai.hw05.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Forum implements Serializable {
    String date;
    String subTitle;
    String title;
    String userId;
    String userName;
    Map<String,Boolean> likes;

    public Map<String, Boolean> getLikes() {
        return likes;
    }

    public void setLikes(Map<String, Boolean> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "date='" + date + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", likes=" + likes +
                '}';
    }

    public Forum(String date, String subTitle, String title, String userId, String userName, Map<String, Boolean> likes, List<Comments> comments) {
        this.date = date;
        this.subTitle = subTitle;
        this.title = title;
        this.userId = userId;
        this.userName = userName;
        this.likes = likes;
    }

    public Forum(String date, String subTitle, String title, String userId, String userName) {
        this.date = date;
        this.subTitle = subTitle;
        this.title = title;
        this.userId = userId;
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
