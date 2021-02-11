package com.IdczakI.contactbook.controller;

import com.IdczakI.contactbook.io.CsvTool;
import com.IdczakI.contactbook.model.Contact;
import com.IdczakI.contactbook.model.ContactBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainPaneController {

    ObservableList<Contact> list = FXCollections.observableArrayList();
//    ObservableList<Contact> searchList = FXCollections.observableArrayList();
    ContactBook book = new ContactBook();

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
        createButton.setOnAction(event -> {
            Contact contact = book.addContact("dd", "13", "45", "fd");
            list.add(contact);
        });
        searchTextField.setOnKeyTyped(event -> {
            List<Contact> tmp = book.search(list, searchTextField.getText());
            ObservableList<Contact> searchList = FXCollections.observableArrayList(tmp);
            contactTableView.setItems(searchList);
        });

        loadContracts();

    }

    private void loadContracts() {
        CsvTool.readFile();
        list.addAll(CsvTool.getContactList());
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        contactTableView.setItems(list);
    }
}
