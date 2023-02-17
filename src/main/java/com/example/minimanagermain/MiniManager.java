package com.example.minimanagermain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniManager extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MiniManager.class.getResource("login.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(MiniManager.class.getResource("splash_screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("miniManager");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
