package com.kai.hw05.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.kai.hw05.R;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.RecyclerListener;
import com.kai.hw05.model.Forum;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private List<Forum> list;

    private FirebaseUser user;

    RecyclerListener recyclerListener;

    public RecyclerViewAdaptor(List<Forum> objectList, FirebaseUser user, RecyclerListener recyclerListener ){
        list = objectList;
        this.user = user;
        this.recyclerListener = recyclerListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable( false );
        Forum forum = list.get( position );
        holder.dateTextView.setText( forum.getDate() );
        holder.headerTextView.setText( forum.getTitle() );
        holder.userTextView.setText( forum.getUserName() );
        holder.descTextView.setText( forum.getSubTitle() );
        holder.likeTextView.setText(forum.getLikes().size() + " Likes | ");
        if( user == null ){
            user = FirebaseHelper.getUser();
        }
        if( forum.getLikes().containsKey( user.getUid() ) ){
            holder.likeView.setImageResource( R.drawable.like_favorite );
        }
        if( forum.getUserId().compareTo( user.getUid() ) == 0 ){
            holder.deleteView.setVisibility( View.VISIBLE );
            holder.deleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerListener.onDeleteClicked( forum );
                }
            });
        }
        holder.likeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerListener.onLikeClicked( forum, forum.getLikes().containsKey( user.getUid() ) );
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerListener.onForumClicked( forum );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(List<Forum> objectList){
        list = objectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView headerTextView;
        private final TextView userTextView;
        private final TextView descTextView;
        private final TextView dateTextView;
        private final TextView likeTextView;
        private final ImageView deleteView;
        private final ImageView likeView;

        public ViewHolder(@NonNull View view) {
            super(view);
            headerTextView = (TextView) view.findViewById(R.id.header_title);
            userTextView = (TextView) view.findViewById(R.id.userName);
            dateTextView = (TextView) view.findViewById(R.id.dateText);
            deleteView = (ImageView) view.findViewById(R.id.imageView);
            likeView = (ImageView) view.findViewById(R.id.imageView2);
            descTextView = (TextView) view.findViewById(R.id.description);
            likeTextView = (TextView) view.findViewById(R.id.likeCountText);
        }
    }
}
