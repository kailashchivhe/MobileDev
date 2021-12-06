package com.kai.inclass10.ui;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.inclass10.R;
import com.kai.inclass10.databinding.FragmentRegisterBinding;
import com.kai.inclass10.listener.RegisterListener;
import com.kai.inclass10.sdk.FirebaseHelper;

public class RegisterFragment extends Fragment implements RegisterListener {

    FragmentRegisterBinding fragmentRegisterBinding;

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentRegisterBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RegisterFragment.this).popBackStack();
            }
        });

        fragmentRegisterBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitClick();
            }
        });
    }

    void onSubmitClick() {
        if( !fragmentRegisterBinding.editTextEmail.getText().toString().isEmpty() && !fragmentRegisterBinding.editTextPassword.getText().toString().isEmpty()) {
            FirebaseHelper.create(fragmentRegisterBinding.editTextEmail.getText().toString(), fragmentRegisterBinding.editTextPassword.getText().toString(), this);
        } else  {
            showFailureMessage(getString(R.string.credentials_invalid));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentRegisterBinding = FragmentRegisterBinding.inflate( inflater, container, false);
        return fragmentRegisterBinding.getRoot();
    }

    @Override
    public void onSuccess() {
        NavHostFragment.findNavController(RegisterFragment.this)
                .navigate(R.id.action_registerFragment_to_HomeFragment);
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage( message );
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