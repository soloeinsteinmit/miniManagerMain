module com.example.minimanagermain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minimanagermain to javafx.fxml;
    exports com.example.minimanagermain;
}