package com.kai.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.kai.midterm.data.DataService;
import com.kai.midterm.data.Post;
import com.kai.midterm.data.PostContainer;
import com.kai.midterm.data.User;
import com.kai.midterm.listener.FragmentChangeListener;
import com.kai.midterm.listener.PostUIListener;
import com.kai.midterm.ui.CreatePostFragment;
import com.kai.midterm.ui.LoginFragment;
import com.kai.midterm.ui.NewAccountFragment;
import com.kai.midterm.ui.PostsFragment;

import java.util.Objects;

/*
* Group No. 26
* HW 04
* */
public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager fragmentManager;
    public String STATUS;
    public String TOKEN;
    public int ID;
    public String NAME;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        loadDate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDate();
    }

    private void setLoginFragment(Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, LoginFragment.TAG ).commit();
    }

    private void setRegisterFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, NewAccountFragment.TAG ).addToBackStack( NewAccountFragment.TAG ).commit();
    }

    private void setPostFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, PostsFragment.TAG ).addToBackStack( PostsFragment.TAG ).commit();
    }

    private void setCreatePostFragment( Fragment fragment )
    {
        fragmentManager.beginTransaction().replace( R.id.container, fragment, CreatePostFragment.TAG ).addToBackStack( CreatePostFragment.TAG ).commit();
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
        setPostFragment( PostsFragment.newInstance( postContainer) );
    }

    @Override
    public void onLogoutClicked() {
        fragmentManager.popBackStack();
        setLoginFragment( LoginFragment.newInstance() );
    }

    @Override
    public void navigateToCreatePosts(User user) {
        setCreatePostFragment( CreatePostFragment.newInstance( user) );
    }

    @Override
    public void afterCreateSuccess(PostContainer postContainer, User user) {
        PostsFragment postsFragment = (PostsFragment) fragmentManager.findFragmentByTag( PostsFragment.TAG );
        if( postsFragment != null )
        {
            fragmentManager.popBackStack();
            postsFragment.refreshData( postContainer, user );
        }
        else {
            navigateToPostFragment(postContainer, user);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = fragmentManager.findFragmentByTag(PostsFragment.TAG);
        if( fragment != null && fragment.isVisible() ){
            finishAfterTransition();
        }
    }

    public void loadDate() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_key), Context.MODE_PRIVATE);
        STATUS = sharedPreferences.getString(getString(R.string.user_status), "");
        TOKEN = sharedPreferences.getString(getString(R.string.user_token), "");
        ID = sharedPreferences.getInt(getString(R.string.user_id), 0);
        NAME = sharedPreferences.getString(getString(R.string.user_name), "");

        user = new User(STATUS, TOKEN, ID, NAME);

        if (TOKEN.isEmpty()) {
            setLoginFragment( LoginFragment.newInstance() );
        } else {
            DataService.getPosts(user, 1, new PostUIListener() {
                @Override
                public void onPostsSuccess(PostContainer postContainer) {
                    navigateToPostFragment( postContainer, user );
                }

                @Override
                public void onPostFailure(String message) {

                }

                @Override
                public void onDeleteClicked(Post post, User user) {

                }

                @Override
                public void onPageButtonClicked(int page, User user) {

                }

                @Override
                public void onDeleteSuccess() {

                }

                @Override
                public void onCreateSuccess() {

                }
            });
        }
    }
}