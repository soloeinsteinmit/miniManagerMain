package com.example.minimanagermain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Solomon Einstein MIT Eshun
 * */
public class BankingSystemApplication extends Application {

    public static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankingSystemApplication.class.getResource("banking_system.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 772, 618);
        stage.setTitle("Banking System");
        stage.setScene(scene);

        stg = stage;

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}