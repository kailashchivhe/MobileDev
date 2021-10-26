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

import com.kai.inclass08.R;
import com.kai.inclass08.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    public static final String TAG = "LoginFragment";

    FragmentLoginBinding fragmentLoginBinding;
//
//    public FragmentChangeListener fragmentChangeListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        fragmentChangeListener = (MainActivity) context;
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
//        fragmentLoginBinding.createButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragmentChangeListener.onCreateButtonClicked();
//            }
//        });
//
//        fragmentLoginBinding.loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Login login = new Login( fragmentLoginBinding.editTextEmail.getText().toString(), fragmentLoginBinding.editTextTextPassword.getText().toString() );
//                DataService.login(login, new UIListener() {
//                    @Override
//                    public void onLoginFailure(String message) {
//                        showFailureMessage( message );
//                    }
//
//                    @Override
//                    public void onLoginSuccess(User user) {
//                        onLoginUISuccess( user );
//                    }
//
//                    @Override
//                    public void onCreateFailure(String message) {
//
//                    }
//
//                    @Override
//                    public void onCreateSuccess(User userFromJson) {
//
//                    }
//                });
//            }
//        });
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

//    private void onLoginUISuccess( User user ){
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