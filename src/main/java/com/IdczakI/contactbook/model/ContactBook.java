package com.IdczakI.contactbook.model;

import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ContactBook {

    public Contact addContact(String name, String phone, String email, String description) {
        return new Contact(name, phone, email, description);
    }

    public void deleteContact(ObservableList<Contact> list, Contact contact) {
        list.remove(contact);
    }

    public List<Contact> search(ObservableList<Contact> list, String s) {
        return list.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(s.toLowerCase())
                        || contact.getPhone().toLowerCase().contains(s.toLowerCase())
                        || contact.getEmail().toLowerCase().contains(s.toLowerCase())
                        || contact.getDescription().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toList());
    }
}
