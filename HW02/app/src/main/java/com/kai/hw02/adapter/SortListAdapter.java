package com.kai.hw02.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.hw02.R;
import com.kai.hw02.listener.SortListClickListener;

import java.util.ArrayList;

public class SortListAdapter extends RecyclerView.Adapter<SortListAdapter.ViewHolder> {

    public ArrayList<String> mList;

    public SortListClickListener mSortListListener;

    public SortListAdapter(ArrayList<String> userArrayList, SortListClickListener sortListClickListener ){
        mList = userArrayList;
        mSortListListener = sortListClickListener;
    }

    @NonNull
    @Override
    public SortListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SortListAdapter.ViewHolder holder, int position) {
        String item = mList.get( position );
        holder.mName.setText( item );
        holder.mAscImageView.setOnClickListener(v -> mSortListListener.onAscClick( position ));
        holder.mDscImageView.setOnClickListener(v -> mSortListListener.onDscClick( position ));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mAscImageView;
        ImageView mDscImageView;

        public ViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.sort_textView);
            mAscImageView = (ImageView) view.findViewById( R.id.asc_imageView );
            mDscImageView = (ImageView) view.findViewById( R.id.dsc_imageView );
        }
    }
}
