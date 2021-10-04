package com.kai.inclass07.listeners;

import com.kai.inclass07.model.Contact;

import java.util.ArrayList;

public interface ContactListListener {
    void onFailure( String message );
    void onSuccess(ArrayList<Contact> contactList );
}
