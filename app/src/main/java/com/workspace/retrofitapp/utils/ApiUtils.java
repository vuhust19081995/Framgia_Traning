package com.workspace.retrofitapp.utils;

import com.workspace.retrofitapp.interfaces.UserService;

/**
 * Created by workspace on 31/08/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.github.com";

    public static UserService getAnswerService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(UserService.class);
    }
}
