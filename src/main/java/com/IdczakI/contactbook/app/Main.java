package com.IdczakI.contactbook.app;

import com.IdczakI.contactbook.controller.MainController;
import com.IdczakI.contactbook.io.CsvTool;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox pane = FXMLLoader.load(getClass().getResource("/fxml/mainPane.fxml"));
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Contact Book");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop(){
        CsvTool.writeFile(MainController.getList());
    }
}
