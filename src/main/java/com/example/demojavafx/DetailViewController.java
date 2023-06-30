package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class DetailViewController {
    private StudentController studentController= StudentController.getInstance();

    public void setStudentDataInFields(Student studentToEdit) {
        firstNameColumn.setText(studentToEdit.firstName());
        lastNameColumn.setText(studentToEdit.lastName());
        emailColumn.setText(studentToEdit.email());
        courseColumn.setText(studentToEdit.courseOfStudies());
        universityColumn.setText(studentToEdit.universityName());
    }

    private Stage stage;

    private Scene scene;

    private Parent root;
    @FXML
    public TableColumn firstNameColumn;
    @FXML
    public TableColumn lastNameColumn;
    @FXML
    public TableColumn courseColumn;
    @FXML
    public TableColumn emailColumn;
    @FXML
    public TableColumn universityColumn;

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentFormula.fxml"));
        root = loader.load();

        StudentController studentController = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    public void returnToAddStudent(ActionEvent event) throws IOException {
        switchToScene2(event);
    }
}
