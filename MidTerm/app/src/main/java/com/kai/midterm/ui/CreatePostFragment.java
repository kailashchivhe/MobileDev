package com.kai.midterm.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.midterm.MainActivity;
import com.kai.midterm.R;
import com.kai.midterm.data.DataService;
import com.kai.midterm.data.Post;
import com.kai.midterm.data.PostContainer;
import com.kai.midterm.data.User;
import com.kai.midterm.databinding.FragmentCreatePostBinding;
import com.kai.midterm.listener.FragmentChangeListener;
import com.kai.midterm.listener.PostUIListener;

public class CreatePostFragment extends Fragment {

    public static final String TAG = "CreatePostFragment";
    private static final String ARG_PARAM1 = "param1";

    private User user;

    FragmentCreatePostBinding fragmentCreatePostBinding;

    public FragmentChangeListener fragmentChangeListener;

    public CreatePostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    public static CreatePostFragment newInstance(User user) {
        CreatePostFragment fragment = new CreatePostFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCreatePostBinding = FragmentCreatePostBinding.inflate( inflater, container, false );
        fragmentCreatePostBinding.getRoot().setFocusableInTouchMode(true);
        fragmentCreatePostBinding.getRoot().requestFocus();
        fragmentCreatePostBinding.getRoot().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {

                        return true;
                    }
                }
                return false;
            }
        });
        return fragmentCreatePostBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.create_posts_title);
        fragmentCreatePostBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataService.createPost(user, fragmentCreatePostBinding.editTextPost.getText().toString(), new PostUIListener() {
                    @Override
                    public void onPostsSuccess(PostContainer postContainer) {

                    }

                    @Override
                    public void onPostFailure(String message) {
                        new Handler( Looper.getMainLooper()).post(() -> {
                            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
                            builder.setTitle( R.string.failure );
                            builder.setMessage( message );
                            builder.setCancelable( true );
                            builder.show();
                        });
                    }

                    @Override
                    public void onDeleteClicked(Post post, User user) {

                    }

                    @Override
                    public void onPageButtonClicked(int page, User user) {

                    }

                    @Override
                    public void onDeleteSuccess() {

                    }

                    @Override
                    public void onCreateSuccess() {
                        DataService.getPosts(user, 1, new PostUIListener() {
                            @Override
                            public void onPostsSuccess(PostContainer postContainer) {
                                new Handler( Looper.getMainLooper()).post(() -> {
                                    fragmentChangeListener.afterCreateSuccess(postContainer, user);
                                });
                            }

                            @Override
                            public void onPostFailure(String message) {

                            }

                            @Override
                            public void onDeleteClicked(Post post, User user) {

                            }

                            @Override
                            public void onPageButtonClicked(int page, User user) {

                            }

                            @Override
                            public void onDeleteSuccess() {

                            }

                            @Override
                            public void onCreateSuccess() {

                            }
                        });
                    }
                });
            }
        });

        fragmentCreatePostBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.onCancelButtonClicked();
            }
        });
    }
}