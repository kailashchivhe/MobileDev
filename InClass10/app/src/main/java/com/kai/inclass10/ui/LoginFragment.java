package com.kai.inclass10.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.kai.inclass10.R;
import com.kai.inclass10.databinding.FragmentLoginBinding;
import com.kai.inclass10.listener.LoginListener;
import com.kai.inclass10.sdk.FirebaseHelper;

public class LoginFragment extends Fragment implements LoginListener {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClicked();
            }
        });

        binding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LoginFragment_to_registerFragment);
            }
        });
    }

    void onLoginClicked(){
        if( !binding.editTextEmail.getText().toString().isEmpty() && !binding.editTextTextPassword.getText().toString().isEmpty() ) {
            FirebaseHelper.login(binding.editTextEmail.getText().toString(), binding.editTextTextPassword.getText().toString(), this);
        } else {
            showFailureMessage(getString(R.string.credentials_invalid));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSuccess() {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LoginFragment_to_HomeFragment);
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage(message);
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
}