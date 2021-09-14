package com.kai.inclass04.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.inclass04.MainActivity;
import com.kai.inclass04.R;
import com.kai.inclass04.data.DataServices;
import com.kai.inclass04.databinding.FragmentAccountBinding;
import com.kai.inclass04.listener.FragmentReplaceListener;


public class AccountFragment extends Fragment {
    public static final String TAG = "AccountFragment";
    private static final String ARG_PARAM1 = "param1";

    DataServices.Account mAccount;

    FragmentAccountBinding mFragmentAccountBinding;

    public FragmentReplaceListener mFragmentReplaceListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
        ((MainActivity) context).setTitle( R.string.account );
    }

    public AccountFragment(DataServices.Account account) {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(DataServices.Account account) {
        AccountFragment fragment = new AccountFragment(account);
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, account);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAccount = (DataServices.Account) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);
        mFragmentAccountBinding.userText.setText( mAccount.getName() );
        return mFragmentAccountBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentAccountBinding.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentReplaceListener.onEditClicked( mAccount );
            }
        });

        mFragmentAccountBinding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentReplaceListener.onLogoutClicked();
            }
        });
    }
}