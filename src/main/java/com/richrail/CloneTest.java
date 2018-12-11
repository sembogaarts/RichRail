package com.richrail;

import com.richrail.models.Train;
import com.richrail.models.Wagon;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class CloneTest extends Application {
    ArrayList<Train> trains;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group main = new Group();

        // Create a new Group an Scene
        Group g1 = this.locomotive(0, 0);
        Group g2 = this.wagon(150, 0);


        main.getChildren().add(g1);
        main.getChildren().add(g2);
        Scene s = new Scene(main, 300, 300, Color.WHITE);
//        main.getChildren().clear();

        primaryStage.setTitle("RichRail");


        primaryStage.setScene(s);


        primaryStage.show();

        trains = new ArrayList<>();

        Train train = new Train("test");
        Train train1 = new Train("test");
        Wagon wagon1 = new Wagon("adas");
        train1.addWagon(wagon1);
        train1.addWagon(wagon1);
        trains.add(train);
        trains.add(train);
        trains.add(train);
        trains.add(train1);
        trains.add(train);
        trains.add(train1);
        drawAllTrains();

    }

    private void drawAllTrains() {
        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);
            System.out.println(train.title);
            train.draw(x,y);

            for (int j = 0; j < train.getWagons().size(); j++) {
                int numberOfWagons = j;
                Wagon wagon = train.getWagons().get(j);
                wagon.draw(drawPanel, numberOfWagons * TRAINLENGTH, j * OFFSET);
            }
        }
    }


    public Group locomotive(int x, int y) {

        Group g = new Group();

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(120);
        body.setHeight(60);
        body.setX(x);
        body.setY(y);
        body.setFill(Color.GREY);

        // Create the pipe
        Rectangle pipe = new Rectangle();
        pipe.setWidth(50);
        pipe.setHeight(90);
        pipe.setX(x + 70);
        pipe.setY(y - 40);
        pipe.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(15);
        frontWheel.setCenterX(x + 25);
        frontWheel.setCenterY(y + 75);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(15);
        backWheel.setCenterX(x + 85);
        backWheel.setCenterY(y + 75);
        backWheel.setFill(Color.BLACK);

        // Add all to group
        g.getChildren().add(body);
        g.getChildren().add(pipe);
        g.getChildren().add(frontWheel);
        g.getChildren().add(backWheel);

        return g;

    }

    public Group wagon(int x, int y) {


        Group g = new Group();

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(120);
        body.setHeight(60);
        body.setX(x);
        body.setY(y);
        body.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(15);
        frontWheel.setCenterX(x + 25);
        frontWheel.setCenterY(y + 75);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(15);
        backWheel.setCenterX(x + 85);
        backWheel.setCenterY(y + 75);
        backWheel.setFill(Color.BLACK);

        // Add all to group
        g.getChildren().add(body);
        g.getChildren().add(frontWheel);
        g.getChildren().add(backWheel);

        return g;

    }

}
