package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    Scene scene1;
    public ArrayList<Button> list;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Rectangle r1 = new Rectangle(0,0,300,600);
        r1.setStroke(Color.WHITE);
        r1.setFill(null);
        r1.setTranslateX(15);
        r1.setTranslateY(-75);
        r1.setStrokeWidth(1);

        Button start = new Button("Start");
        start.setMaxWidth(100);
        start.setMaxHeight(50);
        start.setTranslateY(-350);
        start.setTranslateX(-350);

         list = generate();

        StackPane layout1 = new StackPane();
        BorderPane root1 = new BorderPane();
        //root1.setTop(start);
        layout1.getChildren().addAll(list);
        layout1.getChildren().add(start);
        layout1.getChildren().add(r1);
        layout1.setStyle("-fx-background-color: #0A184F;");

        scene1 = new Scene(layout1, 800, 800);
        primaryStage.setScene(scene1);
        primaryStage.show();

        scene1.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.D) {
                double higher = -120;
                for (Button b1: list ) {
                    if(b1.getTranslateX() > higher){
                        higher = b1.getTranslateX();
                        System.out.println(higher);
                    }
                }

                for (Button b : list) {
                    if(higher != 150) {
                        b.setTranslateX(b.getTranslateX() + 30);
                    }
                }
            }
            if (e.getCode() == KeyCode.A) {
                double lower = 150;
                for (Button b2: list ) {
                    if(b2.getTranslateX() < lower){
                        lower = b2.getTranslateX();
                    }
                }

                for (Button b : list) {
                    if(lower != -120) {
                        b.setTranslateX(b.getTranslateX() - 30);
                    }
                }
            }

            if (e.getCode() == KeyCode.S) {
                double higherY = -400;
                for (Button b3: list ) {
                    if(b3.getTranslateY() > higherY){
                        higherY = b3.getTranslateY();
                    }
                }
                System.out.println(higherY);
                for (Button b : list) {
                    if(higherY != 210) {

                        b.setTranslateY(b.getTranslateY() + 30);
                    }
                }

                if(higherY == 210){
                    list = generate();
                    layout1.getChildren().addAll(list);
                }
            }
        });



        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task<Void> task = new Task<Void>() {
                    @Override
                    public Void call() throws Exception {
                        while(true) {
                            double higherY = -400;
                            while (true) {
                                for (Button b3 : list) {
                                    if (b3.getTranslateY() > higherY) {
                                        higherY = b3.getTranslateY();
                                    }
                                }
                                Thread.sleep(200);
                                System.out.println(higherY);
                                for (Button b : list) {
                                    if (higherY != 210) {
                                        b.setTranslateY(b.getTranslateY() + 30);
                                    }
                                }

                                if (higherY >= 210) {
                                    break;
                                }
                            }
                            
                            list = generate();
                            layout1.getChildren().addAll(list);

                            for (int i = 0; i < 5; i++) {

                            }
                            break;
                        }

                            return null;

                    }
                };
                new Thread(task).start();
            }
        });




    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Button> generate(){
        int x = 30;
        int y = 30;
        String bordercolor = "-fx-border-color: #"+  rColor() +";";
        System.out.println(rColor());
        String color = "-fx-background-color: #" + rColor() + ";";
        Button btn = new Button();
        btn.setStyle(color + "" + bordercolor);
        btn.setMaxWidth(30);
        btn.setMaxHeight(30);
        btn.setTranslateX(0);
        btn.setTranslateY(-360);
        //btn.setDisable(true);

        Button btn1 = new Button();
        btn1.setStyle(color + "" + bordercolor);
        btn1.setMaxWidth(30);
        btn1.setMaxHeight(30);
        btn1.setTranslateX(30);
        btn1.setTranslateY(-360);
        //btn1.setDisable(true);

        Button btn2 = new Button();
        btn2.setStyle(color + "" + bordercolor);
        btn2.setMaxWidth(30);
        btn2.setMaxHeight(30);
        btn2.setTranslateX(0);
        btn2.setTranslateY(-330);
        //btn2.setDisable(true);

        Button btn3 = new Button();
        btn3.setStyle(color + "" + bordercolor);
        btn3.setMaxWidth(30);
        btn3.setMaxHeight(30);
        btn3.setTranslateX(30);
        btn3.setTranslateY(-330);
        //btn3.setDisable(true);

        ArrayList<Button> list = new ArrayList();
        list.add(btn);
        list.add(btn1);
        list.add(btn2);
        list.add(btn3);

        return list;
    }

    public static String rColor(){

        String result = "";

        Random r1 = new Random();
        Random r2 = new Random();
        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            int y = r2.nextInt(2);
            if(y == 1){
                result += r1.nextInt(10);
            }else{
                result+= (char)(r.nextInt(5) + 'a');
            }

        }
        return result;
    }
}
