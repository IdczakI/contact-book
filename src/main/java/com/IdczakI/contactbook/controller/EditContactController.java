package com.IdczakI.contactbook.controller;

import com.IdczakI.contactbook.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditContactController extends MainController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Button editContactButton;

    public void initialize() {
        fillTextFields();
        editContactButton.setOnAction(this::editContact);
    }

    private void editContact(ActionEvent event) {
        newContact = new Contact(nameTextField.getText(), phoneTextField.getText(),
                emailTextField.getText(), descriptionTextField.getText());
        Stage stage = (Stage) editContactButton.getScene().getWindow();
        stage.close();

    }

    public void fillTextFields() {
        nameTextField.setText(tmpContact.getName());
        phoneTextField.setText(tmpContact.getPhone());
        emailTextField.setText(tmpContact.getEmail());
        descriptionTextField.setText(tmpContact.getDescription());
        tmpContact = new Contact("", "", "", "");
    }
}
