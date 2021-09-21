package com.kai.inclass05.ui;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.kai.inclass05.MainActivity;
import com.kai.inclass05.R;
import com.kai.inclass05.data.DataServices;
import com.kai.inclass05.databinding.FragmentAppDetailsBinding;
import com.kai.inclass05.listener.FragmentReplaceListener;


public class AppDetailsFragment extends Fragment {

    public static final String TAG = "AppDetailsFragment";
    private static final String ARG_PARAM1 = "param1";

    private DataServices.App mApp;

    FragmentAppDetailsBinding mFragmentAppDetailsBinding;

    public FragmentReplaceListener mFragmentReplaceListener;

    ArrayAdapter<String> mAdapter;

    public AppDetailsFragment() {
        // Required empty public constructor
    }

    public static AppDetailsFragment newInstance(DataServices.App app) {
        AppDetailsFragment fragment = new AppDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, app);
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
            mApp = (DataServices.App) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentAppDetailsBinding = FragmentAppDetailsBinding.inflate( inflater, container, false );
        initListView();
        return mFragmentAppDetailsBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentReplaceListener.setTitle( getString( R.string.app_details) );
    }

    private void initListView() {
        mFragmentAppDetailsBinding.appName.setText( mApp.name );
        mFragmentAppDetailsBinding.artist.setText( mApp.artistName );
        mFragmentAppDetailsBinding.releaseDate.setText( mApp.releaseDate );
        mAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, mApp.genres );
        mFragmentAppDetailsBinding.listView.setAdapter( mAdapter );
        mFragmentAppDetailsBinding.listView.setClickable( false );
    }
}