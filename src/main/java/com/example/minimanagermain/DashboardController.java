package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.DataAccess;
import io.github.gleidson28.GNAvatarView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXProgressSpinner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label abbr_name;

    @FXML
    private Label academicYear;

    @FXML
    private Label accountId;

    @FXML
    private Label address;

    @FXML
    private Label className;

    @FXML
    private Label email;

    @FXML
    private MFXButton logoutBtn;

    @FXML
    private Label nextSemBegins;

    @FXML
    private Label numberOfFemales;

    @FXML
    private Label numberOfMales;

    @FXML
    private Label phoneNumber;

    @FXML
    private MFXProgressSpinner progressSpinnerFemale;

    @FXML
    private MFXProgressSpinner progressSpinnerMale;

    @FXML
    private Label schoolName;

    @FXML
    private Label semester;

    @FXML
    private Label totalNumberOfLearners;


    @FXML
    private Label user_name;

    @FXML
    private GNAvatarView user_profile;

    @FXML
    private Text welcomeMessage;

    private static Parent root;
    public static MFXButton logOutImg;
    public static Label userName;
    public static Label password;
    public static GNAvatarView uProfilePic;
    public static Label abbrName;

    public static String str_userName;
    public static String str_email;
    public static String str_password;
    public static String str_accId;
    public static String str_currentMonth;
    public static String str_abbrName;

    DataAccess dataAccess = new DataAccess();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setDashDashboardInfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
        str_currentMonth = dateFormat.format(date);

//        setUserCredentials();
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

    public void setUserCredentials2(String name, String abbr_name, InputStream stream, String fTrans){
        userName.setText(name);
        abbrName.setText(abbr_name);

        Image image = new Image(stream);
        uProfilePic.setImage(image);
    }

    public void setDashDashboardInfo() throws SQLException {
        //set personal info
        DataAccess.getPersonalInfo(DataAccess.getIdOfLoggedInUser);
        accountId.setText(DataAccess.personalInfo.get(0));
        user_name.setText(DataAccess.personalInfo.get(1));
        phoneNumber.setText(DataAccess.personalInfo.get(2));
        email.setText(DataAccess.personalInfo.get(3));
        welcomeMessage.setText("WELCOME "+ DataAccess.personalInfo.get(1).toUpperCase());

        //set school info
        DataAccess.getSchoolInfo(DataAccess.getIdOfLoggedInUser);
        schoolName.setText(DataAccess.schoolInfo.get(0));
        className.setText(DataAccess.schoolInfo.get(1));
        address.setText(DataAccess.schoolInfo.get(2));


        //set sem info
        DataAccess.getSemInfo(DataAccess.getIdOfLoggedInUser);
        semester.setText(DataAccess.semesterInfo.get(0));
        academicYear.setText(DataAccess.semesterInfo.get(1));
        nextSemBegins.setText(DataAccess.semesterInfo.get(2));
    }

}
