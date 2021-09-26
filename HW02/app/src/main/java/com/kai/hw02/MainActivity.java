package com.kai.hw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.hw02.data.DataServices;
import com.kai.hw02.ui.UserFragment;

/*
* Assignment: Homework 2
* Name: Kailash Chivhe & Ankit Vaity
* Filename: MainAcitivity
* */
public class MainActivity extends AppCompatActivity {
    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setUserFragment();
    }

    private void setUserFragment(){
        UserFragment userFragment = UserFragment.newInstance(DataServices.getAllUsers());
        mFragmentManager.beginTransaction().add( R.id.container, userFragment, UserFragment.TAG ).commit();
    }
}