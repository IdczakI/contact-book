package com.IdczakI.contactbook.controller;

import com.IdczakI.contactbook.io.CsvTool;
import com.IdczakI.contactbook.model.Contact;
import com.IdczakI.contactbook.model.ContactBook;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainController {

    static ObservableList<Contact> list = FXCollections.observableArrayList();
    ContactBook book = new ContactBook();
    static Contact tmpContact = new Contact("", "", "", "");
    static int tableIndex;

    public static ObservableList<Contact> getList() {
        return list;
    }

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private TableView<Contact> contactTableView;

    @FXML
    private TableColumn<Contact, String> nameTableColumn;

    @FXML
    private TableColumn<Contact, String> phoneTableColumn;

    @FXML
    private TableColumn<Contact, String> emailTableColumn;

    @FXML
    private TableColumn<Contact, String> descriptionTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button useContactButton;

    @FXML
    private Button createButton;

    @FXML
    private Button copyButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    public void initialize() {
        loadContacts();
        searchTextField.setOnKeyTyped(this::searchingOperation);
        createButton.setOnAction(this::addContact);
        copyButton.setOnAction(this::copyContact);
        editButton.setOnAction(this::editContact);
        deleteButton.setOnAction(this::deleteContact);
        useContactButton.setOnAction(this::useContact);
        exitMenuItem.setOnAction(event -> Platform.exit());
    }

    private void loadContacts() {
        CsvTool.readFile();
        list.addAll(CsvTool.getContactList());
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        contactTableView.setItems(list);
    }

    private void searchingOperation(KeyEvent keyEvent) {
        List<Contact> tmp = book.search(list, searchTextField.getText());
        ObservableList<Contact> searchList = FXCollections.observableArrayList(tmp);
        contactTableView.setItems(searchList);
    }

    private void addContact(ActionEvent event) {
        contactTableView.setItems(list);
        showAddContactPane();
    }

    private void copyContact(ActionEvent event) {
        contactTableView.setItems(list);
        if (!contactTableView.getSelectionModel().isEmpty()) {
            Contact contact = contactTableView.getItems().get(contactTableView.getSelectionModel().getSelectedIndex());
            list.add(contact);
        }
    }

    private void editContact(ActionEvent event) {
        contactTableView.setItems(list);
        if (!contactTableView.getSelectionModel().isEmpty()) {
            tableIndex = contactTableView.getSelectionModel().getSelectedIndex();
            tmpContact = contactTableView.getItems().get(tableIndex);
            showEditContactPane();
        }
    }

    private void deleteContact(ActionEvent event) {
        contactTableView.setItems(list);
        if (!contactTableView.getSelectionModel().isEmpty()) {
            showDeleteContactPane();
            tableIndex = contactTableView.getSelectionModel().getSelectedIndex();
        }
    }

    private void useContact(ActionEvent event) {
        contactTableView.setItems(list);
        if (!contactTableView.getSelectionModel().isEmpty()) {
            showUseContactPane();
        }
    }

    private void showAddContactPane() {
        showContactPane("/fxml/addContactPane.fxml", "Add Contact");
    }

    private void showEditContactPane() {
        showContactPane("/fxml/editContactPane.fxml", "Edit Contact");
    }

    private void showDeleteContactPane() {
        showContactPane("/fxml/deleteContactPane.fxml", "Delete Contact");
    }

    private void showUseContactPane() {
        showContactPane("/fxml/useContactPane.fxml", "Use Contact");
    }

    private void showContactPane(String resource, String title) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(resource));
            Scene scene = new Scene(pane);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
