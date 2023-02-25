package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.OtherCode;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SignInIBankAccountTextController implements Initializable {

    @FXML
    private MFXTextField acc_id_textField_signUp;

    @FXML
    private MFXTextField email_textField_signUp;

    @FXML
    private Label forgot_password;

    @FXML
    private Circle moving_ball;

    @FXML
    private MFXPasswordField password_textField_signUp;

    @FXML
    private MFXButton sign_btn;

    @FXML
    public static Pane translateSignUpPane;

    private Parent root;
    private Stage stage;
    private Scene scene;
    public static String userName = "Solomon Eshun";
    public static boolean isEqualController;
    public static MFXTextField getEmailText;
    public static MFXButton signInBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getEmailText = email_textField_signUp;
        signInBtn = sign_btn;
        /*TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(8), moving_ball);
        translateTransition1.setToX(translateSignUpPane.getWidth());
        translateTransition1.setToY(translateSignUpPane.getHeight());
        translateTransition1.setCycleCount(2);
        translateTransition1.setAutoReverse(true);
        translateTransition1.play();
        translateTransition1.setOnFinished(event -> {
            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(8), moving_ball);
            translateTransition2.setToX(translateSignUpPane.getWidth());
            translateTransition2.setToY(-translateSignUpPane.getHeight());
            translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
            translateTransition2.setAutoReverse(true);
            translateTransition2.play();
        });*/

        forgot_password.setOnMouseClicked(event -> {
            LoginController.forgotPassword();
        });
        signIn_User();

    }

    private void signIn_User(){
        signInBtn.setOnAction(event -> {
            if ((email_textField_signUp.getText().isEmpty() || acc_id_textField_signUp.getText().isEmpty()
                    || password_textField_signUp.getText().isEmpty()) ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill in all the forms");
                alert.show();
            } else{
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                    root = loader.load();

                    if (OtherCode.validateEmail(getEmailText.getText())){

                        HomeController.str_userName = userName;
                        HomeController.str_email = email_textField_signUp.getText();
                        HomeController.str_accId = acc_id_textField_signUp.getText();
                        HomeController.str_password = password_textField_signUp.getText();

                        String[] splitName = userName.split(" ");
                        String[] firstName = splitName[0].split("");
                        // gotten abbr name
                        HomeController.str_abbrName = firstName[0] + " " + splitName[splitName.length-1];
                        System.out.println(HomeController.str_abbrName);

                        System.out.println(Arrays.toString(splitName));
                        System.out.println(Arrays.toString(firstName));

                        HomeController.setUserCredentials();

                        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                        String title = "SIGNING IN";
                        String message = userName.toUpperCase() + " HAS SUCCESSFULLY SIGNED IN";
                        TrayNotification tray = new TrayNotification();
                        AnimationType type = AnimationType.POPUP;

                        tray.setAnimationType(type);
                        tray.setTitle(title);
                        tray.setMessage(message);
                        tray.setNotificationType(NotificationType.SUCCESS);
                        tray.showAndDismiss(Duration.millis(5000));
                    }
                    System.out.println("userName = " + userName);
                } catch (IOException ex) {
                    System.out.println(" error dashboard fxml");
                    throw new RuntimeException(ex);
                }


                //LoginDbConnection.signInUser(event, "dashboard1.fxml", email_textField_signUp.getText(),
                  //      acc_id_textField_signUp.getText(), password_textField_signUp.getText());
             }
        });
    }


}
