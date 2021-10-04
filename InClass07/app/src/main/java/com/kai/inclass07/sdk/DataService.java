package com.kai.inclass07.sdk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kai.inclass07.listeners.ContactListListener;
import com.kai.inclass07.listeners.GenericRequestListener;
import com.kai.inclass07.model.ContactListResponse;
import com.kai.inclass07.model.Contact;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

    public static void createContact( Contact contact ){

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
