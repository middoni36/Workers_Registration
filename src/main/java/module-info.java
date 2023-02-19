module com.example.registration_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jdk.xml.dom;
    requires java.compiler;


    opens com.example.registration_app to javafx.fxml;
    exports com.example.registration_app;
}