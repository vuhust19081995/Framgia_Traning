package com.workspace.retrofitapp.utils;

import com.workspace.retrofitapp.interfaces.AnswerService;

/**
 * Created by workspace on 31/08/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2";

    public static AnswerService getSOService() {
        return RetrofitClient.getRetrofit(BASE_URL).create(AnswerService.class);
    }
}
