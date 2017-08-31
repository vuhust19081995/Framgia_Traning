package com.workspace.retrofitapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.workspace.retrofitapp.R;
import com.workspace.retrofitapp.model.Item;

import java.util.List;

/**
 * Created by workspace on 31/08/2017.
 */

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {
    private List<Item> listItem;
    private Context mContext;
    private PostItemListener postItemListener;

    public AnswerAdapter(List<Item> listItem, Context mContext, PostItemListener postItemListener) {
        this.listItem = listItem;
        this.mContext = mContext;
        this.postItemListener = postItemListener;
    }

    @Override
    public AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewPost = layoutInflater.inflate(R.layout.item_answer,parent,false);
        AnswerViewHolder answerViewHolder = new AnswerViewHolder(viewPost);
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(AnswerViewHolder holder, int position) {
        holder.tvAnswerID.setText(listItem.get(position).getAnswerId());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    class AnswerViewHolder extends RecyclerView.ViewHolder{
        private TextView tvAnswerID;
        private PostItemListener mPostItemListener;
        public AnswerViewHolder(View itemView) {
            super(itemView);
            tvAnswerID = (TextView) itemView.findViewById(R.id.tvAnswerID);
        }
    }

    public interface PostItemListener{
        void onPostClick(int idPost);
    }
}
