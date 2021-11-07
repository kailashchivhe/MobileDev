package com.kai.hw05.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.kai.hw05.MainActivity;
import com.kai.hw05.R;
import com.kai.hw05.databinding.FragmentLoginBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.LoginListener;

public class LoginFragment extends Fragment implements LoginListener {

    public static final String TAG = "LoginFragment";

    FragmentLoginBinding fragmentLoginBinding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
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
                onCreateClicked(view);
            }
        });

        fragmentLoginBinding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClicked();
            }
        });
    }

    private void onCreateClicked(View view ) {
        Navigation.findNavController( view ).navigate( R.id.action_loginFragment_to_newAccountFragment );
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
        NavHostFragment.findNavController( this ).navigate( R.id.action_loginFragment_to_forumFragment );
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