package com.kai.hw02.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.hw02.R;
import com.kai.hw02.data.DataServices;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    public ArrayList<DataServices.User> mList;

    private final static String GENDER_MALE = "Male";

    public UserListAdapter(ArrayList<DataServices.User> userArrayList ){
        mList = userArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataServices.User user = mList.get( position );
        int profileRes = R.drawable.avatar_female;
        if( user.gender.contains( GENDER_MALE ) )
        {
            profileRes = R.drawable.avatar_male;
        }
        holder.mProfile.setImageResource( profileRes );
        holder.mName.setText( user.name );
        holder.mDesc.setText( user.group );
        holder.mAge.setText( Integer.toString( user.age ) );
        holder.mState.setText( user.state );
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void refreshData(ArrayList<DataServices.User> userArrayList){
        mList = userArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mName;
        private final TextView mState;
        private final TextView mAge;
        private final TextView mDesc;
        private final ImageView mProfile;

        public ViewHolder(View view) {
            super(view);
            mProfile = (ImageView) view.findViewById( R.id.profile_imageView );
            mName = (TextView) view.findViewById(R.id.name_textView);
            mState = (TextView) view.findViewById(R.id.state_textView);
            mAge = (TextView) view.findViewById(R.id.age_textView);
            mDesc = (TextView) view.findViewById(R.id.desc_textView);
        }
    }
}
