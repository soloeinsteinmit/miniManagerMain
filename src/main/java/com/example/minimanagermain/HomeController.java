package com.example.minimanagermain;

import io.github.gleidson28.GNAvatarView;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Label abbr_name;

    @FXML
    private Label current_Month;

    @FXML
    private Label freeTransfer;

    @FXML
    private MFXButton logoutBtn;

    @FXML
    private Label numOfContactsLabel;

    @FXML
    private Label user_acc_id;

    @FXML
    private Label user_email;

    @FXML
    private Label user_name;

    @FXML
    private Label user_password;

    @FXML
    private GNAvatarView user_profile;

    @FXML
    private Label visa_num_label;

    private static Parent root;
    public static MFXButton logOutImg;
    public static Label userName;
    public static Label email;
    public static Label password;
    public static Label visaNumLabel;
    public static Label free_transfer;
    public static Label num_of_contact;
    public static GNAvatarView uProfilePic;
    public static Label accId;
    public static Label currentMonth;
    public static Label abbrName;

    public static String str_userName;
    public static String str_email;
    public static String str_password;
    public static String str_accId;
    public static String str_currentMonth;
    public static String str_abbrName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userName = user_name;                           email = user_email;
        password = user_password;                       accId = user_acc_id;
        abbrName = abbr_name;                           currentMonth = current_Month;

        visaNumLabel = visa_num_label;                  free_transfer = freeTransfer;
        num_of_contact = numOfContactsLabel;            uProfilePic = user_profile;

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
        str_currentMonth = dateFormat.format(date);

        setUserCredentials();
        System.out.println("home controller = " + str_abbrName);

        logOutImg = logoutBtn;
        logout();
    }

    public static void logout(){
        logOutImg.setOnMouseClicked(event -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(LoginController.class.getResource("Login.fxml")));

                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void setUserCredentials(){
        userName.setText(str_userName);
        email.setText(str_email);
        accId.setText(str_accId);
        password.setText(str_password);
        abbrName.setText(str_abbrName);
    }

    public void setUserCredentials2(String name, String abbr_name, InputStream stream, String fTrans){
        userName.setText(name);
        free_transfer.setText(fTrans);
        abbrName.setText(abbr_name);

        Image image = new Image(stream);
        uProfilePic.setImage(image);
    }

}
