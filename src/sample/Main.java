package sample;

import javafx.application.Application;
import javafx.css.Style;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Button btn = new Button();
        //Border border = new Border();
        btn.setMaxWidth(25);
        btn.setMaxHeight(25);
        btn.setTranslateX(0);
        btn.setTranslateY(-300);
        StackPane layout1 = new StackPane();
        BorderPane root1 = new BorderPane();
        root1.setCenter(btn);
        //root1.setCenter();
        root1.setStyle("-fx-background-color: #0A184F;");
        scene1 = new Scene(root1, 800, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        scene1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                btn.setTranslateX(0);
                btn.setTranslateY(btn.getTranslateY() + 25);
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
