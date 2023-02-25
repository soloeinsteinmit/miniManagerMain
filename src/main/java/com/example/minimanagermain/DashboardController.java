package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.WindowManagement;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private StackPane center_pane;

    @FXML
    private MFXButton homeBtn;

    @FXML
    private MFXButton closeBtn;
    @FXML
    private Pane movablePane;

    @FXML
    private MFXButton minimizeBtn;
    public static StackPane centerPane;
    public static MFXButton close;
    public static MFXButton minimize;
    public static Pane movePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        centerPane = center_pane;
        minimize = minimizeBtn;
        close = closeBtn;
        movePane = movablePane;

        try {
            System.out.println("Home");
            GetFXMLFiles.getFxmlFile(centerPane, "home.fxml");
            homeBtn.setFocusTraversable(true);
            HomeController.setUserCredentials();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        close.setOnAction(WindowManagement::closeWindow);
        minimize.setOnAction(WindowManagement::minimizeWindow);
        WindowManagement.movablePane(movePane);

    }

    public void Home(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Home");
        GetFXMLFiles.getFxmlFile(centerPane, "home.fxml");
    }

    public void Analytics(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Analytics");
        GetFXMLFiles.getFxmlFile(centerPane, "analytics.fxml");
    }

    public void Wallet(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Wallet");
        GetFXMLFiles.getFxmlFile(centerPane, "wallet.fxml");
    }

    public void Profile(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Profile");
        GetFXMLFiles.getFxmlFile(centerPane, "profile.fxml");
    }

    public void Settings(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Settings");
        GetFXMLFiles.getFxmlFile(centerPane, "settings.fxml");
    }

    public void Activity(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Activity");
        GetFXMLFiles.getFxmlFile(centerPane, "activity.fxml");
    }

}
