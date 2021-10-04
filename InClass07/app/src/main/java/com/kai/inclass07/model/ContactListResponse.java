package com.kai.inclass07.model;

import java.util.ArrayList;

public class ContactListResponse {
    String status;
    ArrayList<Contact> contacts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ContactResponse{" +
                "status='" + status + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
