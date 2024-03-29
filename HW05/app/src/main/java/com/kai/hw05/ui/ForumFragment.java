package com.kai.hw05.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.kai.hw05.R;
import com.kai.hw05.adapter.RecyclerViewAdaptor;
import com.kai.hw05.databinding.FragmentForumBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.DeleteListener;
import com.kai.hw05.listener.ForumListListener;
import com.kai.hw05.listener.RecyclerListener;
import com.kai.hw05.model.Forum;


import java.util.ArrayList;


public class ForumFragment extends Fragment implements ForumListListener, RecyclerListener, DeleteListener {
    public static final String TAG = "ForumFragment";

    FragmentForumBinding fragmentForumBinding;

    ArrayList<Forum> forumList = new ArrayList<>();

    RecyclerViewAdaptor recyclerViewAdaptor;

    static FirebaseAuth firebaseAuth;

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
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.forum_title);

        FirebaseHelper.getAllForums(this);

        fragmentForumBinding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseHelper.logout();
                Navigation.findNavController( view).popBackStack();
            }
        });

        fragmentForumBinding.createForumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController( view ).navigate( R.id.action_forumFragment_to_createForumFragment );
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentForumBinding = FragmentForumBinding.inflate(inflater, container, false);
        initRecyclerView();
        return fragmentForumBinding.getRoot();
    }

    private void initRecyclerView() {
        recyclerViewAdaptor = new RecyclerViewAdaptor(forumList, firebaseAuth.getCurrentUser(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentForumBinding.postRecylerView.setLayoutManager( linearLayoutManager );
        fragmentForumBinding.postRecylerView.setAdapter(recyclerViewAdaptor);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentForumBinding.postRecylerView.getContext(), linearLayoutManager.getOrientation());
        fragmentForumBinding.postRecylerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onSuccess(ArrayList<Forum> forumList) {
        this.forumList = forumList;
        recyclerViewAdaptor.refreshData( forumList );
        recyclerViewAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage(message);
    }

    @Override
    public void onDeleteClicked(Forum forum) {
        FirebaseHelper.deleteForum(forum, this );
    }

    @Override
    public void onLikeClicked(Forum forum, boolean isLiked) {
        FirebaseHelper.likeForum( forum, isLiked );
    }

    @Override
    public void onForumClicked(Forum forum) {
        Bundle bundle = new Bundle();
        bundle.putSerializable( "forum", forum );
        NavHostFragment.findNavController( this ).navigate( R.id.action_forumFragment_to_postsFragment, bundle );
    }
}