package com.kai.inclass07;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.kai.inclass07.listeners.ContactListListener;
import com.kai.inclass07.model.Contact;
import com.kai.inclass07.sdk.DataService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataService.getContactList(new ContactListListener() {
            @Override
            public void onFailure(String message) {
                Log.d( "MainActivity", "onFailure: " + message);
            }

            @Override
            public void onSuccess(ArrayList<Contact> contactList) {
                Log.d("MainActivity", "onSuccess: " + contactList.toString() );
            }
        });
    }
}