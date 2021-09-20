package com.kai.inclass05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kai.inclass05.R;
import com.kai.inclass05.data.DataServices;

public class AppListsAdapter extends ArrayAdapter<DataServices.App> {

    public AppListsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if( convertView != null )
        {
            convertView = LayoutInflater.from( getContext() ).inflate(R.layout.activity_main, parent, false );
        }
        DataServices.App app = getItem( position );
        //Set Resource data
        return convertView;
    }
}
