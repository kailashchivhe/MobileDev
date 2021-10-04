package com.kai.inclass07.model;

import java.util.ArrayList;

public class ContactResponse {
    String status;
    ArrayList<Contacts> contacts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contacts> contacts) {
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
