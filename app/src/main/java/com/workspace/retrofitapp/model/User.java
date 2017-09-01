package com.workspace.retrofitapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by workspace on 01/09/2017.
 */

public class User {
    @SerializedName("id")
    @Expose
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
