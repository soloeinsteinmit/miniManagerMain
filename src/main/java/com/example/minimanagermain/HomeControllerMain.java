package com.example.minimanagermain;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeControllerMain implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private AnchorPane homeAnchor;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backBtn.setOnMouseClicked(event -> {
            try {
                ChangingScene.changeSceneWindow(event, "login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
