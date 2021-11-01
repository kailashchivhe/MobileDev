package com.kai.inclass08.listener;

import com.kai.inclass08.model.Forum;

import java.util.ArrayList;

public interface ForumListListener {
    void onSuccess(ArrayList<Forum> forumList);
    void onFailure( String message );
}
