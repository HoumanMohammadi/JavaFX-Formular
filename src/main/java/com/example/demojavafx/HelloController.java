package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HelloController {


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


    public void initialize(){
        System.out.println("hey");
        firstName.textProperty().addListener(((observableValue, oldValue, newValue) -> {
          errorLine.setText(newValue);
        }));
    }


    @FXML
    public Student createStudent(ActionEvent event){
        Student newStudent;
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
       if (!firstName.getText().isEmpty() && !lastName.getText().isEmpty() && !email.getText().isEmpty() && !courseOfStudies.getText().isEmpty() && !universityName.getText().isEmpty() && acceptBox.isSelected()) {
           Student newStudent = createStudent(event);
           errorLine.setText("you have been added successfully to our Data bank !");
           errorLine.setFill(Color.GREEN);

       } else {
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
        System.out.println("Selected option: " + selectedText);
    }
}