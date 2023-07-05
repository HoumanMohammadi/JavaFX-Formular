module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fasterxml.jackson.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    opens com.example.demojavafx to javafx.fxml;
    exports com.example.demojavafx;
    exports com.example.demojavafx.controller;
    opens com.example.demojavafx.controller to javafx.fxml;
    opens com.example.demojavafx.model to com.fasterxml.jackson.databind;
    opens com.example.demojavafx.service to com.fasterxml.jackson.databind;
    exports com.example.demojavafx.model;
    exports com.example.demojavafx.service;

}