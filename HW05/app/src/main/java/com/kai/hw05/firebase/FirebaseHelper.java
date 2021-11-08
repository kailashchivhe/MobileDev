package com.kai.hw05.firebase;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kai.hw05.listener.CommentsListener;
import com.kai.hw05.listener.CreateListener;
import com.kai.hw05.listener.DeleteListener;
import com.kai.hw05.listener.ForumListListener;
import com.kai.hw05.listener.LoginListener;
import com.kai.hw05.listener.RegisterListener;
import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FirebaseHelper {
    static FirebaseAuth firebaseAuth;
    static FirebaseFirestore firebaseFirestore;
    static final String HW05_ROOT_COLLECTION = "NewForums";
    static final String HW05_COMMENTS_COLLECTION = "Comments";

    public static void initFirebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public static FirebaseUser getUser(){
        return firebaseAuth.getCurrentUser();
    }

    public static void create(String email, String password, String name, RegisterListener registerListener ){
        firebaseAuth.createUserWithEmailAndPassword( email, password ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName( name).build();
                task.getResult().getUser().updateProfile(profileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            registerListener.onSuccess();
                        }
                    }
                });
            } else {
                registerListener.onFailure( task.getException().getMessage() );
            }
        });
    }

    public static void login(String email, String password, LoginListener loginListener ){
        firebaseAuth.signInWithEmailAndPassword( email, password ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                loginListener.onSuccess();
            } else {
                loginListener.onFailure( task.getException().getMessage() );
            }
        });
    }

    public static void logout(){
        firebaseAuth.signOut();
    }

    public static void createForum(Forum forum, CreateListener createListener){
        Map<String, Object> forumMap = new HashMap<String, Object>();
        forumMap.put("date", forum.getDate());
        forumMap.put("subTitle", forum.getSubTitle() );
        forumMap.put("title", forum.getTitle() );
        forumMap.put("userId", forum.getUserId() );
        forumMap.put("userName", forum.getUserName() );
        forumMap.put( "likes", new HashMap<String,Boolean>() );
        firebaseFirestore.collection(HW05_ROOT_COLLECTION)
                .add(forumMap)
                .addOnSuccessListener(documentReference -> {
                    createListener.onSuccess();
                })
                .addOnFailureListener(e -> {
                    createListener.onFailure(e.getMessage());
                });
    }

    public static void likeForum( Forum forum, boolean isLiked){
        if( isLiked ){
            //TODO unlike
            firebaseFirestore.collection(HW05_ROOT_COLLECTION).whereEqualTo("date", forum.getDate() ).whereEqualTo("title", forum.getTitle() ).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if( task.isSuccessful() ){
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            HashMap<String,Boolean> map = new HashMap<>();
                            map.put( getUser().getUid(), true );
                            document.getDocumentReference(document.getId()).update( "likes", FieldValue.arrayUnion(map) );
                        }
                    }
                }
            });
        }
        else{
            //TODO add
            firebaseFirestore.collection(HW05_ROOT_COLLECTION).whereEqualTo("date", forum.getDate() ).whereEqualTo("title", forum.getTitle() ).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if( task.isSuccessful() ){
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            HashMap<String,Boolean> map = new HashMap<>();
                            map.put( getUser().getUid(), true );
                            firebaseFirestore.collection(HW05_ROOT_COLLECTION).document(document.getId());
                        }
                    }
                }
            });
        }

    }

    public static void getAllComments(Forum forum, CommentsListener commentsListener){
        ArrayList<Comments> commentsList = new ArrayList<>();
        firebaseFirestore.collection( HW05_COMMENTS_COLLECTION ).whereEqualTo("forum", forum.getTitle() ).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if( e == null && queryDocumentSnapshots != null ){
                commentsList.clear();
                for ( QueryDocumentSnapshot document : queryDocumentSnapshots ) {
                    Comments comments = new Comments( document.get("comment").toString(),
                            document.get("userId").toString(),
                            document.get("date").toString(),
                            document.get("forum").toString() );
                    commentsList.add( comments );
                }
                commentsListener.onSuccess(commentsList);
            }
            else{
                commentsListener.onFailure( e.getMessage() );
            }
        });
    }

    public static void addComment(Comments comments){
        Map<String, Object> commentMap = new HashMap<String, Object>();
        commentMap.put("userId", comments.getUserId());
        commentMap.put("comment", comments.getComment());
        commentMap.put("forum", comments.getForum() );
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        commentMap.put("date", formatter.format( date ) );
        firebaseFirestore.collection(HW05_COMMENTS_COLLECTION)
                .add(commentMap)
                .addOnSuccessListener(documentReference -> {
                })
                .addOnFailureListener(e -> {
                });
    }

    public static void deleteComment(Comments comments ){
        firebaseFirestore.collection(HW05_COMMENTS_COLLECTION).whereEqualTo("userId", comments.getUserId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    if(document.get("comment").equals(comments.getComment())){
                        firebaseFirestore.collection(HW05_ROOT_COLLECTION).document(document.getId()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task1) {
                                if(!task1.isSuccessful()){
                                    //TODO: add failure
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public static void deleteForum(Forum forum, DeleteListener deleteListener ){
        firebaseFirestore.collection(HW05_ROOT_COLLECTION).whereEqualTo("userId", forum.getUserId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    if(document.get("title").equals(forum.getTitle())){
                        firebaseFirestore.collection(HW05_ROOT_COLLECTION).document(document.getId()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task1) {
                                if(!task1.isSuccessful()){
                                    deleteListener.onFailure( task1.getException().getMessage() );
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public static void getAllForums(ForumListListener forumListListener){
        ArrayList<Forum> forumList = new ArrayList<>();
        firebaseFirestore.collection( HW05_ROOT_COLLECTION ).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if( e == null && queryDocumentSnapshots != null ){
                forumList.clear();
                for ( QueryDocumentSnapshot document : queryDocumentSnapshots ) {
                    Forum forum = new Forum( document.get("date").toString(), document.get("subTitle").toString(),
                            document.get("title").toString(),
                            document.get("userId").toString(),
                            document.get("userName").toString());
                    Map<String,Boolean> map = (Map<String, Boolean>) document.get("likes");
                    forum.setLikes( map );
                    forumList.add( forum );
                }
                forumListListener.onSuccess(forumList);
            }
            else{
                forumListListener.onFailure( e.getMessage() );
            }
        });
    }
}
