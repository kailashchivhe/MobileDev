package com.kai.hw05.adapter;

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
import com.kai.hw05.listener.CommentsRecyclerListener;
import com.kai.hw05.listener.RecyclerListener;
import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

import java.util.List;

public class CommentsRecyclerViewAdaptor extends RecyclerView.Adapter<CommentsRecyclerViewAdaptor.ViewHolder> {

    private List<Comments> list;

    private FirebaseUser user;

    CommentsRecyclerListener recyclerListener;

    public CommentsRecyclerViewAdaptor(List<Comments> objectList, FirebaseUser user, CommentsRecyclerListener recyclerListener ){
        list = objectList;
        this.user = user;
        this.recyclerListener = recyclerListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_post_item_layout, parent, false);
        return new CommentsRecyclerViewAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable( false );
        Comments comment = list.get( position );

        // Fetch user name using user name
        holder.commentUserNameTextView.setText( comment.getUserName() );
        holder.commentDesctiption.setText( comment.getComment() );
        holder.commentCreationDate.setText( comment.getDate());

        if( user == null ){
            user = FirebaseHelper.getUser();
        }
        if( user != null && comment.getUserId().compareTo( user.getUid() ) == 0 ){
            holder.imageView.setVisibility( View.VISIBLE );
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerListener.onDeleteClicked( comment );
                }
            });
        }
    }

    @Override
    public int getItemCount()  {
        return list.size();
    }

    public void refreshData(List<Comments> objectList){
        list = objectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView commentUserNameTextView;
        private final TextView commentDesctiption;
        private final TextView commentCreationDate;
        private final ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            commentUserNameTextView = (TextView) view.findViewById(R.id.commentUserNameTextView);
            commentDesctiption = (TextView) view.findViewById(R.id.commentDesctiption);
            commentCreationDate = (TextView) view.findViewById(R.id.commentCreationDate);
            imageView = (ImageView) view.findViewById(R.id.postDeleteButton);
        }
    }
}
