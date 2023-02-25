/*
package com.example.minimanagermain;

import io.github.gleidson28.GNAvatarView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

*/
/**
 * @author Solomon Einstein MIT Eshun
 * *//*



public class BankingSystemController implements Initializable {

    @FXML
    private ImageView addImage;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView otherImgView;

    @FXML
    private MFXButton addImaggeBtn;

    @FXML
    private MFXTextField enterNameTextField;

    @FXML
    private MFXTextField nameTextfield;

    @FXML
    private GNAvatarView receiveImage;

    @FXML
    private GNAvatarView retrieveImage;

    @FXML
    private MFXButton retrieveImgBtn;

    @FXML
    private Label retrievedName;
    @FXML
    private Text text;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            TestImageDBConnection.getImageIntoDbFileChooser(addImage, receiveImage, otherImgView);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }


        retrieveImgBtn.setOnAction(e -> {
            try {
                TestImageDBConnection.retrieveImageFromDb(enterNameTextField.getText(), retrievedName, retrieveImage);
                profile.setVisible(false);
            } catch (SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        addImaggeBtn.setOnAction(e -> {
            try {

                TestImageDBConnection.insertName(nameTextfield.getText());
                System.out.println(nameTextfield.getText() + " name");
                nameTextfield.clear();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            text.setText("There is a text here hurray");
        });



    }


    @FXML
    private void handleOnDragOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            addImage.setVisible(false);
            event.acceptTransferModes(TransferMode.ANY);
        }
    }


    @FXML
    private void handleOnDrop(DragEvent event) throws IOException, SQLException {
        */
/*
        List<File> files = event.getDragboard().getFiles();


        File file = new File(String.valueOf(files.get(0)));
        FileInputStream fileInputStream = new FileInputStream(file);

        System.out.println(fileInputStream);

        Image image = new Image(fileInputStream);
        receiveImage.setImage(image);
        *//*

//        TestImageDBConnection.getImageIntoDbDragEffect(event, receiveImage);
    }

    @FXML
    private void handleOnDragExit(DragEvent event){
        if(event.getDragboard().hasFiles()){
            addImage.setVisible(true);
        }
    }
}*/
