package com.kai.inclass08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.inclass08.firebase.FirebaseHelper;
import com.kai.inclass08.listener.FragmentChangeListener;
import com.kai.inclass08.ui.LoginFragment;
import com.kai.inclass08.ui.NewAccountFragment;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseHelper.initFirebase();
        fragmentManager = getSupportFragmentManager();
        setLoginFragment( LoginFragment.newInstance() );
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setLoginFragment(Fragment fragment )
    {
        fragmentManager.beginTransaction().add( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setRegisterFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, NewAccountFragment.TAG ).addToBackStack( NewAccountFragment.TAG ).commit();
    }

    @Override
    public void onRegisterCancelClicked() {
        fragmentManager.popBackStack();
    }

    @Override
    public void navigateToRegisterFragment() {
        setRegisterFragment( NewAccountFragment.newInstance() );
    }

    @Override
    public void navigateToForums() {

    }
}