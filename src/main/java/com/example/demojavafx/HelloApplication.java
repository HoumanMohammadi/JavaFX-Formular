package com.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Das ist neu -> Wir laden die FXML-Datei.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(
                "/com/example/demojavafx/studentFormula.fxml"));

        // Das ist neu -> Wir erstellen eine Scene mit dem root-Node aus der FXML-Datei.
        // Wir bauen die GUI im SceneBuilder und importieren die Szene hier.
        // Scene hat die gleiche Breite und Höhe wie der Top-Container FXML-Datei.
        Scene scene = new Scene(fxmlLoader.load(), 350, 450);

        // Das ist alles gleich!
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
/*    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.web("#a8a839"));

        Text helloWorldText = new Text( "Hello JavaFX");
        helloWorldText.setTextAlignment(TextAlignment.CENTER);
        //helloWorldText.setTextAlignment(TextAlignment.JUSTIFY);
        //helloWorldText.wrappingWidthProperty().bind(scene.widthProperty().subtract(60));
        helloWorldText.setFont(new javafx.scene.text.Font(scene.getWidth()/10));
        helloWorldText.translateXProperty()
                .bind(scene.widthProperty()
                        .divide(2)
                        .subtract(helloWorldText.layoutBoundsProperty().get().getWidth()/2));

        helloWorldText.translateYProperty()
                .bind(scene.heightProperty()
                        .divide(2)
                        .add(helloWorldText.layoutBoundsProperty().get().getHeight()/60));


        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        Stop[] stops = {
                new Stop(0, Color.GREEN),
                new Stop(1, Color.YELLOW)
        };

        // Create a linear gradient fill
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);


        Rectangle rectangle = new Rectangle(20,20,100,100);
        rectangle.widthProperty().bind(scene.widthProperty().subtract(40));
        rectangle.setFill(Color.OLIVE);
        //rectangle.autosize();
        rectangle.setEffect(dropShadow);
        rectangle.setFill(gradient);
        rectangle.setStroke(Color.WHITE);

        root.getChildren().add(helloWorldText);
        root.getChildren().add(rectangle);

        stage.setMinWidth(300);
        stage.setMinHeight(300);
        stage.setMaxWidth(900);
        stage.setMaxHeight(900);

        stage.setTitle("Hello without Fxml!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    }*/
