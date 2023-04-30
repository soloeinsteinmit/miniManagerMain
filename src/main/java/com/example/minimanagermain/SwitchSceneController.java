package com.example.minimanagermain;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SwitchSceneController implements Initializable {

    @FXML
    private static Text logo_text;

    @FXML
    private static ImageView logo_white;

    @FXML
    private MFXButton sign_in;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sign_in.setOnAction(event -> {
            LoginController.fadeInLogoAndText(logo_white, logo_text);
            LoginController.open_sign_up();

        });
    }
}
