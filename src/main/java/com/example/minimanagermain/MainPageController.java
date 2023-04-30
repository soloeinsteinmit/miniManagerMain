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

public class MainPageController implements Initializable {

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
            GetFXMLFiles.getFxmlFile(centerPane, "dashboard.fxml");
            homeBtn.setFocusTraversable(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        close.setOnAction(WindowManagement::closeWindow);
        minimize.setOnAction(WindowManagement::minimizeWindow);
        WindowManagement.movablePane(movePane);

    }

    public void dashboard(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Dashboard");
        GetFXMLFiles.getFxmlFile(centerPane, "dashboard.fxml");
    }

    public void viewStudents(javafx.event.ActionEvent event) throws IOException {
        System.out.println("View Students");
        GetFXMLFiles.getFxmlFile(centerPane, "view_students.fxml");
    }

    public void remark(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Remarks");
        GetFXMLFiles.getFxmlFile(centerPane, "remark.fxml");
    }

    public void viewReport(javafx.event.ActionEvent event) throws IOException {
        System.out.println("View report");
        GetFXMLFiles.getFxmlFile(centerPane, "view_report.fxml");
    }

    public void settings(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Settings");
        GetFXMLFiles.getFxmlFile(centerPane, "settings.fxml");
    }

    public void admission(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Admission");
        GetFXMLFiles.getFxmlFile(centerPane, "admission.fxml");
    }

    public void assessment(javafx.event.ActionEvent event) throws IOException {
        System.out.println("Assessment");
        GetFXMLFiles.getFxmlFile(centerPane, "assessment.fxml");
    }

}
