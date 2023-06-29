package com.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
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
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)   {
        try {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(
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
