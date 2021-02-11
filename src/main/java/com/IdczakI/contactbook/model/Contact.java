package com.IdczakI.contactbook.model;

import java.util.Objects;

public class Contact {

    private String name;
    private String phone;
    private String email;
    private String description;

    public Contact(String name, String phone, String email, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String toCsv() {
        return name + "," + phone + "," + email + "," + description + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phone, contact.phone)
                && Objects.equals(email, contact.email) && Objects.equals(description, contact.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, description);
    }
}
