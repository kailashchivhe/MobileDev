package com.kai.hw05.listener;

import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

public interface CommentsRecyclerListener {
    void onDeleteClicked(Comments comment);
}