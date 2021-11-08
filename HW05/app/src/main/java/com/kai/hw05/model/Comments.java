package com.kai.hw05.model;

public class Comments {
    String comment;
    String userId;

    public Comments(String comment, String userId) {
        this.comment = comment;
        this.userId = userId;
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
