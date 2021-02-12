package com.IdczakI.contactbook.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteContactController extends MainController {

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    public void initialize() {
        yesButton.setOnAction(event -> {
            list.remove(tableIndex);
            closeWindow();
        });
        noButton.setOnAction(event -> closeWindow());
    }

    private void closeWindow() {
        Stage stage = (Stage) yesButton.getScene().getWindow();
        stage.close();
    }
}
