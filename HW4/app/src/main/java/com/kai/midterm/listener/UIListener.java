package com.kai.midterm.listener;


import com.kai.midterm.data.User;

public interface UIListener {
    void onLoginFailure(String message);
    void onLoginSuccess(User user);
    void onCreateFailure(String message);
    void onCreateSuccess(User userFromJson);
}
