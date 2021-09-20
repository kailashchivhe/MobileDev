package com.kai.inclass05individual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener{

    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setProfileFragment( ProfileFragment.newInstance() );
    }

    void setProfileFragment(Fragment fragment){
        mFragmentManager.beginTransaction().add( R.id.container, fragment, ProfileFragment.TAG ).commit();
    }

    void setHomeFragment(Fragment fragment){
        mFragmentManager.beginTransaction().add( R.id.container, fragment, HomeFragment.TAG ).addToBackStack(HomeFragment.TAG).commit();
    }

    @Override
    public void onSubmitClicked(Profile profile) {
        setHomeFragment( HomeFragment.newInstance(profile) );
    }
}