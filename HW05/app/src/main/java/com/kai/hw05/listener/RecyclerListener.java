package com.kai.hw05.listener;

import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

public interface RecyclerListener {
    void onDeleteClicked(Forum forum);
    void onLikeClicked(Forum forum, boolean isLiked );
    void onForumClicked( Forum forum );
}
