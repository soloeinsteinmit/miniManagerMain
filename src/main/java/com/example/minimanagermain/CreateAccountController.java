package com.example.minimanagermain;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


/**
 * @author Solomon Eshun
* */
public class CreateAccountController implements Initializable {

    @FXML
    private MFXTextField account_id_textField_signIn;

    @FXML
    private MFXTextField email_textField_signIn;

    @FXML
    private MFXButton generate_accId_btn;

    @FXML
    private MFXTextField name_textField_signIn;

    @FXML
    private MFXPasswordField password_textField_signIn;

    @FXML
    private MFXButton signUp_btn_signIn;

    @FXML
    public static Pane translateSignInPane;

    public static boolean isFound;
    public static MFXButton signUpBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        signUpBtn = signUp_btn_signIn;
        generateAccId();
        signUp_user();


    }

    /**
    * generate user account id
    * */
    private void generateAccId(){
        generate_accId_btn.setOnAction(event1 -> {
            Random acc_id = new Random();
            int min = 11111;
            int max = 99999;
            account_id_textField_signIn.setText("G-"+ String.valueOf(acc_id.nextInt(max - min + 1)+min));
        });
    }

    /**
    * signs up user
    * */
    private void signUp_user(){
        signUpBtn.setOnMouseClicked(event ->{
            try {
                ChangingScene.changeSceneWindow(event, "main_page");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
