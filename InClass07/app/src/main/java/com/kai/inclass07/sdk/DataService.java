package com.kai.inclass07.sdk;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kai.inclass07.listeners.ContactListListener;
import com.kai.inclass07.listeners.GenericRequestListener;
import com.kai.inclass07.listeners.PostRequestListener;
import com.kai.inclass07.model.ContactListResponse;
import com.kai.inclass07.model.Contact;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataService {

    public static void getContactList(ContactListListener contactListListener ){
        String url = "https://www.theappsdr.com/contacts/json";
        getResponse(url, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                contactListListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                contactListListener.onSuccess( getContactsJson(reader) );
            }
        });
    }

    public static void createContact(Contact contact, PostRequestListener postRequestListener ){
        String url = "https://www.theappsdr.com/contact/json/create";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put( "name", contact.getName() );
            jsonObject.put( "email", contact.getEmail() );
            jsonObject.put( "phone", contact.getPhone() );
            jsonObject.put( "type", contact.getPhoneType() );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        postData(url, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postRequestListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                postRequestListener.onSuccess();
            }
        });
    }

    public static void updateContact(Contact contact, PostRequestListener postRequestListener ){
        String url = "https://www.theappsdr.com/contact/json/update";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", contact.getCid() );
            jsonObject.put( "name", contact.getName() );
            jsonObject.put( "email", contact.getEmail() );
            jsonObject.put( "phone", contact.getPhone() );
            jsonObject.put( "type", contact.getPhoneType() );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        postData(url, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postRequestListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                postRequestListener.onSuccess();
            }
        });
    }

    public static void deleteContact(Contact contact, PostRequestListener postRequestListener ){
        String url = "https://www.theappsdr.com/contact/json/delete";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", contact.getCid() );
        }
        catch ( JSONException exception ){
            //Ignore
        }
        RequestBody body = RequestBody.create( JSON, jsonObject.toString() );
        postData(url, body, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                postRequestListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                postRequestListener.onSuccess();
            }
        });
    }

    private static void postData(String url, RequestBody requestBody, GenericRequestListener genericRequestListener ){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url( url )
                .post( requestBody )
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

    private static void getResponse(String url, GenericRequestListener genericRequestListener ){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url( url )
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

    private static ArrayList<Contact> getContactsJson(Reader reader )
    {
        Gson gson = new GsonBuilder().create();
        ContactListResponse contactListResponse = gson.fromJson( reader, ContactListResponse.class );
        return contactListResponse.getContacts();
    }
}
