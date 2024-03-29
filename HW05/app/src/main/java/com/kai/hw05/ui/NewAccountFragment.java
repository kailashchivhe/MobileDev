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

import com.kai.hw05.R;
import com.kai.hw05.databinding.FragmentNewAccountBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.RegisterListener;


public class NewAccountFragment extends Fragment implements RegisterListener {

    public static final String TAG = "NewAccountFragment";

    FragmentNewAccountBinding fragmentNewAccountBinding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public static NewAccountFragment newInstance() {
        return new NewAccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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
                Navigation.findNavController( view ).popBackStack();
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
        if( !fragmentNewAccountBinding.editTextEmail.getText().toString().isEmpty() && !fragmentNewAccountBinding.editTextPassword.getText().toString().isEmpty() && !fragmentNewAccountBinding.editTextName.getText().toString().isEmpty() ) {
            FirebaseHelper.create(fragmentNewAccountBinding.editTextEmail.getText().toString(), fragmentNewAccountBinding.editTextPassword.getText().toString(), fragmentNewAccountBinding.editTextName.getText().toString(), this);
        }
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
        NavHostFragment.findNavController( this ).navigate( R.id.action_newAccountFragment_to_forumFragment );
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage( message );
    }
}