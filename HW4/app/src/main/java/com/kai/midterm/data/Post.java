package com.kai.midterm.data;

import java.io.Serializable;

public class Post implements Serializable {
    public String created_by_name;
    public String post_id;
    public String created_by_uid;
    public String post_text;
    public String created_at;

    @Override
    public String toString() {
        return "Post{" +
                "created_by_name='" + created_by_name + '\'' +
                ", post_id='" + post_id + '\'' +
                ", created_by_uid='" + created_by_uid + '\'' +
                ", post_text='" + post_text + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
