package com.kai.inclass09.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.inclass09.R;
import com.kai.inclass09.databinding.FragmentAddCourseBinding;


public class AddCourseFragment extends Fragment {

    FragmentAddCourseBinding fragmentAddCourseBinding;

    public static AddCourseFragment newInstance(String param1, String param2) {
        AddCourseFragment fragment = new AddCourseFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddCourseBinding = FragmentAddCourseBinding.inflate( inflater, container, false );
        return fragmentAddCourseBinding.getRoot();
    }
}