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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.kai.hw05.MainActivity;
import com.kai.hw05.R;
import com.kai.hw05.adapter.RecyclerViewAdaptor;
import com.kai.hw05.databinding.FragmentForumBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.DeleteListener;
import com.kai.hw05.listener.ForumListListener;
import com.kai.hw05.listener.FragmentChangeListener;
import com.kai.hw05.listener.RecyclerListener;
import com.kai.hw05.model.Forum;


import java.util.ArrayList;


public class ForumFragment extends Fragment implements ForumListListener, RecyclerListener {
    public static final String TAG = "ForumFragment";

    FragmentForumBinding fragmentForumBinding;

    public FragmentChangeListener fragmentChangeListener;

    ArrayList<Forum> forumList;

    RecyclerViewAdaptor recyclerViewAdaptor;

    static FirebaseAuth firebaseAuth;

    public ForumFragment() {
        // Required empty public constructor
    }


    public static ForumFragment newInstance() {
        ForumFragment fragment = new ForumFragment();
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
        getActivity().setTitle(R.string.forum_title);

        FirebaseHelper.getAllForums(this);

        fragmentForumBinding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.onLogout();
            }
        });

        fragmentForumBinding.createForumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.navigateToCreateForums();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentForumBinding = FragmentForumBinding.inflate(inflater, container, false);

        return fragmentForumBinding.getRoot();
    }

    @Override
    public void onSuccess(ArrayList<Forum> forumList) {
        this.forumList = forumList;
        recyclerViewAdaptor = new RecyclerViewAdaptor(forumList, firebaseAuth.getCurrentUser(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentForumBinding.postRecylerView.setLayoutManager( linearLayoutManager );
        fragmentForumBinding.postRecylerView.setAdapter(recyclerViewAdaptor);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentForumBinding.postRecylerView.getContext(), linearLayoutManager.getOrientation());
        fragmentForumBinding.postRecylerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage(message);
    }

    @Override
    public void onDeleteClicked(Forum forum) {
        FirebaseHelper.deleteForum(forum, new DeleteListener(){

            @Override
            public void onSuccess() {
                refreshData();
            }

            @Override
            public void onFailure(String message) {
                showFailureMessage( message );
            }
        });
    }

    void refreshData(){
        FirebaseHelper.getAllForums(new ForumListListener() {
            @Override
            public void onSuccess(ArrayList<Forum> forumList) {
                recyclerViewAdaptor.refreshData( forumList );
                recyclerViewAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                showFailureMessage( message );
            }
        });
    }
}