package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.AlertNotification;
import com.example.minimanagermain.OtherClasses.DataAccess;
import com.example.minimanagermain.OtherClasses.PrintValues;
import com.example.minimanagermain.OtherClasses.ValidateEmail;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import tray.notification.NotificationType;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private MFXTextField acc_id_textField_signIn;

    @FXML
    private MFXTextField email_textField_signIn;

    @FXML
    private Label forgot_password;


    @FXML
    private MFXPasswordField password_textField_signIn;

    @FXML
    private Pane translateSignUpPane;

    public static String userName = "Solomon Eshun";
    public static MFXTextField getEmailText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getEmailText = email_textField_signIn;

        forgot_password.setOnMouseClicked(event -> {
            LoginController.forgotPassword();
        });

    }

    @FXML
    void signIn(ActionEvent event) {
        if ((email_textField_signIn.getText().isEmpty() || acc_id_textField_signIn.getText().isEmpty()
                || password_textField_signIn.getText().isEmpty()) ){

            AlertNotification.trayNotification("LOGIN ERROR", "PLEASE FILL IN ALL THE FORMS",
                    3, NotificationType.ERROR);
            PrintValues.print("here1");
        } else{
            try {


                if (DataAccess.loginUser(acc_id_textField_signIn.getText(), password_textField_signIn.getText())
                        && ValidateEmail.validateEmail(getEmailText.getText())
                    ){

                    PrintValues.print("here");
                    DataAccess.getIdOfLoggedInUser = acc_id_textField_signIn.getText();


                    AlertNotification.trayNotification("LOGIN SUCCESS", "YOU HAVE SUCCESSFULLY SIGNED IN",
                            3, NotificationType.SUCCESS);

                    ChangingScene.changeSceneWindowAction(event, "main_page");

                }
            } catch (IOException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
