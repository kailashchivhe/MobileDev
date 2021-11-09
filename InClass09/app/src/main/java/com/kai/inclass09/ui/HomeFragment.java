package com.kai.inclass09.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.inclass09.R;
import com.kai.inclass09.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding fragmentHomeBinding;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate( inflater, container, false );
        return fragmentHomeBinding.getRoot();
    }
}