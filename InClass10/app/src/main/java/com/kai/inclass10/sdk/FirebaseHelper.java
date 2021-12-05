package com.kai.inclass10.sdk;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.kai.inclass10.listener.LoginListener;
import com.kai.inclass10.listener.RegisterListener;
import com.kai.inclass10.listener.RouteListener;
import com.kai.inclass10.model.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseHelper {

    static FirebaseAuth firebaseAuth;
    static FirebaseFirestore firebaseFirestore;
    static final String ROOT_COLLECTION = "users";

    public static void initFirebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public static FirebaseUser getUser(){
        return firebaseAuth.getCurrentUser();
    }

    public static void create(String email, String password, RegisterListener registerListener ){
        firebaseAuth.createUserWithEmailAndPassword( email, password ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                registerListener.onSuccess();
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

    public static void getAllRoutes( RouteListener routeListener ){
        ArrayList<Route> routeList = new ArrayList<>();
        firebaseFirestore.collection( ROOT_COLLECTION+"/"+ getUser().getUid()+"/history" ).addSnapshotListener((queryDocumentSnapshots, e) -> {
            if( e == null && queryDocumentSnapshots != null ){
                routeList.clear();
                for ( QueryDocumentSnapshot document : queryDocumentSnapshots ) {
                    //TODO verify
                    ArrayList<LatLng> arrayList = (ArrayList<LatLng>) document.get("route");
                    Route route = new Route( arrayList );
                    routeList.add( route );
                }
                routeListener.onSuccess(routeList);
            }
            else{
                routeListener.onFailure( e.getMessage() );
            }
        });
    }

    public static void addRoute(ArrayList<LatLng> pointList) {
        Map<String, Object> pointMap = new HashMap<String, Object>();
        pointMap.put("route", pointList);
        firebaseFirestore.collection(ROOT_COLLECTION + "/" + getUser().getUid() + "/history")
                .add(pointMap)
                .addOnSuccessListener(documentReference -> {
                    Log.d("Route", "addRoute: Success");
                })
                .addOnFailureListener(e -> {
                    Log.d("Route", "addRoute: Failure");
                });
    }
}
