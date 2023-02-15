package com.example.minimanagermain;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

/**
 * @author .py_ML_ai_MIT
 * */
public class ChangingScene {
    // this code is temporary
    /**
    * @param container - receives other panes
    * @param fxmlFileName - name of fxml file you want to load to
     * */
    public static void changingScene(StackPane container, String fxmlFileName) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(ChangingScene.class.getResource(fxmlFileName+".fxml")));
        container.getChildren().removeAll();
        container.getChildren().setAll(fxml);
    }

    /**
     * Forward transition
     *
     * @param pane - stack pane at the login scene.
     * @param fileName - name of fxml to be changed to.
     */
    public static void translateForward(StackPane pane, String fileName, AnchorPane anchorPane) {
        Parent fxmlName = null;
        try {
            fxmlName = FXMLLoader.load(
                    Objects.requireNonNull(ChangingScene.class.getResource(fileName + ".fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxmlName);

        fxmlName.translateXProperty().set(anchorPane.getWidth());
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(fxmlName.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> pane.getChildren().remove(anchorPane));
        timeline.play();

    }

    /**
     * Backward transition
     *
     * @param pane     stack pane at the login scene.
     * @param fileName name of fxml to be changed to.
     */
    public static void translateBack(StackPane pane, String fileName, AnchorPane anchorPane) {
        Parent fxmlName = null;
        try {
            fxmlName = FXMLLoader.load(
                    Objects.requireNonNull(ChangingScene.class.getResource(fileName + ".fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane.getChildren().removeAll();
        pane.getChildren().setAll(fxmlName);

        fxmlName.translateXProperty().set(-anchorPane.getWidth());
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(fxmlName.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.3), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> pane.getChildren().remove(anchorPane));
        timeline.play();

    }

    /**
     * @param fxmlFileName name of fxml to be changed to.
     * @param event - helps in the changing of scene when invoked
     */
    public static void changeSceneWindow(MouseEvent event, String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(ChangingScene.class.getResource(fxmlFileName + ".fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
