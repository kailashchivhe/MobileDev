package com.kai.inclass03;

import java.io.Serializable;

public class Profile implements Serializable {
    String mName;
    String mId;
    String mEmail;
    String mDept;

    public Profile(String mName, String mId, String mEmail, String mDept) {
        this.mName = mName;
        this.mId = mId;
        this.mEmail = mEmail;
        this.mDept = mDept;
    }
}
