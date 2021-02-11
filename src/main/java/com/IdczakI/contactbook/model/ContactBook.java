package com.IdczakI.contactbook.model;

import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ContactBook {

    public List<Contact> search(ObservableList<Contact> list, String s) {
        return list.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(s.toLowerCase())
                        || contact.getPhone().toLowerCase().contains(s.toLowerCase())
                        || contact.getEmail().toLowerCase().contains(s.toLowerCase())
                        || contact.getDescription().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toList());
    }
}
