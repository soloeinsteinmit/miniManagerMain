package com.example.minimanagermain;


import com.example.minimanagermain.OtherClasses.OtherCode;
import com.example.minimanagermain.OtherClasses.WindowManagement;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.events.JFXDialogEvent;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * @author Solomon Einstein MIT Eshun
 * */

public class LoginController implements Initializable {
    @FXML
    private MFXButton cancelBtn;

    @FXML
    private MFXButton changePasswordBtn;

    @FXML
    public MFXButton close_white_signUp;
    @FXML
    public MFXButton minimizeBtn;

    @FXML
    private VBox createAccount_vBox;

    @FXML
    private MFXTextField fg_emailTextField;

    @FXML
    private MFXPasswordField fg_passwordTextField_new;

    @FXML
    private MFXPasswordField fg_passwordTextField_newReEnter;

    @FXML
    public JFXDialog forgotPasswordDialogBox;

    @FXML
    private Text ibank_signUp;

    @FXML
    private ImageView logo_signUp;

    @FXML
    public StackPane parentDialogShow;
    @FXML
    public AnchorPane anchorBlur;
    @FXML
    public AnchorPane dialogAnchor;
    @FXML
    private VBox signIn_vBox;
    @FXML
    private Pane movablePane;
    @FXML
    private VBox vBox;
    @FXML
    private MFXGenericDialog mfxGenericDialog;

    public static Pane movePane;
    public static VBox container;
    public static VBox container_iBank;
    public static VBox panel;
    public static Text iBankText;
    public static ImageView logo_img;
    public static JFXDialog forgotPassDialog;
    public static StackPane blurStack;
    public static AnchorPane blurAnchor;
    public static MFXButton cancelButton;
    public static MFXButton changePasswordButton;
    public static AnchorPane dialogAnchorBlur;
    public static MFXTextField fgEmail;
    public static MFXPasswordField fgPassNew;
    public static MFXPasswordField fgPassNewRe;

    public static MFXButton closeBtn;
    public static MFXButton minimizeButton;

    private static Parent fxml;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logInAccount();

        movePane = movablePane;
        closeBtn = close_white_signUp;
        minimizeButton = minimizeBtn;
        fgEmail = fg_emailTextField;
        fgPassNew = fg_passwordTextField_new;
        fgPassNewRe = fg_passwordTextField_newReEnter;

        forgotPassDialog = forgotPasswordDialogBox;
        blurStack = parentDialogShow;
        blurAnchor = anchorBlur;
        forgotPassDialog.setDialogContainer(blurStack);

        dialogAnchorBlur = dialogAnchor;
        cancelButton = cancelBtn;
        changePasswordButton = changePasswordBtn;
        iBankText = ibank_signUp;
        logo_img = logo_signUp;
        container = createAccount_vBox;
        container_iBank = signIn_vBox;
        panel = vBox;

        closeBtn.setOnAction(WindowManagement::closeWindow);

        minimizeButton.setOnAction(WindowManagement::minimizeWindow);

        WindowManagement.movablePane(movePane);

    }


    public static void open_sign_in(){

        try {
            fxml = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("createAccount.fxml")));


            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), panel);
            translateTransition.setToX(-panel.getLayoutX());
            translateTransition.play();
            fadeOutLogoAndText();
            translateSignInPane();
            translateTransition.setOnFinished(e -> {

                FadeTransition fadeTransition1 = new FadeTransition();
                fadeTransition1.setNode(container_iBank);
                fadeTransition1.setDuration(Duration.seconds(1));
                fadeTransition1.setInterpolator(Interpolator.EASE_IN);
                fadeTransition1.setFromValue(1);
                fadeTransition1.setToValue(0);
                fadeTransition1.play();
            });

            container.getChildren().removeAll();
            container.getChildren().setAll(fxml);

            fxml = FXMLLoader.load(Objects.requireNonNull(
                    LoginController.class.getResource("sign_in.fxml")));

            panel.getChildren().removeAll();
            panel.getChildren().setAll(fxml);

        } catch (IOException exception){
            System.out.println("Error found in removing or setting fxml sign in");
            exception.printStackTrace();
        }
    }

    public static void open_sign_up(){

            try {
                fxml = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("signin_iBank.fxml")));


                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), panel);
                translateTransition.setToX(0);
                translateTransition.play();
                fadeInLogoAndText(logo_img, iBankText);
                translateSignUpPane();
                translateTransition.setOnFinished(e -> {

                    FadeTransition fadeTransition1 = new FadeTransition();
                    fadeTransition1.setNode(container);
                    fadeTransition1.setDuration(Duration.seconds(1));
                    fadeTransition1.setInterpolator(Interpolator.EASE_IN);
                    fadeTransition1.setFromValue(0);
                    fadeTransition1.setToValue(1);
                    fadeTransition1.play();
                });

                container.getChildren().removeAll();
                container.getChildren().setAll(fxml);

                fxml = FXMLLoader.load(Objects.requireNonNull(
                        LoginController.class.getResource("sign_up.fxml")));

                panel.getChildren().removeAll();
                panel.getChildren().setAll(fxml);

            } catch (IOException exception){
                System.out.println("Error found in removing or setting fxml sign in");
                exception.printStackTrace();
            }

    }

    public static void translateSignUpPane(){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), container);
        transition.setByX(-100);
        transition.play();
        transition.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setNode(container_iBank);
            fadeTransition.setDuration(Duration.seconds(1));
            fadeTransition.setInterpolator(Interpolator.EASE_IN);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            container.setVisible(false);
            container_iBank.setVisible(true);

            TranslateTransition transition1 = new TranslateTransition(Duration.seconds(0.5), container);
            transition1.setByX(100);
            transition1.play();


        });
    }

    public static void translateSignInPane(){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), container_iBank);
        transition.setByX(100);
        transition.play();
        transition.setOnFinished(event -> {
            FadeTransition fadeTransition = new FadeTransition();
            fadeTransition.setNode(container);
            fadeTransition.setDuration(Duration.seconds(1));
            fadeTransition.setInterpolator(Interpolator.LINEAR);
            fadeTransition.setFromValue(0.4);
            fadeTransition.setToValue(1);
            fadeTransition.play();

            container.setVisible(true);
            container_iBank.setVisible(false);

            TranslateTransition transition1 = new TranslateTransition(Duration.seconds(0.5), container_iBank);
            transition1.setByX(-100);
            transition1.play();
        });

    }

    private void logInAccount(){
        try {
            fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signIn_iBank.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        signIn_vBox.getChildren().setAll(fxml);

        try {
            fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sign_up.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        vBox.getChildren().add(fxml);
    }

    private static void fadeOutLogoAndText(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(iBankText);
        fadeTransition.setDuration(Duration.seconds(1));
        fadeTransition.setInterpolator(Interpolator.EASE_OUT);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        FadeTransition fadeTransition1 = new FadeTransition();
        fadeTransition1.setNode(logo_img);
        fadeTransition1.setDuration(Duration.seconds(1));
        fadeTransition1.setInterpolator(Interpolator.EASE_OUT);
        fadeTransition1.setFromValue(1);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();
    }

    public static void fadeInLogoAndText(ImageView logo, Text logoText){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(logo);
        fadeTransition.setDuration(Duration.seconds(1));
        fadeTransition.setInterpolator(Interpolator.EASE_IN);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        FadeTransition fadeTransition1 = new FadeTransition();
        fadeTransition1.setNode(logoText);
        fadeTransition1.setDuration(Duration.seconds(1));
        fadeTransition1.setInterpolator(Interpolator.EASE_IN);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1);
        fadeTransition1.play();
    }


    public static boolean isFoundDialog;
    public static void forgotPassword(){
        BoxBlur blur = new BoxBlur(3, 3, 3);

        blurAnchor.setEffect(blur);
        forgotPassDialog.show();
        blurAnchor.setDisable(true);

        forgotPassDialog.setOnMouseClicked(e ->{
            blurAnchor.setEffect(null);
            blurAnchor.setDisable(false);
            fgPassNewRe.setText("");
            fgEmail.setText("");
            fgPassNew.setText("");
        });

        cancelButton.setOnAction(e ->{

            forgotPassDialog.setOnDialogClosed((JFXDialogEvent event1) -> {
                blurAnchor.setEffect(null);
                fgPassNewRe.setText("");
                fgEmail.setText("");
                fgPassNew.setText("");
            });

            forgotPassDialog.close();

            blurAnchor.setDisable(false);
        });

        changePasswordButton.setOnAction(event -> {
            if (OtherCode.validateEmail(fgEmail.getText()) &&
                    fgPassNew.getText().equals(fgPassNewRe.getText())){
                if (isFoundDialog){
                    String title = "Forgot password";
                    String message = "Password changed successfully";
                    TrayNotification tray = new TrayNotification();
                    AnimationType type = AnimationType.POPUP;

                    tray.setAnimationType(type);
                    tray.setTitle(title);
                    tray.setMessage(message);
                    tray.setNotificationType(NotificationType.SUCCESS);
                    tray.showAndDismiss(Duration.millis(5000));

                    forgotPassDialog.setOnDialogClosed((JFXDialogEvent event1) -> {
                        blurAnchor.setEffect(null);
                        fgPassNewRe.setText("");
                        fgEmail.setText("");
                        fgPassNew.setText("");
                    });

                    forgotPassDialog.close();
                    blurAnchor.setDisable(false);
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Provided email not in database");
                    alert.show();
                }

            }

        });

    }

}
