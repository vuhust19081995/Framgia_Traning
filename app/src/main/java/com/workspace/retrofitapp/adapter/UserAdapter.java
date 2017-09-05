package com.workspace.retrofitapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.workspace.retrofitapp.R;
import com.workspace.retrofitapp.data.model.User;

import java.util.ArrayList;

/**
 * Created by workspace on 31/08/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.AnswerViewHolder> {
    private ArrayList<User> listUser;
    private Context mContext;
    private PostItemListener postItemListener;

    public UserAdapter(ArrayList<User> listUser, Context mContext, PostItemListener postItemListener) {
        this.listUser = listUser;
        this.mContext = mContext;
        this.postItemListener = postItemListener;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewPost = layoutInflater.inflate(R.layout.item_user,parent,false);
        AnswerViewHolder answerViewHolder = new AnswerViewHolder(viewPost,this.postItemListener);
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        holder.tvUserID.setText(String.valueOf(listUser.get(position).getUserID()));
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class AnswerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tvUserID;
        private PostItemListener mPostItemListener;
        public AnswerViewHolder(View itemView,PostItemListener postItemListener) {
            super(itemView);
            tvUserID = (TextView) itemView.findViewById(R.id.tvUserID);
            this.mPostItemListener = postItemListener;
            tvUserID.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User userItem = getUser(getAdapterPosition());
            this.mPostItemListener.onPostClick(userItem.getUserID());
            notifyDataSetChanged();
        }
    }

    public void updateAnswers(ArrayList<User> listUser) {
        this.listUser = listUser;
        notifyDataSetChanged();
    }


    public User getUser(int adapterPosition){
        return listUser.get(adapterPosition);
    }

    public interface PostItemListener{
        void onPostClick(int idPost);
    }
}
