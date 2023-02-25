package com.example.minimanagermain;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author .py_ML_ai_MIT
 * */
public class LoginControllerMain implements Initializable {
    @FXML
    private AnchorPane loginAnchor;

    @FXML
    private Button nextSceneLabel;

    @FXML
    private StackPane parentContainer;

    public static StackPane parentStackPane;
    @FXML
    private Label signUp;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parentStackPane = parentContainer;
        nextSceneLabel.setOnMouseClicked(event -> {
            try {
                ChangingScene.changeSceneWindow(event, "home");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        signUp.setOnMouseClicked(event -> {
            ChangingScene.translateBack(parentStackPane, "sign_up", loginAnchor);
        });


    }
}
