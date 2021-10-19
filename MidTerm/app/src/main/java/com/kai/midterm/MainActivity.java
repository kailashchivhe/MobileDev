package com.kai.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.midterm.listener.FragmentChangeListener;
import com.kai.midterm.ui.LoginFragment;
import com.kai.midterm.ui.NewAccountFragment;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setLoginFragment( LoginFragment.newInstance() );
    }

    private void setLoginFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().add( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setRegisterFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, NewAccountFragment.TAG ).addToBackStack( NewAccountFragment.TAG ).commit();
    }


    @Override
    public void onLoginButtonClicked() {
        //TODO: show Posts
    }

    @Override
    public void onCreateButtonClicked() {
        setRegisterFragment( NewAccountFragment.newInstance() );
    }

    @Override
    public void onCancelButtonClicked() {
        fragmentManager.popBackStack();
    }
}