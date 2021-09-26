package com.kai.hw02.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.kai.hw02.MainActivity;
import com.kai.hw02.R;
import com.kai.hw02.databinding.FragmentFilterBinding;
import com.kai.hw02.listener.FragmentChangeListener;

import java.util.ArrayList;

public class FilterFragment extends Fragment {

    public static final String TAG = "FilterFragment";
    private static final String ARG_PARAM1 = "param1";

    private ArrayList<String> mStateList;

    FragmentFilterBinding mFragmentFilterBinding;

    ArrayAdapter<String> mAdapter;

    FragmentChangeListener mFragmentChangeListener;

    public static FilterFragment newInstance(ArrayList<String> list) {
        FilterFragment fragment = new FilterFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentChangeListener = ( FragmentChangeListener ) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mStateList = ( ArrayList<String> ) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentFilterBinding = FragmentFilterBinding.inflate( inflater, container, false );
        mAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, mStateList );
        mFragmentFilterBinding.listView.setAdapter( mAdapter );
        return mFragmentFilterBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentChangeListener.setTitle( getString( R.string.filter_fragment_title ) );
        mFragmentFilterBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFragmentChangeListener.goToUserFragmentFromFilter(mStateList.get(position));
            }
        });
    }
}