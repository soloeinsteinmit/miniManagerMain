package com.example.minimanagermain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class GetFXMLFiles {

    public static Parent fxml;
    public static void getFxmlFile(StackPane stackPane, String fxmlFileName) throws IOException {
        fxml = FXMLLoader.load(Objects.requireNonNull(GetFXMLFiles.class.getResource(fxmlFileName)));
        stackPane.getChildren().removeAll();
        stackPane.getChildren().setAll(fxml);
    }
}
