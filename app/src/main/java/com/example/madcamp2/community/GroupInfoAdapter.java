package com.example.madcamp2.community;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madcamp2.R;
import com.example.madcamp2.community.DTO.User;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class GroupInfoAdapter extends RecyclerView.Adapter<GroupInfoAdapter.GroupViewHolder> {

    Context mContext;
    List<User> userList;

    public GroupInfoAdapter(Context mContext, List<User> mData) {
        this.mContext = mContext;
        this.userList = mData;
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView group_info;
        private ImageView user_img;
        private TextView user_name;
        private TextView user_distance;
        private TextView user_rank;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            group_info = itemView.findViewById(R.id.group_info_item);
            user_img = itemView.findViewById(R.id.user_img);
            user_name = itemView.findViewById(R.id.user_name);
            user_distance = itemView.findViewById(R.id.user_distance);
            user_rank = itemView.findViewById(R.id.user_ranking);
        }
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.group_info_item, parent, false);
        GroupViewHolder viewHolder = new GroupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        User userItem = userList.get(position);

        holder.user_name.setText(userItem.getDisplayName());
        holder.user_rank.setText(Integer.toString(position + 1));
        holder.user_distance.setText(String.format("%.1f", userItem.getUserDistance()) + "m");
    }

    @Override
    public int getItemCount() {
        if (userList == null) return 0;
        else return userList.size();
    }
}
