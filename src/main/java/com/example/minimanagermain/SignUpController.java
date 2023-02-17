package com.example.minimanagermain;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane signUpAnchor;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    loginBtn.setOnMouseClicked(event -> {
    ChangingScene.translateForward(LoginController.parentStackPane, "login", signUpAnchor);
});
    }
}
