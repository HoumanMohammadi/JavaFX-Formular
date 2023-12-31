package com.example.demojavafx.controller;


import com.example.demojavafx.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationConfirmationViewController {

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label courseOfStudiesLabel;

    private Student selectedStudent;

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;

        firstNameLabel.setText(selectedStudent.firstName());
        lastNameLabel.setText(selectedStudent.lastName());
        emailLabel.setText(selectedStudent.email());
        courseOfStudiesLabel.setText(selectedStudent.courseOfStudies());
    }

    @FXML
    public void switchToWelcomeView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/welcome-view.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    public void switchToRegistrationView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/registration-view.fxml"));
        Parent root = loader.load();

        RegistrationViewController registrationViewController = loader.getController();
        registrationViewController.setStudentDataInFields(selectedStudent);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    public void switchToAllStudentsView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/all-students-view.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
}