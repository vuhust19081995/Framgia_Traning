package com.workspace.retrofitapp.interfaces;

import com.workspace.retrofitapp.model.AnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by workspace on 31/08/2017.
 */

public interface AnswerService {
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<AnswersResponse>> getAnswers();
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<AnswersResponse>> getAnswers(@Query("tagged") String tags);
}
