package com.kai.inclass08.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.kai.inclass08.MainActivity;
import com.kai.inclass08.R;
import com.kai.inclass08.databinding.FragmentCreateForumBinding;
import com.kai.inclass08.firebase.FirebaseHelper;
import com.kai.inclass08.listener.CreateListener;
import com.kai.inclass08.listener.FragmentChangeListener;
import com.kai.inclass08.model.Forum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateForumFragment extends Fragment {
    public static final String TAG = "CreateForumFragment";

    FragmentCreateForumBinding fragmentCreateForumBinding;

    public FragmentChangeListener fragmentChangeListener;

    static FirebaseAuth firebaseAuth;

    public CreateForumFragment() {
        // Required empty public constructor
    }

    public static CreateForumFragment newInstance() {
        CreateForumFragment fragment = new CreateForumFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.new_forums);

        fragmentCreateForumBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = fragmentCreateForumBinding.editTextForum.getText().toString();
                String description = fragmentCreateForumBinding.editTextForumDesc.getText().toString();
                if(title.isEmpty() || description.isEmpty()) {
                    // Error
                    showFailureMessage(String.valueOf(R.string.forum_validation_error));
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();

                    Forum forum = new Forum(formatter.format(date), description, title, firebaseAuth.getCurrentUser().getUid(), firebaseAuth.getCurrentUser().getDisplayName());
                    FirebaseHelper.createForum(forum, new CreateListener(){

                        @Override
                        public void onSuccess() {
                            fragmentChangeListener.navigateToForumsFromCreate();
                        }

                        @Override
                        public void onFailure(String message) {
                            showFailureMessage(message);
                        }
                    });
                }
            }
        });

        fragmentCreateForumBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.onRegisterCancelClicked();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCreateForumBinding = FragmentCreateForumBinding.inflate(inflater, container, false);
        return fragmentCreateForumBinding.getRoot();
    }

}