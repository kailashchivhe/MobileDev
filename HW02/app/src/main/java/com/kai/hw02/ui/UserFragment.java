package com.kai.hw02.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.hw02.R;
import com.kai.hw02.data.DataServices;
import com.kai.hw02.databinding.FragmentUserBinding;

import java.util.ArrayList;

public class UserFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    FragmentUserBinding mFragmentUserBinding;

    ArrayList<DataServices.User> mUserList;

    public static UserFragment newInstance( ArrayList<DataServices.User>  userArrayList ) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, userArrayList);
        fragment.setArguments(args);
        return fragment;
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
        // Inflate the layout for this fragment
        mFragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false);
        return mFragmentUserBinding.getRoot();
    }
}