package com.kai.inclass05.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.kai.inclass05.MainActivity;
import com.kai.inclass05.R;
import com.kai.inclass05.adapter.AppListsAdapter;
import com.kai.inclass05.data.DataServices;
import com.kai.inclass05.databinding.FragmentCategoryListBinding;
import com.kai.inclass05.listener.FragmentReplaceListener;

import java.util.ArrayList;

public class CategoryListFragment extends Fragment {

    public static final String TAG = "CategoryListFragment";
    private static final String ARG_PARAM1 = "param1";

    private String mCategoryName;

    FragmentReplaceListener mFragmentReplaceListener;

    FragmentCategoryListBinding mFragmentCategoryListBinding;

    AppListsAdapter mAdapter;

    ArrayList<DataServices.App> mAppList;

    public static CategoryListFragment newInstance(String param1) {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategoryName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentCategoryListBinding = FragmentCategoryListBinding.inflate( inflater, container, false );
        initListView();
        return mFragmentCategoryListBinding.getRoot();
    }

    private void initListView() {
        if( getActivity() != null ) {
            mAppList = DataServices.getAppsByCategory(mCategoryName);
            mAdapter = new AppListsAdapter(getActivity(), R.layout.app_item, mAppList );
            mFragmentCategoryListBinding.listView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            mFragmentCategoryListBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mFragmentReplaceListener.onCategoryClick( mAppList.get( position) );
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentReplaceListener.setTitle( mCategoryName );
    }
}