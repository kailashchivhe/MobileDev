package com.kai.midterm.data;

import java.io.Serializable;

public class User implements Serializable {
    public String status;
    public String token;
    public int user_id;
    public String user_fullname;

    public User(String status, String token, int user_id, String user_fullname) {
        this.status = status;
        this.token = token;
        this.user_id = user_id;
        this.user_fullname = user_fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", user_id=" + user_id +
                ", user_fullname='" + user_fullname + '\'' +
                '}';
    }
}
