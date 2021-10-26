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

import com.kai.inclass08.databinding.FragmentNewAccountBinding;


public class NewAccountFragment extends Fragment {

    public static final String TAG = "NewAccountFragment";


    FragmentNewAccountBinding fragmentNewAccountBinding;

//    public FragmentChangeListener fragmentChangeListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        fragmentChangeListener = (MainActivity) context;
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

//    @Override
//    public void onResume() {
//        super.onResume();
//        getActivity().setTitle(R.string.create_new_account_title);
//        fragmentNewAccountBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragmentChangeListener.onCancelButtonClicked();
//            }
//        });
//
//        fragmentNewAccountBinding.submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NewUser newUser = new NewUser( fragmentNewAccountBinding.editTextEmail.getText().toString(),
//                        fragmentNewAccountBinding.editTextPassword.getText().toString(),
//                        fragmentNewAccountBinding.editTextName.getText().toString() );
//                DataService.createAccount(newUser, new UIListener() {
//                    @Override
//                    public void onLoginFailure(String message) {
//
//                    }
//
//                    @Override
//                    public void onLoginSuccess(User user) {
//
//                    }
//
//                    @Override
//                    public void onCreateFailure(String message) {
//                        showFailureMessage( message );
//                    }
//
//                    @Override
//                    public void onCreateSuccess(User userFromJson) {
//                        onCreateUISuccess( userFromJson );
//                    }
//                });
//            }
//        });
//    }
//
//    private void showFailureMessage(String message) {
//        new Handler( Looper.getMainLooper()).post(() -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
//            builder.setTitle( R.string.failure );
//            builder.setMessage( message );
//            builder.setCancelable( true );
//            builder.show();
//        });
//    }
//
//    private void onCreateUISuccess( User user ){
//        DataService.getPosts(user, 1, new PostUIListener() {
//            @Override
//            public void onPostsSuccess(PostContainer postContainer) {
//                navigateToPosts( postContainer, user );
//            }
//
//            @Override
//            public void onPostFailure(String message) {
//                showFailureMessage( message );
//            }
//
//            @Override
//            public void onDeleteClicked(Post post, User user) {
//
//            }
//
//            @Override
//            public void onPageButtonClicked(int page, User user) {
//
//            }
//
//            @Override
//            public void onDeleteSuccess() {
//
//            }
//
//            @Override
//            public void onCreateSuccess() {
//
//            }
//        });
//    }
//
//    private void navigateToPosts(PostContainer postContainer, User user ){
//        new Handler( Looper.getMainLooper()).post(() -> {
//            fragmentChangeListener.navigateToPostFragment( postContainer, user );
//        });
//    }
}