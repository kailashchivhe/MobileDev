package com.kai.inclass05.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.kai.inclass05.MainActivity;
import com.kai.inclass05.R;
import com.kai.inclass05.data.DataServices;
import com.kai.inclass05.databinding.FragmentAppCategoriesBinding;
import com.kai.inclass05.listener.FragmentReplaceListener;


public class AppCategoriesFragment extends Fragment {

    public static final String TAG = "AppCategoriesFragment";

    FragmentAppCategoriesBinding mFragmentAppCategoriesBinding;
    public FragmentReplaceListener mFragmentReplaceListener;
    ArrayAdapter<String> mAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
    }


    public static AppCategoriesFragment newInstance() {
        return new AppCategoriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentAppCategoriesBinding = FragmentAppCategoriesBinding.inflate( inflater, container, false );
        initListView();
        return mFragmentAppCategoriesBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentReplaceListener.setTitle( getString( R.string.app_categories_title ) );
    }

    private void initListView() {
        mAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, DataServices.getAppCategories() );
        mFragmentAppCategoriesBinding.listView.setAdapter( mAdapter );

        mFragmentAppCategoriesBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFragmentReplaceListener.onAppCategoryClick(mAdapter.getItem(position));
            }
        });
    }
}