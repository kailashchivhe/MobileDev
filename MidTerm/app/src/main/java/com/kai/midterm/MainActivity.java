package com.kai.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.midterm.data.PostContainer;
import com.kai.midterm.data.User;
import com.kai.midterm.listener.FragmentChangeListener;
import com.kai.midterm.ui.LoginFragment;
import com.kai.midterm.ui.NewAccountFragment;
import com.kai.midterm.ui.PostsFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    private void setPostFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, PostsFragment.TAG ).addToBackStack( PostsFragment.TAG ).commit();
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

    @Override
    public void navigateToPostFragment(PostContainer postContainer, User user) {
        setPostFragment( PostsFragment.newInstance( postContainer, user) );
    }

    @Override
    public void onLogoutClicked() {
        fragmentManager.popBackStack();
    }

    @Override
    public void navigateToCreatePosts(User user) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = fragmentManager.findFragmentByTag(PostsFragment.TAG);
        if( fragment != null && fragment.isVisible() ){
            finishAfterTransition();
        }
    }
}