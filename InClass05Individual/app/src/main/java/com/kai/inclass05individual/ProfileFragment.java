package com.kai.inclass05individual;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.inclass05individual.databinding.FragmentHomeBinding;
import com.kai.inclass05individual.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";

    FragmentChangeListener mFragmentChangeListener;

    FragmentProfileBinding mFragmentProfileBinding;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentChangeListener = (MainActivity) context;
        ((MainActivity) context).setTitle( R.string.profile_form );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentProfileBinding = mFragmentProfileBinding.inflate(inflater, container, false);
        return mFragmentProfileBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentProfileBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = mFragmentProfileBinding.editTextName.getText().toString();
                String lname = mFragmentProfileBinding.editTextLastName.getText().toString();
                String email = mFragmentProfileBinding.editTextEmail.getText().toString();
                int age = Integer.parseInt(mFragmentProfileBinding.editTextAge.getText().toString());
                Profile profile = new Profile( fname, lname, email, age );
                mFragmentChangeListener.onSubmitClicked( profile );
            }
        });
    }
}