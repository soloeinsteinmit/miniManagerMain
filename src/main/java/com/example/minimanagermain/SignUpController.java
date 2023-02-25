package com.example.minimanagermain;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private MFXButton signUpBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signUpBtn.setOnAction(event -> {
            LoginController.open_sign_in();
        });
    }

}
