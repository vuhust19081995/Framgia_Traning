package com.workspace.retrofitapp.interfaces;

import com.workspace.retrofitapp.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by workspace on 31/08/2017.
 */

public interface UserService {
    @GET("/users/follower/followers")
    Call<ArrayList<User>> getUsers();
}
