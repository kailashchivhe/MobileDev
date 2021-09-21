package com.kai.inclass05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.inclass05.data.DataServices;
import com.kai.inclass05.listener.FragmentReplaceListener;
import com.kai.inclass05.ui.AppCategoriesFragment;
import com.kai.inclass05.ui.AppDetailsFragment;
import com.kai.inclass05.ui.CategoryListFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentReplaceListener {

    FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        setCategoryFragment( AppCategoriesFragment.newInstance() );
    }

    private void setCategoryFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, AppCategoriesFragment.TAG ).commit();
    }

    private void setCategoryListFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, CategoryListFragment.TAG ).addToBackStack( CategoryListFragment.TAG).commit();
    }

    private void setAppDetailFragment( Fragment fragment )
    {
        mFragmentManager.beginTransaction().add( R.id.container, fragment, AppDetailsFragment.TAG ).addToBackStack( AppDetailsFragment.TAG).commit();
    }

    @Override
    public void onAppCategoryClick(String category) {
        setCategoryListFragment( CategoryListFragment.newInstance( category) );
    }

    @Override
    public void onCategoryClick(DataServices.App app) {
        setAppDetailFragment( AppDetailsFragment.newInstance( app) );
    }

    @Override
    public void setTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle( title );
    }
}