package com.kai.hw05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.FragmentChangeListener;
import com.kai.hw05.ui.CreateForumFragment;
import com.kai.hw05.ui.ForumFragment;
import com.kai.hw05.ui.LoginFragment;
import com.kai.hw05.ui.NewAccountFragment;

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
        fragmentManager.beginTransaction().replace( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setRegisterFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, NewAccountFragment.TAG ).addToBackStack( NewAccountFragment.TAG ).commit();
    }

    private void setForumFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, ForumFragment.TAG ).addToBackStack( ForumFragment.TAG ).commit();
    }

    private void setCreateFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, CreateForumFragment.TAG ).addToBackStack( CreateForumFragment.TAG ).commit();
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
        ForumFragment fragment = ForumFragment.newInstance();
        setForumFragment(fragment);
    }

    @Override
    public void navigateToForumsFromRegister() {
        fragmentManager.popBackStack();
        ForumFragment fragment = ForumFragment.newInstance();
        setForumFragment(fragment);
    }

    @Override
    public void navigateToForumsFromCreate() {
        fragmentManager.popBackStack();
    }

    @Override
    public void navigateToCreateForums() {
        CreateForumFragment fragment = CreateForumFragment.newInstance();
        setCreateFragment(fragment);
    }

    @Override
    public void onLogout() {
        fragmentManager.popBackStack();
        FirebaseHelper.logout();
        LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentByTag( LoginFragment.TAG );
        if( loginFragment != null ){
            loginFragment.clearData();
        }
    }
}