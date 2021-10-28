package com.kai.inclass08.ui;

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

import com.kai.inclass08.MainActivity;
import com.kai.inclass08.R;
import com.kai.inclass08.databinding.FragmentNewAccountBinding;
import com.kai.inclass08.firebase.FirebaseHelper;
import com.kai.inclass08.listener.FragmentChangeListener;
import com.kai.inclass08.listener.RegisterListener;


public class NewAccountFragment extends Fragment implements RegisterListener {

    public static final String TAG = "NewAccountFragment";


    FragmentNewAccountBinding fragmentNewAccountBinding;

    public FragmentChangeListener fragmentChangeListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    public NewAccountFragment() {
        // Required empty public constructor
    }

    public static NewAccountFragment newInstance() {
        NewAccountFragment fragment = new NewAccountFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentNewAccountBinding = FragmentNewAccountBinding.inflate( inflater, container, false );
        return fragmentNewAccountBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.create_new_account_title);
        fragmentNewAccountBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.onRegisterCancelClicked();
            }
        });

        fragmentNewAccountBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitClicked();
            }
        });
    }

    private void onSubmitClicked() {
        FirebaseHelper.create( fragmentNewAccountBinding.editTextEmail.getText().toString(), fragmentNewAccountBinding.editTextPassword.getText().toString(), fragmentNewAccountBinding.editTextName.getText().toString(), this );
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

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {
        showFailureMessage( message );
    }
}