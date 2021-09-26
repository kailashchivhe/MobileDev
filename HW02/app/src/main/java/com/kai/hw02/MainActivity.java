package com.kai.hw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.hw02.data.DataServices;
import com.kai.hw02.listener.FragmentChangeListener;
import com.kai.hw02.ui.FilterFragment;
import com.kai.hw02.ui.SortFragment;
import com.kai.hw02.ui.UserFragment;

import java.util.Objects;

/*
* Assignment: Homework 2
* Name: Kailash Chivhe & Ankit Vaity
* Filename: MainActivity
* */
public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager mFragmentManager;
    String mStateFilter = "";
    Boolean mbAgeAsc = false;
    Boolean mbAgeDsc = false;
    Boolean mbNameAsc = false;
    Boolean mbNameDsc = false;
    Boolean mbStateAsc = false;
    Boolean mbStateDsc = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setUserFragment();
    }

    private void setUserFragment(){
        UserFragment userFragment = UserFragment.newInstance(DataServices.getAllUsers());
        mFragmentManager.beginTransaction().add( R.id.container, userFragment, UserFragment.TAG ).commit();
    }

    private void setFilterFragment(){
        FilterFragment filterFragment = FilterFragment.newInstance( DataServices.getUniqueStatesList() );
        mFragmentManager.beginTransaction().replace( R.id.container, filterFragment, FilterFragment.TAG ).addToBackStack( FilterFragment.TAG ).commit();
    }

    private void setSortFragment(){
        SortFragment sortFragment = SortFragment.newInstance( DataServices.getStaticSortList() );
        mFragmentManager.beginTransaction().replace( R.id.container, sortFragment, SortFragment.TAG ).addToBackStack( SortFragment.TAG ).commit();
    }

    @Override
    public void launchFilterFragment() {
        setFilterFragment();
    }

    @Override
    public void launchSortFragment() {
        setSortFragment();
    }

    @Override
    public void goToUserFragmentFromFilter(String stateFilter ) {
        mStateFilter = stateFilter;
        UserFragment userFragment = ( UserFragment) mFragmentManager.findFragmentByTag( UserFragment.TAG );
        if( userFragment != null ){
            userFragment.refreshList( DataServices.getFilteredList(mStateFilter,mbAgeAsc,mbNameAsc,mbStateAsc,mbAgeDsc,mbNameDsc,mbStateDsc) );
        }
        mFragmentManager.popBackStack();
    }

    @Override
    public void onSortClicked(boolean sortAgeAscEnabled, boolean sortNameAscEnabled, boolean sortStateAscEnabled, boolean sortAgeDscEnabled, boolean sortNameDscEnabled, boolean sortStateDscEnabled) {
        mbAgeAsc = sortAgeAscEnabled;
        mbAgeDsc = sortAgeDscEnabled;
        mbNameAsc = sortNameAscEnabled;
        mbNameDsc = sortNameDscEnabled;
        mbStateAsc = sortStateAscEnabled;
        mbStateDsc = sortStateDscEnabled;
        UserFragment userFragment = ( UserFragment) mFragmentManager.findFragmentByTag( UserFragment.TAG );
        if( userFragment != null ){
            userFragment.refreshList( DataServices.getFilteredList(mStateFilter,mbAgeAsc,mbNameAsc,mbStateAsc,mbAgeDsc,mbNameDsc,mbStateDsc) );
        }
        mFragmentManager.popBackStack();
    }

    @Override
    public void setTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle( title );
    }
}