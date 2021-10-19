package com.kai.midterm.listener;

import com.kai.midterm.data.Post;
import com.kai.midterm.data.PostContainer;
import com.kai.midterm.data.User;

public interface PostUIListener {
    void onPostsSuccess(PostContainer postContainer);
    void onPostFailure(String message);
    void onDeleteClicked(Post post, User user);
    void onPageButtonClicked( int page, User user );
    void onDeleteSuccess();
    void onCreateSuccess();
}
