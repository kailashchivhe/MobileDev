package com.kai.midterm.listener;


import com.kai.midterm.data.PostContainer;
import com.kai.midterm.data.User;

public interface FragmentChangeListener {
    void onCreateButtonClicked();
    void onCancelButtonClicked();
    void navigateToPostFragment(PostContainer postContainer, User user);
    void onLogoutClicked();
    void navigateToCreatePosts(User user);
    void afterCreateSuccess(PostContainer postContainer, User user);
}
