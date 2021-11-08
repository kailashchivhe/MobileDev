package com.kai.hw05.listener;

import com.kai.hw05.model.Comments;

import java.util.ArrayList;

public interface CommentsListener {
    void onSuccess(ArrayList<Comments> forumList);
    void onFailure( String message );
}
