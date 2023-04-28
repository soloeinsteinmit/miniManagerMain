package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.WindowManagement;
import io.github.gleidson28.GNAvatarView;
import io.github.palexdev.materialfx.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserCredentialsController implements Initializable {

    @FXML
    private MFXButton addContactBtn;

    @FXML
    private MFXButton close_white_signUp;

    @FXML
    private MFXTextField contact_acc_id;

    @FXML
    private MFXTextField contact_email;

    @FXML
    private MFXTextField contact_fullName;

    @FXML
    private MFXRadioButton contact_radioBtn_female;

    @FXML
    private MFXRadioButton contact_radioBtn_male;

    @FXML
    private MFXTextField contact_visa_num;

    @FXML
    private MFXTextField current_amt;

    @FXML
    private MFXTextField deposit_amt;

    @FXML
    private MFXDatePicker dobField;

    @FXML
    private Pane dragAreaPane;

    @FXML
    private MFXCheckbox editEmailCheckBox;

    @FXML
    private MFXCheckbox editNameCheckBox;

    @FXML
    private MFXButton loginBtn;

    @FXML
    private MFXButton minimizeBtn;

    @FXML
    private MFXButton registerBtn;

    @FXML
    private MFXTextField user_acc_id;

    @FXML
    private ImageView user_addImage;

    @FXML
    private MFXTextField user_email_address;

    @FXML
    private MFXTextField user_full_name;
    @FXML
    private MFXTextField freeTransfer;

    @FXML
    private Label user_name;

    @FXML
    private GNAvatarView user_profile;

    @FXML
    private MFXRadioButton user_radioBtn_female;

    @FXML
    private MFXRadioButton user_radioBtn_male;

    @FXML
    private MFXTextField user_visa_num;
    @FXML
    private Label getEmailDb;

    @FXML
    private Label getNameDb;

    @FXML
    private Label getVisaNumDb;

    public static MFXButton close;
    public static MFXButton minimize;
    public static Pane movablePane;
    public static GNAvatarView user_prof;
    public static ImageView user_addImg;
    public static MFXButton addContact;
    public static MFXButton logInBtn;
    public static MFXButton registerUserBtn;
    public static MFXTextField contactEmail;
    public static MFXTextField contactName;
    public static MFXTextField contactAccId;
    public static MFXTextField contactVisaNum;
    public static MFXTextField uEmail;
    public static MFXTextField uName;
    public static MFXTextField uAccId;
    public static MFXTextField uVisaNum;
    public static MFXTextField fTransfer;
    public static MFXRadioButton contactMale;
    public static MFXRadioButton contactFemale;
    public static MFXRadioButton userFemale;
    public static MFXRadioButton userMale;
    public static MFXCheckbox editName;
    public static MFXCheckbox editEmail;
    public static MFXDatePicker dob;
    public static String date;
    public static Label userName;
    public static Label get_name_db;
    public static Label get_email_db;
    public static Label get_visa_num_db;
    public static boolean exist;
    private static Parent root;
    public static InputStream iStream;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerUserBtn = registerBtn;      dob = dobField;
        contactEmail = contact_email;       contactName = contact_fullName;
        contactAccId = contact_acc_id;      contactVisaNum = contact_visa_num;
        fTransfer = freeTransfer;           userName = user_name;

        //initializing radio buttons contact
        contactMale = contact_radioBtn_male;        contactFemale = contact_radioBtn_female;
        userMale = user_radioBtn_male;              userFemale = user_radioBtn_female;

        //initializing user textFields
        uEmail = user_email_address;        uName = user_full_name;         uAccId = user_acc_id;
        uVisaNum = user_visa_num;

        // initializing checkboxes
        editName = editNameCheckBox;
        editName.setOnAction(actionEvent -> uName.setAllowEdit(editName.isSelected()));
        editEmail = editEmailCheckBox;
        editEmail.setOnAction(actionEvent -> uEmail.setAllowEdit(editEmail.isSelected()));

        // buttons
        addContact = addContactBtn;         user_addImg = user_addImage;        user_prof = user_profile;
        logInBtn = loginBtn;

        // get data from db labels
        get_email_db = getEmailDb;         get_name_db = getNameDb;      get_visa_num_db = getVisaNumDb;
        getAndSetEmail();                  getAndSetName();              getAndSetVisaNum();

/*        try {
            UserCredentialsDbConnection.getImageIntoDbFileChooser(user_addImg, user_prof);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }*/

        // add contact
        addContact();

        //login button
        login();

        //initializing window management buttons        // window management
        close = close_white_signUp;                     close.setOnAction(WindowManagement::closeWindow);
        minimize = minimizeBtn;                         minimize.setOnAction(WindowManagement::minimizeWindow);
        movablePane = dragAreaPane;                     WindowManagement.movablePane(movablePane);

        // get date
        getDate();

        // register user
        registerUser();


    }

    @FXML
    private void handleOnDragOverUser(DragEvent event){
        if(event.getDragboard().hasFiles()){
            user_addImg.setVisible(false);
            event.acceptTransferModes(TransferMode.ANY);
        }
    }


    @FXML
    private void handleOnDropUser(DragEvent event) throws IOException, SQLException {
//        UserCredentialsDbConnection.getImageIntoDbDragEffect(event, user_prof);
    }

    @FXML
    private void handleOnDragExitUser(DragEvent event){
        if(event.getDragboard().hasFiles()){
            user_addImg.setVisible(true);
        }
    }

    @FXML
    void getFileChooser() throws SQLException {
//        UserCredentialsDbConnection.getImageIntoDbFileChooser(user_prof);
    }

    public void setTextField(MFXTextField email, MFXTextField name, MFXTextField accId){
        uEmail.setText(email.getText());
        uName.setText(name.getText());
        uAccId.setText(accId.getText());
        userName.setText(name.getText());
    }

    private static void registerUser(){
        registerUserBtn.setOnAction(actionEvent -> {
            try {

                String gender = null;
                if (userMale.isSelected()){
                    gender = userMale.getText();
                } else if (userFemale.isSelected()) {
                    gender = userFemale.getText();
                }
                FXMLLoader loader = new FXMLLoader(UserCredentialsController.class.getResource("main_page.fxml"));
                root = loader.load();

                DashboardController userCredential = loader.getController();

                String[] splitName = userName.getText().split(" ");
                String[] firstName = splitName[0].split("");


                userCredential.setUserCredentials2(uName.getText(), firstName[0] + " " + splitName[splitName.length-1],
                        iStream, fTransfer.getText());

                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void getDate(){
        dob.setOnAction(actionEvent -> {
            LocalDate myDate = dob.getValue();
            date = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        });

    }

    public static void addContact(){
        addContact.setOnAction(actionEvent -> {

        });
    }

    public static void login(){
        logInBtn.setOnMouseClicked(event -> {
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

    public static void getAndSetEmail(){
        get_email_db.setOnMouseClicked(mouseEvent -> {

        });
    }

    public static void getAndSetName(){
        get_name_db.setOnMouseClicked(mouseEvent -> {

        });
    }

    public static void getAndSetVisaNum(){
        get_visa_num_db.setOnMouseClicked(mouseEvent -> {

        });
    }

}
