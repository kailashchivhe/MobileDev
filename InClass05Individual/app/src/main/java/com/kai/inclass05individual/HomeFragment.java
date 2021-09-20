package com.kai.inclass05individual;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";

    private static final String ARG_PARAM1 = "param1";

    private Profile mProfile;

    com.kai.inclass05individual.databinding.FragmentHomeBinding mFragmentHomeBinding;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(Profile param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProfile = (Profile) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentHomeBinding = mFragmentHomeBinding.inflate(inflater, container, false);
        mFragmentHomeBinding.textViewProfileName.setText( mProfile.mName );
        mFragmentHomeBinding.textViewProfileEmail.setText( mProfile.mEmail );
        mFragmentHomeBinding.textViewAge.setText( ""+mProfile.mAge );
        mFragmentHomeBinding.textViewLastName.setText( mProfile.mLastName );
        return mFragmentHomeBinding.getRoot();
    }
}