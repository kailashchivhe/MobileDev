package com.kai.midterm.data;

import java.io.Serializable;
import java.util.List;

public class PostContainer implements Serializable {
    public String status;
    public List<Post> posts;
    public String page;
    public int pageSize;
    public int totalCount;
}
