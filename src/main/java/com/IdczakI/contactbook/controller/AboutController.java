package com.IdczakI.contactbook.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class AboutController {

    @FXML
    private TextArea aboutTextArea;

    private final static String ABOUT_TEXT = """
            This is the Contact Book application.
            Here you can add, copy, edit, search, and delete contacts.
            All actions are handling with buttons except searching - 
            in this case you just need to enter the string in the text field.
            
            The data is loaded and saved in the csv file.
            
            
            version: 1.6, created by IdczakI
            """;

    public void initialize() {
        aboutTextArea.setText(ABOUT_TEXT);
    }
}
