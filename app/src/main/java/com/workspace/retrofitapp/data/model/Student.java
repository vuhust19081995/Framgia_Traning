package com.workspace.retrofitapp.data.model;

/**
 * Created by workspace on 05/09/2017.
 */

public class Student {
    private int mId;
    private String mName;
    private String mEmail;

    public Student(int mId, String mName, String mEmail) {
        this.mId = mId;
        this.mName = mName;
        this.mEmail = mEmail;
    }

    public Student(String mName, String mEmail) {
        this.mName = mName;
        this.mEmail = mEmail;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
