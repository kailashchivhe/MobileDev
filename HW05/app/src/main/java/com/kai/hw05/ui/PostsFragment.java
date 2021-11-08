package com.kai.hw05.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kai.hw05.R;
import com.kai.hw05.adapter.CommentsRecyclerViewAdaptor;
import com.kai.hw05.databinding.FragmentPostsBinding;
import com.kai.hw05.firebase.FirebaseHelper;
import com.kai.hw05.listener.CommentsListener;
import com.kai.hw05.listener.CommentsRecyclerListener;
import com.kai.hw05.listener.DeleteListener;
import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PostsFragment extends Fragment implements CommentsRecyclerListener, CommentsListener, DeleteListener {

    private static final String ARG_PARAM1 = "forum";

    private Forum forum;

    FragmentPostsBinding fragmentPostsBinding;

    CommentsRecyclerViewAdaptor commentsRecyclerViewAdaptor;

    ArrayList<Comments> commentsArrayList = new ArrayList<>();

    public static PostsFragment newInstance(Forum forum) {
        PostsFragment fragment = new PostsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, forum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            forum = (Forum) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentPostsBinding = FragmentPostsBinding.inflate( inflater, container, false);
        initRecyclerView();
        return fragmentPostsBinding.getRoot();
    }

    private void initRecyclerView() {
        commentsRecyclerViewAdaptor = new CommentsRecyclerViewAdaptor(commentsArrayList, FirebaseHelper.getUser(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentPostsBinding.postsRecyclerView.setLayoutManager( linearLayoutManager );
        fragmentPostsBinding.postsRecyclerView.setAdapter(commentsRecyclerViewAdaptor);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentPostsBinding.postsRecyclerView.getContext(), linearLayoutManager.getOrientation());
        fragmentPostsBinding.postsRecyclerView.addItemDecoration(dividerItemDecoration);

        fragmentPostsBinding.forumTitleTextView.setText( forum.getTitle() );
        fragmentPostsBinding.forumCreatorTextView.setText( forum.getUserName() );
        fragmentPostsBinding.forumDescriptionTextView.setText( forum.getSubTitle() );
    }

    @Override
    public void onResume() {
        super.onResume();
        FirebaseHelper.getAllComments( forum, this );
        fragmentPostsBinding.submitCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                if( !fragmentPostsBinding.commentText.getText().toString().isEmpty() ) {
                    Comments comments = new Comments(fragmentPostsBinding.commentText.getText().toString(), FirebaseHelper.getUser().getUid(), formatter.format(date), forum.getTitle(), FirebaseHelper.getUser().getDisplayName() );
                    FirebaseHelper.addComment(comments);
                }
            }
        });
    }

    @Override
    public void onDeleteClicked(Comments comment) {
        FirebaseHelper.deleteComment( comment, this );
    }

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    public void onSuccess(ArrayList<Comments> commentList) {
        this.commentsArrayList = commentList;
        fragmentPostsBinding.numberOfCommenrsTextView.setText( commentList.size() + " Comments");
        commentsRecyclerViewAdaptor.refreshData( commentList );
        commentsRecyclerViewAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage(message);
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