package com.kai.hw02.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.hw02.R;
import com.kai.hw02.adapter.SortListAdapter;
import com.kai.hw02.databinding.FragmentSortBinding;
import com.kai.hw02.listener.FragmentChangeListener;
import com.kai.hw02.listener.SortListClickListener;

import java.util.ArrayList;


public class SortFragment extends Fragment implements SortListClickListener {

    public static final String TAG = "SortFragment";
    private static final String ARG_PARAM1 = "param1";

    private ArrayList<String> mSortList;

    private FragmentSortBinding mFragmentSortBinding;

    private SortListAdapter mSortListAdapter;

    private FragmentChangeListener mFragmentChangeListener;

    public static SortFragment newInstance(ArrayList<String> list) {
        SortFragment fragment = new SortFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSortList = (ArrayList<String>) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentChangeListener = ( FragmentChangeListener ) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentSortBinding = FragmentSortBinding.inflate( inflater, container, false );
        mSortListAdapter = new SortListAdapter(mSortList, this );
        mFragmentSortBinding.recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()) );
        mFragmentSortBinding.recyclerView.setAdapter(mSortListAdapter);
        return mFragmentSortBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentChangeListener.setTitle( getString( R.string.sort ));
    }

    @Override
    public void onAscClick(int position) {
        switch (position){
            case 0:{
                mFragmentChangeListener.onSortClicked( true, false, false, false, false, false );
                break;
            }
            case 1:{
                mFragmentChangeListener.onSortClicked( false, true, false, false, false, false );
                break;
            }
            case 2:{
                mFragmentChangeListener.onSortClicked( false, false, true, false, false, false );
                break;
            }
        }
    }

    @Override
    public void onDscClick(int position) {
        switch (position){
            case 0:{
                mFragmentChangeListener.onSortClicked( false, false, false, true, false, false );
                break;
            }
            case 1:{
                mFragmentChangeListener.onSortClicked( false, false, false, false, true, false );
                break;
            }
            case 2:{
                mFragmentChangeListener.onSortClicked( false, false, false, false, false, true );
                break;
            }
        }
    }
}