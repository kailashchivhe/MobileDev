package com.kai.inclass05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kai.inclass05.R;
import com.kai.inclass05.data.DataServices;

import java.util.ArrayList;

public class AppListsAdapter extends ArrayAdapter<DataServices.App> {

    ArrayList<DataServices.App> mAppList;
    Context mContext;

    public AppListsAdapter(@NonNull Context context, int resource, ArrayList<DataServices.App> list) {
        super(context, resource);
        mContext = context;
        mAppList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if( convertView == null )
        {
            convertView = LayoutInflater.from( mContext ).inflate( R.layout.app_item, parent, false );
        }

        DataServices.App app = mAppList.get( position );
        //Set Resource data
        TextView appName = convertView.findViewById( R.id.appName );
        TextView artistName = convertView.findViewById( R.id.artist );
        TextView release = convertView.findViewById( R.id.releaseDate );

        appName.setText( app.name );
        artistName.setText( app.artistName );
        release.setText( app.releaseDate );

        return convertView;
    }

    @Override
    public int getCount() {
        return mAppList.size();
    }
}
