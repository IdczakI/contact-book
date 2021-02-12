package com.IdczakI.contactbook.model;

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

}
