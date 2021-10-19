package com.kai.midterm.listener;

import com.kai.midterm.data.PostContainer;

public interface PostUIListener {
    void onPostsSuccess(PostContainer postContainer);
    void onPostFailure(String message);
}
