package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmPopUpController {

/*
    private Student newStudent;
    public void setStudent(Student newStudent){
        this.newStudent=newStudent;
    }

    public void initialize(URL url, ResourceBundle rb){
        firstNameConfirm.setText(newStudent.firstName());
    }
*/


    StudentController studentController= new StudentController();
    @FXML
    public Button popUpAddNewStudent;
    @FXML
    public AnchorPane PopUpAnchor;
    @FXML
    public Text firstNameConfirm;
    @FXML
    public Text lastNameConfirm;
    @FXML
    public Text emailConfirm;
    @FXML
    public Text courseOfStudiesConfirm;
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
    private void closePopUp(ActionEvent event){
        Stage stage = (Stage) popUpClose.getScene().getWindow();
        stage.close();

    }
    @FXML
    public void returnToAddStudent(ActionEvent event) throws IOException {
        switchToScene2(event);
    }

}
