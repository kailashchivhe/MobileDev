package com.kai.inclass04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.inclass04.data.DataServices;
import com.kai.inclass04.listener.FragmentReplaceListener;
import com.kai.inclass04.ui.AccountFragment;
import com.kai.inclass04.ui.LoginFragment;
import com.kai.inclass04.ui.RegisterFragment;
import com.kai.inclass04.ui.UpdateFragment;

/*
* Assignment: In Class 04
* File Name: MainActivity
* Student: Kailash Chivhe & Ankit Vaity
* */
public class MainActivity extends AppCompatActivity implements FragmentReplaceListener {

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        setLoginFragment( new LoginFragment() );
    }

    @Override
    public void onLoginSuccess(DataServices.Account account) {
        AccountFragment accountFragment = AccountFragment.newInstance( account );
        setAccountFragment( accountFragment );
    }

    @Override
    public void onCreateClicked() {
        RegisterFragment registerFragment = new RegisterFragment();
        setRegisterFragment( registerFragment );
    }

    @Override
    public void onCancelClicked() {
        mFragmentManager.popBackStack();
    }

    @Override
    public void onSubmitClicked( DataServices.Account account ) {
        AccountFragment accountFragment = AccountFragment.newInstance( account );
        setAccountFragment( accountFragment );
    }

    @Override
    public void onEditClicked( DataServices.Account account ) {
        UpdateFragment updateFragment = (UpdateFragment) mFragmentManager.findFragmentByTag( UpdateFragment.TAG );
        if( updateFragment == null )
        {
            updateFragment = UpdateFragment.newInstance( account );
        }
        setUpdateFragment( updateFragment );
    }

    @Override
    public void onLogoutClicked() {
        LoginFragment loginfragment = (LoginFragment) mFragmentManager.findFragmentByTag( LoginFragment.TAG );
        if( loginfragment == null )
        {
            loginfragment = new LoginFragment();
        }
        setReplaceableLoginFragment( loginfragment );
    }

    @Override
    public void onBackPressed() {
        if( mFragmentManager.getBackStackEntryCount() > 1 )
        {
            mFragmentManager.popBackStack();
        }
        else
        {
            finish();
        }
    }

    private void setLoginFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setReplaceableLoginFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().replace( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setRegisterFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, RegisterFragment.TAG ).addToBackStack( RegisterFragment.TAG ).commit();
    }

    private void setAccountFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().replace( R.id.container, fragment, AccountFragment.TAG ).commit();
    }

    private void setUpdateFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, UpdateFragment.TAG ).addToBackStack( UpdateFragment.TAG ).commit();
    }
}