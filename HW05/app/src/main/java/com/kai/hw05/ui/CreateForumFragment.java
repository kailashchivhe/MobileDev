package com.kai.hw05.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.kai.hw05.MainActivity;
import com.kai.hw05.R;
import com.kai.hw05.databinding.FragmentCreateForumBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.CreateListener;
import com.kai.hw05.model.Forum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateForumFragment extends Fragment {
    public static final String TAG = "CreateForumFragment";

    FragmentCreateForumBinding fragmentCreateForumBinding;

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
                    @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    Forum forum = new Forum( formatter.format(date),description, title, firebaseAuth.getCurrentUser().getUid(), firebaseAuth.getCurrentUser().getDisplayName());
                    FirebaseHelper.createForum(forum, new CreateListener(){

                        @Override
                        public void onSuccess() {
                            Navigation.findNavController( view ).navigate(R.id.action_createForumFragment_to_forumFragment );
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
                Navigation.findNavController( view ).popBackStack();
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