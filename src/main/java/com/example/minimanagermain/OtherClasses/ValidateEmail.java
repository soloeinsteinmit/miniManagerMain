package com.example.minimanagermain.OtherClasses;

import javafx.scene.control.Alert;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static boolean validateEmail(String emailText){
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher matcher = pattern.matcher(emailText);
        if (matcher.find() && matcher.group().equals(emailText)){
            return true;
        } else {

            String title = "Email Validation Error";
            String message = "Please enter a valid email";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(3000));

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email");
            alert.showAndWait();
            return false;



            //final Tooltip tooltipFullScreen = new Tooltip();
            //tooltipFullScreen.setText("Press to toggle full screen. Press Esc to exit full screen");
            //tooltipFullScreen.setShowDelay(Duration.seconds(1));
            //fullScreen.setTooltip(tooltipFullScreen);
        }
    }
}
