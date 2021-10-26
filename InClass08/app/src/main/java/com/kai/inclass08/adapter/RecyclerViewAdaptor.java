package com.kai.inclass08.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.kai.inclass08.R;

import java.util.List;

//public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

//    private List<Post> list;
//
//    private User user;
//
//    PostUIListener postUIListener;
//
//    public RecyclerViewAdaptor(List<Post> objectList, User user, PostUIListener postUIListener ){
//        list = objectList;
//        this.user = user;
//        this.postUIListener = postUIListener;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item_layout, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Post post = list.get( position );
//        holder.dateTextView.setText( post.created_at );
//        holder.headerTextView.setText( post.post_text );
//        holder.userTextView.setText( post.created_by_name );
//        if( post.created_by_uid.compareTo( Integer.toString(user.user_id) ) == 0 ){
//            holder.imageView.setVisibility( View.VISIBLE );
//            holder.imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    postUIListener.onDeleteClicked( post, user );
//                }
//            });
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public void refreshData(List<Post> objectList){
//        list = objectList;
//    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView headerTextView;
//        private final TextView userTextView;
//        private final TextView dateTextView;
//        private final ImageView imageView;
//
//        public ViewHolder(@NonNull View view) {
//            super(view);
//            headerTextView = (TextView) view.findViewById(R.id.header_title);
//            userTextView = (TextView) view.findViewById(R.id.userName);
//            dateTextView = (TextView) view.findViewById(R.id.dateText);
//            imageView = (ImageView) view.findViewById(R.id.deletePost);
//        }
//    }
//}
