package com.example.minimanagermain;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpControllerMain implements Initializable {
    @FXML
    private Label loginBtn;

    @FXML
    private Button createAccount;

    @FXML
    private AnchorPane signUpAnchor;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginBtn.setOnMouseClicked(event -> {
            ChangingScene.translateForward(LoginControllerMain.parentStackPane, "login", signUpAnchor);
        });

        createAccount.setOnMouseClicked(event -> {
            try {
                ChangingScene.changeSceneWindow(event, "home");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
