package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmPopUpController {
    @FXML
    public Button popUpAddNewStudent;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button popUpClose;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentFormula.fxml"));
        root = loader.load();

        StudentController studentController = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    private void closePopUp(ActionEvent event){
        Stage stage = (Stage) popUpClose.getScene().getWindow();
        stage.close();

    }
    @FXML
    public void returnToAddStudent(ActionEvent event) throws IOException {
        switchToScene1(event);
    }
}
