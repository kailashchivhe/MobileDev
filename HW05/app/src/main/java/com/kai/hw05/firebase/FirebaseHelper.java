package com.kai.hw05.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.kai.hw05.listener.CreateListener;
import com.kai.hw05.listener.DeleteListener;
import com.kai.hw05.listener.ForumListListener;
import com.kai.hw05.listener.LoginListener;
import com.kai.hw05.listener.RegisterListener;
import com.kai.hw05.model.Comments;
import com.kai.hw05.model.Forum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseHelper {
    static FirebaseAuth firebaseAuth;
    static FirebaseFirestore firebaseFirestore;
    static final String HW05_ROOT_COLLECTION = "NewForums";

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
        forumMap.put("date", FieldValue.serverTimestamp() );
        forumMap.put("subTitle", forum.getSubTitle() );
        forumMap.put("title", forum.getTitle() );
        forumMap.put("userId", forum.getUserId() );
        forumMap.put("userName", forum.getUserName() );
        forumMap.put( "likes", new HashMap<String,Boolean>() );
        firebaseFirestore.collection("Forums")
                .add(forumMap)
                .addOnSuccessListener(documentReference -> createListener.onSuccess())
                .addOnFailureListener(e -> createListener.onFailure( e.getMessage() ));
    }

    public static void likeForum( Forum forum ){
        firebaseFirestore.collection("Forums").whereEqualTo("date", forum.getDate() ).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if( task.isSuccessful() ){

                }
                else{

                }
            }
        });
    }

    public static void addComment(){

    }

    public static void unLikeForum(){

    }

    public static void deleteComment(){

    }

    public static void deleteForum(Forum forum, DeleteListener deleteListener ){
        firebaseFirestore.collection(HW05_ROOT_COLLECTION).whereEqualTo("userId", forum.getUserId()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    if(document.get("title").equals(forum.getTitle())){
                        firebaseFirestore.collection("Forums").document(document.getId()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task1) {
                                if(task1.isSuccessful()){
                                    deleteListener.onSuccess();
                                }
                                else{
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
        //Add order by clause
//        firebaseFirestore.collection(HW05_ROOT_COLLECTION ).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if(task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        Forum forum = new Forum( document.get("date").toString(), document.get("subTitle").toString(),
//                                document.get("title").toString(),
//                                document.get("userId").toString(),
//                                document.get("userName").toString() );
//                        forumList.add(forum);
//                    }
//                    forumListListener.onSuccess(forumList);
//                } else {
//                    forumListListener.onFailure(task.getException().getMessage());
//                }
//            }
//        });

        firebaseFirestore.collection( HW05_ROOT_COLLECTION ).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if( e == null && queryDocumentSnapshots != null ){
                for ( QueryDocumentSnapshot document : queryDocumentSnapshots ) {
//                    Forum forum = new Forum( document.get("date").toString(), document.get("subTitle").toString(),
//                            document.get("title").toString(),
//                            document.get("userId").toString(),
//                            document.get("userName").toString() );
                    Forum forum = document.toObject( Forum.class );
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
