module com.example.minimanagermain {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires GNAvatarView;
    requires com.jfoenix;
    requires javafx.graphics;
    requires mysql.connector.java;
    requires TrayTester;
    requires java.sql;
    requires VirtualizedFX;


    opens com.example.minimanagermain to javafx.fxml;
    exports com.example.minimanagermain;
}