package com.kai.midterm.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kai.midterm.listener.GenericRequestListener;
import com.kai.midterm.listener.PostUIListener;
import com.kai.midterm.listener.UIListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataService {

    public static void createAccount(NewUser newUser, UIListener uiListener ){
        String url = "https://www.theappsdr.com/posts/signup";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", newUser.email );
            jsonObject.put("password", newUser.password );
            jsonObject.put("name", newUser.name );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        getResponse(url, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                uiListener.onCreateFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                uiListener.onCreateSuccess( getUserFromJson( reader) );
            }
        });
    }

    public static void login( Login login, UIListener uiListener ){
        String url = "https://www.theappsdr.com/posts/login";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", login.email );
            jsonObject.put("password", login.password );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        getResponse(url, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                uiListener.onLoginFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                uiListener.onLoginSuccess( getUserFromJson( reader) );
            }
        });
    }

    public static void getPosts(User user, int pageNumber, PostUIListener postUIListener ){
        String url = "https://www.theappsdr.com/posts?page="+pageNumber;
        getPostResponse(url, user, null, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postUIListener.onPostFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                PostContainer postContainer = getPostData( reader );
                postUIListener.onPostsSuccess( postContainer );
            }
        });
    }

    public static void createPost(User user, String data, PostUIListener postUIListener ){
        String url = "https://www.theappsdr.com/posts/create";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("post_text", data );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        getPostResponse(url, user, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postUIListener.onPostFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                postUIListener.onCreateSuccess();
            }
        });
    }

    public static void deletePost( User user, String id, PostUIListener postUIListener ){
        String url = "https://www.theappsdr.com/posts/delete";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("post_id", id );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        getPostResponse(url, user, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postUIListener.onPostFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                postUIListener.onDeleteSuccess();
            }
        });
    }

    private static void getPostResponse(String url, User user, RequestBody body, GenericRequestListener genericRequestListener){
        OkHttpClient client = new OkHttpClient();
        Request request;
        if( body == null ) {
            request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "BEARER " + user.token)
                    .build();
        }
        else{
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader("Authorization", "BEARER " + user.token)
                    .build();
        }

        client.newCall( request ).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                genericRequestListener.onFailure( e.getMessage() );
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if( response.isSuccessful() ) {
                    genericRequestListener.onSuccess(response.body().charStream());
                }
                else
                {
                    genericRequestListener.onFailure( response.message() );
                }
            }
        });
    }

    private static void getResponse(String url, RequestBody body, GenericRequestListener genericRequestListener){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url( url )
                .post( body )
                .build();

        client.newCall( request ).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                genericRequestListener.onFailure( e.getMessage() );
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if( response.isSuccessful() ) {
                    genericRequestListener.onSuccess(response.body().charStream());
                }
                else
                {
                    genericRequestListener.onFailure( response.message() );
                }
            }
        });
    }

    private static User getUserFromJson(Reader reader )
    {
        Gson gson = new GsonBuilder().create();
        User user = gson.fromJson( reader, User.class );
        return user;
    }

    private static PostContainer getPostData(Reader reader) {
        Gson gson = new GsonBuilder().create();
        PostContainer postContainer = gson.fromJson( reader, PostContainer.class );
        return postContainer;
    }
}
