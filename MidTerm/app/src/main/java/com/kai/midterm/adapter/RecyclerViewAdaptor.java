package com.kai.midterm.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.midterm.R;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    private ArrayList<Object> list;

    public RecyclerViewAdaptor(ArrayList<Object> objectList){
        list = objectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Object object = list.get( position );
//        holder.dateTextView.setText( forecast.dt_txt );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(ArrayList<Object> objectList){
        list = objectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView dateTextView;
//        private final TextView temperatureTextView;
//        private final TextView maxTemp;
//        private final ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
//            dateTextView = (TextView) view.findViewById(R.id.dateTimeListTextView);
//            temperatureTextView = (TextView) view.findViewById(R.id.temperatureListTextView);
//            maxTemp = (TextView) view.findViewById(R.id.maxTempListTextView);
//            imageView = (ImageView) view.findViewById(R.id.forecast_Image);
        }
    }
}
