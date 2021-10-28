package com.kai.inclass08.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kai.inclass08.listener.LoginListener;
import com.kai.inclass08.listener.RegisterListener;
import com.kai.inclass08.model.Forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseHelper {
    static FirebaseAuth firebaseAuth;
    static FirebaseFirestore firebaseFirestore;

    public static void initFirebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public static FirebaseUser getUser(){
        return firebaseAuth.getCurrentUser();
    }

    public static String getCurrentUserId(){
        return firebaseAuth.getCurrentUser().getUid();
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

    public static void createForum(Forum forum){
        Map<String, String> forumMap = new HashMap<String, String>();
        forumMap.put("date", forum.getDate() );
        forumMap.put("subTitle", forum.getSubTitle() );
        forumMap.put("title", forum.getTitle() );
        forumMap.put("userId", forum.getUserId() );
        forumMap.put("userName", forum.getUserName() );
        firebaseFirestore.collection("Forums")
                .add(forumMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }

    public static void deleteForum(Forum forum){
        firebaseFirestore.collection("Forums").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot documentSnapshot : task.getResult().getDocuments()){
                    if(documentSnapshot.get("userId").equals(forum.getUserId()) && documentSnapshot.get("title").equals(forum.getTitle())){
//                        task.getResult().getDocuments().remove( documentSnapshot.getId() );
                    }
                }
            }
        });
    }

    public static void getAllForums(){
        ArrayList<Forum> forumList = new ArrayList<>();
        firebaseFirestore.collection("Forums" ).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        Forum forum = new Forum( document.get("date").toString(), document.get("subTitle").toString(),
//                                document.get("title").toString(),
//                                document.get("userId").toString(),
//                                document.get("userName").toString() );
//                        forumList.add(forum);
                    }
                } else {

                }
            }
        });
    }
}
