package com.kai.hw05.listener;

import com.kai.hw05.model.Forum;

import java.util.ArrayList;

public interface ForumListListener {
    void onSuccess(ArrayList<Forum> forumList);
    void onFailure( String message );
}
