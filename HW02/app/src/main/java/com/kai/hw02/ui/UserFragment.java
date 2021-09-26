package com.kai.hw02.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.hw02.MainActivity;
import com.kai.hw02.R;
import com.kai.hw02.adapter.UserListAdapter;
import com.kai.hw02.data.DataServices;
import com.kai.hw02.databinding.FragmentUserBinding;

import java.util.ArrayList;

public class UserFragment extends Fragment {

    public static final String TAG = "UserFragment";
    private static final String ARG_PARAM1 = "param1";

    FragmentUserBinding mFragmentUserBinding;

    ArrayList<DataServices.User> mUserList;

    UserListAdapter mAdapter;

    public static UserFragment newInstance( ArrayList<DataServices.User>  userArrayList ) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, userArrayList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.setTitle( R.string.user_fragment_title );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserList = (ArrayList<DataServices.User>) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false);
        mAdapter = new UserListAdapter(mUserList);
        mFragmentUserBinding.recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()) );
        mFragmentUserBinding.recyclerView.setAdapter(mAdapter);
        return mFragmentUserBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentUserBinding.filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mFragmentUserBinding.sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}