package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demojavafx.EmailValidator.isValidEmail;

public class StudentController {


    @FXML
    private CheckBox acceptBox;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField courseOfStudies;
    @FXML
    private SplitMenuButton universityName;
    @FXML
    private Text errorLine;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmPopUp.fxml")); // Jeweiliges FXML laden
        root = loader.load();

        ConfirmPopUpController confirmPopUpController = loader.getController(); // Jeweiligen Controller laden

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene); // Neue Szenen setzen
        stage.show(); // ... und einblenden
    }


/*    public void initialize(){

        firstName.textProperty().addListener(((observableValue, oldValue, newValue) -> {
          errorLine.setText(newValue);
        }));
    }*/


    @FXML
    public Student createStudent(ActionEvent event) {
        Student newStudent = null;
            newStudent = new Student(
                    firstName.getText(),
                    lastName.getText(),
                    email.getText(),
                    courseOfStudies.getText(),
                    universityName.getText());


        System.out.println(newStudent);
        return newStudent;
    }


   @FXML
    public void addButton(ActionEvent event) {
       if (!firstName.getText().isEmpty() && !lastName.getText().isEmpty() && isValidEmail(email.getText()) && !courseOfStudies.getText().isEmpty() && !universityName.getText().isEmpty() && acceptBox.isSelected()) {
           Student newStudent = createStudent(event);
           errorLine.setText("you have been added successfully to our Data bank !");
           errorLine.setFill(Color.GREEN);
           try {
               switchToScene2(event);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

       } else if (!isValidEmail(email.getText())){
           errorLine.setText("Email not Valid !");
           errorLine.setFill(Color.RED);
       }else {
           errorLine.setText("please fill all the fields !");
           errorLine.setFill(Color.RED);
       }
   }


    @FXML
    public void resetButton(ActionEvent e) {
        firstName.clear();
        lastName.clear();
        email.clear();
        courseOfStudies.clear();
        universityName.setText("--Select--");
        acceptBox.setSelected(false);
    }

    @FXML
    private void handleOptionSelection(ActionEvent event) {
        MenuItem selectedOption = (MenuItem) event.getSource();
        String selectedText = selectedOption.getText();
        universityName.setText(selectedText); // Update the button text
    }
}