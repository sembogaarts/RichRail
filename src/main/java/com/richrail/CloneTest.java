package com.richrail;

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

        // Create a new Group an Scene
//        Group g1 = this.locomotive(0, 0);
//        Group g2 = this.wagon(150, 0);

        Scene s = new Scene(main, 1000, 1000, Color.WHITE);

        primaryStage.setTitle("RichRail");
        primaryStage.setScene(s);


        primaryStage.show();

        trains = new ArrayList<>();

        Train train = new Train("test");
        Train train1 = new Train("test");
        Wagon wagon1 = new Wagon("adas");
        train1.addWagon(wagon1);
        trains.add(train1);
        train1.addWagon(wagon1);
        trains.add(train);
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        trains.add(train);
                        trains.add(train1);

                        main.getChildren().clear();
                        drawAllTrains();
                    }
                });

            }
        },0,1000);

    }

    private void drawAllTrains() {
        for (int i = 0; i < trains.size(); i++) {
            Train train = trains.get(i);
            System.out.println(train.title);
            main.getChildren().add(train.draw(0, 100 * i));
            for (int j = 0; j < train.getWagons().size(); j++) {
                Wagon wagon = train.getWagons().get(j);
                main.getChildren().add(wagon.draw(140 * j, 100 * i));
            }
        }
    }
}
