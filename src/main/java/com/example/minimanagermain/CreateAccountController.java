package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.DataAccess;
import com.example.minimanagermain.OtherClasses.PrintValues;
import com.example.minimanagermain.OtherClasses.RandomIdGenerator;
import com.example.minimanagermain.OtherClasses.ValidateEmail;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author Solomon Eshun
 * This class creates a new account for the user
* */
public class CreateAccountController implements Initializable {

    @FXML
    private MFXTextField account_id_textField_signIn;

    @FXML
    private MFXTextField class_textField_signIn;

    @FXML
    private MFXTextField email_textField_signIn;

    @FXML
    private MFXButton generate_accId_btn;

    @FXML
    private MFXTextField name_textField_signIn;

    @FXML
    private MFXPasswordField password_textField_signIn;

    @FXML
    private MFXTextField phoneNumber_textField_signIn11;

    @FXML
    private MFXTextField schoolName_textField_signIn;

    @FXML
    private MFXButton signUp_btn_signIn;

    @FXML
    private Pane translateSignInPane;

    public static boolean isFound;
    public static MFXButton signUpBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        signUpBtn = signUp_btn_signIn;
        signUp_user();


    }

    /**
    * generate user account id
    * */


    @FXML
    void generate_accId_btn(ActionEvent event) {
        account_id_textField_signIn.setText(RandomIdGenerator.accountId(1111, 9999));
    }

    /**
    * signs up user
    * */
    private void signUp_user(){
        signUpBtn.setOnMouseClicked(event ->{
            try {
                if (account_id_textField_signIn.getText().isEmpty() || name_textField_signIn.getText().isEmpty()||
                    class_textField_signIn.getText().isEmpty()|| phoneNumber_textField_signIn11.getText().isEmpty()||
                        email_textField_signIn.getText().isEmpty()||  password_textField_signIn.getText().isEmpty()||
                        schoolName_textField_signIn.getText().isEmpty()){

                    PrintValues.print("Please fill in all the forms");

                }else {
                    if (DataAccess.createUserAccount(account_id_textField_signIn.getText(), name_textField_signIn.getText(),
                            class_textField_signIn.getText(), phoneNumber_textField_signIn11.getText(),
                            email_textField_signIn.getText(), password_textField_signIn.getText(),
                            schoolName_textField_signIn.getText()) && !ValidateEmail.validateEmail(email_textField_signIn.getText())){
                        PrintValues.print("User already exist or please check your email address");
                    }else {
                        DataAccess.getIdOfLoggedInUser = account_id_textField_signIn.getText();

                        ChangingScene.changeSceneWindow(event, "main_page");
                    }
                }


            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
