package com.example.minimanagermain;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button admissionBtn;

    @FXML
    private Button dashboardBtn;
    @FXML
    private Button backButton;

    @FXML
    private Button examsBtn;

    @FXML
    private Button resultsBtn;

    @FXML
    private Button settingsBtn;

    @FXML
    private Button stdBtn;

    @FXML
    private AnchorPane homeAnchor;

    @FXML
    private MenuItem signOut;

    @FXML
    private MenuButton profileMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        profileMenu.getItems().setAll(signOut);

        backButton.setOnMouseClicked(mouseEvent -> {
            try {
                ChangingScene.changeSceneWindow(mouseEvent, "login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
