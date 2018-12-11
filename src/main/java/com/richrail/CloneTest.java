package com.richrail;

import com.richrail.models.Locomotive;
import com.richrail.models.Train;
import com.richrail.models.Wagon;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class CloneTest extends Application {
    ArrayList<Train> trains;
    Group main;

    @Override
    public void start(Stage primaryStage) throws Exception {

        main = new Group();

        Scene s = new Scene(main, 1000, 1000, Color.WHITE);

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(s);


        primaryStage.show();

        trains = new ArrayList<>();

        Train train1 = new Train("test1");
        Train train2 = new Train("test2");

        Locomotive locomotive = new Locomotive();

        train1.setLocomotive(locomotive);
        train2.setLocomotive(locomotive);

        Wagon wagon1 = new Wagon("adas");
        Wagon wagon2 = new Wagon("adas");
        Wagon wagon3 = new Wagon("adas");

        train1.addWagon(wagon1);
        train1.addWagon(wagon3);
        trains.add(train1);

        train2.addWagon(wagon2);
        trains.add(train2);

        drawAllTrains();

    }

    private void drawAllTrains() {

        for (int i = 0; i < trains.size(); i++) {

            Train train = trains.get(i);

            System.out.println(train.title);

            System.out.println(train.getWagons());

            main.getChildren().add(train.draw(0, 120 * i));

        }

    }
}
