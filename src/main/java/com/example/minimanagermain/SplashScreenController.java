package com.example.minimanagermain;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author .py_ML_ai_MIT
 * Please don't touch the code here
 * */
public class SplashScreenController implements Initializable {
    @FXML
    private Label percentageCount;

    @FXML
    private ProgressBar progressBar;

    public static Label percent;

    LoadingScreen loadingScreen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        percentageCount.setOnMouseClicked(event -> {
            Thread thread = new Thread(loadingScreen);
            thread.setDaemon(true);
            thread.start();
        });


        loadingScreen = new LoadingScreen(progressBar);
    }

    public class LoadingScreen implements Runnable{
        ProgressBar progressBar1;

        /**
        * This class if for loading of the progress bar
        * */
        public LoadingScreen(ProgressBar progressBar2){
            this.progressBar1 = progressBar2;
        }

        @Override
        public void run() {
            while (progressBar1.getProgress() <= 1){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar1.setProgress(progressBar1.getProgress() + 0.1);
                        if ((int) progressBar1.getProgress() == 1){

                            try {
                                ChangingScene.changeSceneWindow(new ActionEvent(), "login");
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            System.out.println("progress num = "+ progressBar1.getProgress());
                            try {
                                Thread.sleep(100);
                            }catch (Exception e){
                                e.getCause();
                                e.printStackTrace();
                            }

                        }
                    }
                });
                synchronized (this){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        System.out.println("am done here");
                    }
                }
            }

        }
    }
}
