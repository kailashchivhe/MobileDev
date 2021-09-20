package com.kai.inclass05individual;

import java.io.Serializable;

public class Profile implements Serializable {
    String mName;
    String mLastName;
    String mEmail;
    int mAge;

    public Profile(String mName, String mLastName, String mEmail, int mAge) {
        this.mName = mName;
        this.mLastName = mLastName;
        this.mEmail = mEmail;
        this.mAge = mAge;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }
}
