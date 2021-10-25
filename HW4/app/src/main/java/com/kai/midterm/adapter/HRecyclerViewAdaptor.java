package com.kai.midterm.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.midterm.R;
import com.kai.midterm.data.Post;
import com.kai.midterm.data.User;
import com.kai.midterm.listener.PostUIListener;

import java.util.ArrayList;
import java.util.List;

public class HRecyclerViewAdaptor extends RecyclerView.Adapter<HRecyclerViewAdaptor.ViewHolder> {

    private List<Integer> list;

    private User user;

    PostUIListener postUIListener;

    public HRecyclerViewAdaptor(List<Integer> objectList, User user, PostUIListener postUIListener ){
        list = objectList;
        this.user = user;
        this.postUIListener = postUIListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_button_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer number = list.get( position );
        holder.button.setText( Integer.toString( number ) );
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postUIListener.onPageButtonClicked( number, user );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(ArrayList<Integer> pageList) {
        list = pageList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Button button;

        public ViewHolder(@NonNull View view) {
            super(view);
            button = (Button) view.findViewById(R.id.page_button);
        }
    }
}
