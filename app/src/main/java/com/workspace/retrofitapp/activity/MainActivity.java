package com.workspace.retrofitapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.workspace.retrofitapp.R;
import com.workspace.retrofitapp.adapter.UserAdapter;
import com.workspace.retrofitapp.interfaces.UserService;
import com.workspace.retrofitapp.model.User;
import com.workspace.retrofitapp.utils.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewAnswer;
    private UserService userService;
    private LinearLayoutManager linearLayoutManager;
    private UserAdapter userAdapter;
    private ArrayList<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewAnswer = (RecyclerView) findViewById(R.id.recyclerViewAnswer);
        userService = ApiUtils.getAnswerService();
        listUser = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL,false);
        recyclerViewAnswer.setLayoutManager(linearLayoutManager);
        recyclerViewAnswer.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewAnswer.addItemDecoration(itemDecoration);

        userAdapter = new UserAdapter(listUser,this, new UserAdapter.PostItemListener() {

            @Override
            public void onPostClick(int idPost) {
                Toast.makeText(MainActivity.this, "Post id is" + idPost, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewAnswer.setAdapter(userAdapter);
        loadAnswers();
        Log.e("", "onCreate: " + listUser.size());
    }

    public void loadAnswers() {
        userService.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if(response.isSuccessful()){
                    listUser = response.body();
                    userAdapter.updateAnswers(listUser);
                    Log.e("", "onResponse: " + listUser.size());
                }else{
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error loading from API", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
