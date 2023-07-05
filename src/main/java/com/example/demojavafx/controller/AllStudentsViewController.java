package com.example.demojavafx.controller;


import com.example.demojavafx.model.Student;
import com.example.demojavafx.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class AllStudentsViewController {
    @FXML
    public Button deleteStudentButton;
    @FXML
    private ListView<Student> listView;
    @FXML
    private Text text;
    @FXML
    private Button editStudentButton;

    private StudentService studentService = StudentService.getInstance();

    public void initialize() {
        // Hier stellen wir die Daten der ListView ein
        //  listView.getItems() = Liste der Elemente aus listView holen
        // .addAll() = Elemente zur Liste hinzufügen
        listView.getItems().addAll(studentService.getAllStudents());

        listView.getSelectionModel()
                .selectedItemProperty()
                // Listener der etwas macht
                .addListener(
                        (observableValue, s, t1) -> {if (listView.getSelectionModel().getSelectedItem()!= null){
                            text.setText(listView.getSelectionModel().getSelectedItem().firstName() + " " + listView.getSelectionModel().getSelectedItem().lastName());
                            editStudentButton.setDisable(false);
                            deleteStudentButton.setDisable(false);


                        }
                    }
                );
    }
    @FXML

    public void deleteSelectedStudent() throws IOException, InterruptedException {
        studentService.deleteStudent(listView.getSelectionModel().getSelectedItem().matriculationNumber());
        listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
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
    public void switchToRegistrationViewEditSelectedStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/update-view.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UpdateViewController updateViewController = loader.getController();
        updateViewController.setStudentDataInFields(listView.getSelectionModel().getSelectedItem());

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    public void switchToRegistrationViewCreateNewStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/registration-view.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
}