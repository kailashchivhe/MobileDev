package com.kai.inclass08.model;

public class Forum {
    String date;
    String subTitle;
    String title;
    String userId;
    String userName;

    public Forum(String date, String subTitle, String title, String userId, String userName) {
        this.date = date;
        this.subTitle = subTitle;
        this.title = title;
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "date='" + date + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
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
