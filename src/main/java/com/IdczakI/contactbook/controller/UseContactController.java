package com.IdczakI.contactbook.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UseContactController {

    @FXML
    private Button okButton;

    public void initialize(){
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }
}
