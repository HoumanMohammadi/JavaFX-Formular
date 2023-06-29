package com.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentApplication extends Application {
    @Override
    public void start(Stage stage)   {
        try {

        FXMLLoader fxmlLoader = new FXMLLoader(StudentApplication.class.getResource(
                "/com/example/demojavafx/studentFormula.fxml"));
          Scene scene = new Scene(fxmlLoader.load());

            //String css = this.getClass().getResource("/com/example/demojavafx/application.css").toExternalForm();
            //scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.show();
        }catch(Exception e) {
        e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
