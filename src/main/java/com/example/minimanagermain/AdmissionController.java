package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.AlertNotification;
import com.example.minimanagermain.OtherClasses.DataAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import tray.notification.NotificationType;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdmissionController implements Initializable {

    @FXML
    private RadioButton femaleGender;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton maleGender;

    @FXML
    private TextField parentNumber;

    @FXML
    private DatePicker stuDateOfBirth;

    @FXML
    private TextField stuEmail;

    @FXML
    private TextField stuName;

    @FXML
    private TextField stuNumber;

    @FXML
    private TextField stuParent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Register(ActionEvent event) throws SQLException {
        DataAccess dataAccess = new DataAccess();
        String gender = null;
        if (femaleGender.isSelected()){
            gender = "Female";
        }else {
            gender = "Male";
        }
        if (stuName.getText().isEmpty() || stuDateOfBirth.getAccessibleText().isEmpty() ||
                parentNumber.getText().isEmpty() || stuEmail.getText().isEmpty() || stuParent.getText().isEmpty() ||
                parentNumber.getText().isEmpty()){

            AlertNotification.trayNotification("ADMISSION ERROR", "PLEASE FILL IN ALL THE FORMS",
                    3, NotificationType.ERROR);


        }else {
            dataAccess.admitStudent(stuName.getText(), stuDateOfBirth.getAccessibleText(), parentNumber.getText(),
                    stuEmail.getText(), gender, stuParent.getText(), parentNumber.getText());
            AlertNotification.trayNotification("ADMISSION SUCCESSFUL", "YOU HAVE SUCCESSFULLY ADMITTED A USER",
                    3, NotificationType.SUCCESS);
        }



    }
}
