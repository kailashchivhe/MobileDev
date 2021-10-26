package com.kai.inclass08.ui;

import android.annotation.SuppressLint;
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

import com.kai.inclass08.databinding.FragmentPostsBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PostsFragment extends Fragment  {

    public static final String TAG = "PostsFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

//    private PostContainer postContainer;
//    private User user;
    private ArrayList<Integer> pageList = new ArrayList<>();

    FragmentPostsBinding fragmentPostsBinding;

//    public FragmentChangeListener fragmentChangeListener;
//
//    RecyclerViewAdaptor recyclerViewAdaptor;
//
//    HRecyclerViewAdaptor hRecyclerViewAdaptor;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        fragmentChangeListener = (MainActivity) context;
    }

//    public static PostsFragment newInstance(PostContainer postContainer, User user) {
//        PostsFragment fragment = new PostsFragment();
//        Bundle args = new Bundle();
//        args.putSerializable(ARG_PARAM1, postContainer);
//        args.putSerializable(ARG_PARAM2, user);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            postContainer = (PostContainer) getArguments().getSerializable(ARG_PARAM1);
//            user = (User) getArguments().getSerializable(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentPostsBinding = FragmentPostsBinding.inflate( inflater, container, false );
        return fragmentPostsBinding.getRoot();
    }

//    @SuppressLint("SetTextI18n")
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        getActivity().setTitle(R.string.posts_title);
//
//        int pageCount = (int) Math.floor( postContainer.totalCount/postContainer.pageSize );
//        createPageList( pageCount );
//
//        recyclerViewAdaptor = new RecyclerViewAdaptor( postContainer.posts, user, this );
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        fragmentPostsBinding.postRecylerView.setLayoutManager( linearLayoutManager );
//        fragmentPostsBinding.postRecylerView.setAdapter(recyclerViewAdaptor);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentPostsBinding.postRecylerView.getContext(), linearLayoutManager.getOrientation());
//        fragmentPostsBinding.postRecylerView.addItemDecoration(dividerItemDecoration);
//
//        fragmentPostsBinding.userTextView.setText( "Welcome "+ user.user_fullname );
//        fragmentPostsBinding.pageLimitTextView.setText( "Showing Page " + postContainer.page + " out of " + new DecimalFormat("#").format(
//        Math.floor( postContainer.totalCount/postContainer.pageSize ) ) );
//
//        fragmentPostsBinding.createPostButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragmentChangeListener.navigateToCreatePosts(user);
//            }
//        });
//
//        fragmentPostsBinding.logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragmentChangeListener.onLogoutClicked();
//            }
//        });
//    }
//
//    private void createPageList(int pageCount) {
//        for( int i = 1;i<=pageCount;i++){
//            pageList.add( i );
//        }
//        hRecyclerViewAdaptor = new HRecyclerViewAdaptor( pageList, user, this );
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false );
//        fragmentPostsBinding.pageRecyclerView.setLayoutManager( linearLayoutManager );
//        fragmentPostsBinding.pageRecyclerView.setAdapter(hRecyclerViewAdaptor);
//    }
//
//    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
//    @Override
//    public void onPostsSuccess(PostContainer newPostContainer) {
//        new Handler( Looper.getMainLooper()).post(() -> {
//            postContainer = newPostContainer;
//            recyclerViewAdaptor.refreshData( newPostContainer.posts );
//            fragmentPostsBinding.pageLimitTextView.setText( "Showing Page " + newPostContainer.page + " out of " + new DecimalFormat("#").format(
//                    Math.floor( postContainer.totalCount/postContainer.pageSize ) ) );
//            recyclerViewAdaptor.notifyDataSetChanged();
//        });
//    }
//
//    @Override
//    public void onPostFailure(String message) {
//        new Handler( Looper.getMainLooper()).post(() -> {
//            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
//            builder.setTitle( R.string.failure );
//            builder.setMessage( message );
//            builder.setCancelable( true );
//            builder.show();
//        });
//    }
//
//    @Override
//    public void onDeleteClicked(Post post, User user) {
//        DataService.deletePost( user, post.post_id, this );
//    }
//
//    @Override
//    public void onPageButtonClicked(int page, User user) {
//        DataService.getPosts( user, page, this );
//    }
//
//    @Override
//    public void onDeleteSuccess() {
//        DataService.getPosts( user, 1, this );
//    }
//
//    @Override
//    public void onCreateSuccess() {
//
//    }
//
//    public void refreshData(PostContainer postContainer, User user) {
//        this.user = user;
//        onPostsSuccess( postContainer );
//    }
}