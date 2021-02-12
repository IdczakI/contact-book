package com.IdczakI.contactbook.controller;

import com.IdczakI.contactbook.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddContactController extends MainController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button addContactButton;

    public void initialize() {
        addContactButton.setOnAction(this::createContact);
    }

    private void createContact(ActionEvent event) {
        list.add(new Contact(nameTextField.getText(), phoneTextField.getText(),
                emailTextField.getText(), descriptionTextField.getText()));
        Stage stage = (Stage) addContactButton.getScene().getWindow();
        stage.close();
    }

}
