package com.example.minimanagermain.OtherClasses;

import com.example.minimanagermain.LoginClass;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowManagement {

    public static void closeWindow(ActionEvent event){
        Stage stage = (Stage) ((MFXButton)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public static void minimizeWindow(ActionEvent event){
        Stage stage = (Stage) ((MFXButton)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    private static double x = 0;
    private static double y = 0;

    public static void movablePane(Pane pane){
        pane.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        pane.setOnMouseDragged(mouseEvent -> {
            LoginClass.my_stage.setX(mouseEvent.getScreenX() - x);
            LoginClass.my_stage.setY(mouseEvent.getScreenY() - y);
        });
    }

}
