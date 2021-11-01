package com.kai.inclass08.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kai.inclass08.MainActivity;
import com.kai.inclass08.R;
import com.kai.inclass08.databinding.FragmentLoginBinding;
import com.kai.inclass08.firebase.FirebaseHelper;
import com.kai.inclass08.listener.FragmentChangeListener;
import com.kai.inclass08.listener.LoginListener;

public class LoginFragment extends Fragment implements LoginListener {

    public static final String TAG = "LoginFragment";

    FragmentLoginBinding fragmentLoginBinding;

    public FragmentChangeListener fragmentChangeListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return fragmentLoginBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.login_title);
        fragmentLoginBinding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateClicked();
            }
        });

        fragmentLoginBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClicked();
            }
        });
    }

    private void onCreateClicked() {
        fragmentChangeListener.navigateToRegisterFragment();
    }

    private void showFailureMessage(String message) {
        new Handler( Looper.getMainLooper()).post(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
            builder.setTitle( R.string.failure );
            builder.setMessage( message );
            builder.setCancelable( true );
            builder.show();
        });
    }

    void onLoginClicked(){
        if( !fragmentLoginBinding.editTextEmail.getText().toString().isEmpty() && !fragmentLoginBinding.editTextTextPassword.getText().toString().isEmpty() ) {
            FirebaseHelper.login(fragmentLoginBinding.editTextEmail.getText().toString(), fragmentLoginBinding.editTextTextPassword.getText().toString(), this);
        }
    }

    @Override
    public void onSuccess() {
        fragmentChangeListener.navigateToForums();
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage( message );
    }

    public void clearData() {
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                if(isVisible()) {
                    fragmentLoginBinding.editTextEmail.setText("");
                    fragmentLoginBinding.editTextTextPassword.setText("");
                }
            }
        }, 2000 );
    }
}