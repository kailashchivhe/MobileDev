package com.kai.inclass04.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kai.inclass04.MainActivity;
import com.kai.inclass04.R;
import com.kai.inclass04.data.DataServices;
import com.kai.inclass04.databinding.FragmentLoginBinding;
import com.kai.inclass04.listener.FragmentReplaceListener;

public class LoginFragment extends Fragment {

    public static final String TAG = "LoginFragment";

    private FragmentLoginBinding mFragmentLoginBinding;
    public FragmentReplaceListener mFragmentReplaceListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
        ((MainActivity) context).setTitle( R.string.login_title );
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return mFragmentLoginBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentLoginBinding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentReplaceListener.onCreateClicked();
            }
        });

        mFragmentLoginBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !mFragmentLoginBinding.editTextEmail.getText().toString().isEmpty() && !mFragmentLoginBinding.editTextTextPassword.getText().toString().isEmpty() ) {
                    DataServices.AccountRequestTask accountRequestTask = DataServices.login(mFragmentLoginBinding.editTextEmail.getText().toString(), mFragmentLoginBinding.editTextTextPassword.getText().toString());
                    if (accountRequestTask.isSuccessful()) {
                        mFragmentReplaceListener.onLoginSuccess( accountRequestTask.getAccount() );
                    } else {
                        Toast.makeText( getContext(), accountRequestTask.getErrorMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
                else
                {
                    Toast.makeText( getContext(), R.string.empty_data, Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}