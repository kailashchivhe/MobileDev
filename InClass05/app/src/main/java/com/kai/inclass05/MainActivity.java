package com.kai.inclass05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kai.inclass05.listener.FragmentReplaceListener;
import com.kai.inclass05.ui.AppCategoriesFragment;

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

    @Override
    public void onAppCategoryClick(String category) {
        //launch next category list fragment.
    }
}