package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    public Button startButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    public void startRegistration(ActionEvent event) {
        try {
            switchToScene2(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
