package com.example.minimanagermain;

import com.example.minimanagermain.OtherClasses.DataAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private TextField accademicYear;

    @FXML
    private TextField className;

    @FXML
    private TextField newPassword;

    @FXML
    private DatePicker newSemesterDate;

    @FXML
    private TextField oldPassword;

    @FXML
    private TextField postalAddress;

    @FXML
    private TextField schName;

    @FXML
    private TextField semesterNum;

    @FXML
    private TextField teacherNameField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    DataAccess dataAccess = new DataAccess();
    @FXML
    void saveSchoolInfo(ActionEvent event) throws SQLException {
        dataAccess.updateSchoolInfo(DataAccess.getIdOfLoggedInUser, teacherNameField.getText(),
                className.getText(), postalAddress.getText());
    }

    @FXML
    void saveSemInfo(ActionEvent event) throws SQLException {
        dataAccess.updateSemInfo(DataAccess.getIdOfLoggedInUser, accademicYear.getText(),
                semesterNum.getText(), newSemesterDate.getAccessibleText());
    }

    @FXML
    void updateName(ActionEvent event) throws SQLException{
        dataAccess.updateTeacherName(DataAccess.getIdOfLoggedInUser, teacherNameField.getText());
    }

    @FXML
    void updatePassword(ActionEvent event) throws SQLException{
        dataAccess.changePassword(DataAccess.getIdOfLoggedInUser, oldPassword.getText(), newPassword.getText());
    }
}
