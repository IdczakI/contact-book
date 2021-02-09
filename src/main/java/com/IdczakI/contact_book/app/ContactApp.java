package com.IdczakI.contact_book.app;

import com.IdczakI.contact_book.io.CsvTool;
import com.IdczakI.contact_book.model.Contact;

import java.util.List;

public class ContactApp {

    public static void main(String[] args) {
        CsvTool.readFile();
        System.out.println(CsvTool.getContactList());

        List<Contact> contactList = List.of(new Contact("123","123","13","123"));
        CsvTool.setContactList(contactList);
        CsvTool.writeFile();
        System.out.println(CsvTool.getContactList());

    }
}
