package com.example.demojavafx;

import javafx.collections.ObservableList;
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
import java.util.Arrays;
import java.util.List;

import static com.example.demojavafx.EmailValidator.isValidEmail;

public class StudentController {

    private static StudentController instance;
    private List<Student> students;

    public List<Student> getAllStudents() {
        return students;
    }

    public static synchronized StudentController getInstance() {
        if (instance == null) {
            instance = new StudentController();
        }
        return instance;
    }


    @FXML
    public Button resetButton;
    @FXML
    public Button addButton;
    @FXML
    public Button backButton;
    @FXML
    public Button deleteButton;
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
    public void switchToScene3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailView.fxml")); // Jeweiliges FXML laden
        root = loader.load();

        DetailViewController detailViewController  = loader.getController(); // Jeweiligen Controller laden

        Student studentData= new Student(firstName.getText(), lastName.getText(), universityName.getText(), email.getText(), courseOfStudies.getText());
        detailViewController.setStudentDataInFields(studentData);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene); // Neue Szenen setzen
        stage.show(); // ... und einblenden
    }

    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("welcomePage.fxml")); // Jeweiliges FXML laden
        root = loader.load();

        WelcomeController welcomeController = loader.getController(); // Jeweiligen Controller laden


        //addButton.getScene().setUserData(createStudent(event));

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
    private ListView<String> listStudent;

//    private ObservableList<Student> items;
    public void initialize() {


        // Set the ObservableList as the data source for the ListView
//        listStudent.setItems(items);

        // Add a listener to the ListView to detect the selected item
//        listStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Perform any desired action when the selection changes
//        });

    }


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
           listStudent.getItems().add(newStudent.firstName()+" "+newStudent.lastName());
           //System.out.println(listStudent);
/*           try {
               switchToScene3(event);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }*/

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

    @FXML
    public void backTotheWelcome(ActionEvent event) {
        try {
            switchToScene1(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void deleteStudent(ActionEvent event) {
        String selectedStudent = listStudent.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            listStudent.getItems().remove(selectedStudent);
        }
    }

    public void detailview(ActionEvent event) {
        try {
            switchToScene3(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}