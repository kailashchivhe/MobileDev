package com.kai.inclass10.adaptor;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseUser;
import com.kai.inclass10.R;
import com.kai.inclass10.listener.RecyclerListener;
import com.kai.inclass10.model.Route;

import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private List<Route> list;

    RecyclerListener recyclerListener;

    public RecyclerViewAdaptor(List<Route> objectList, RecyclerListener recyclerListener ){
        list = objectList;
        this.recyclerListener = recyclerListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jog_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable( false );
        Route route = list.get( position );
        holder.headerTextView.setText( "Jog "+ (position + 1) );
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerListener.OnClick(route);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(List<Route> objectList){
        list = objectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView headerTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            headerTextView = (TextView) view.findViewById(R.id.textView);
        }
    }
}