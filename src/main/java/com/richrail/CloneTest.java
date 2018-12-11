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


public class CloneTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {



        // Create a new Group an Scene
        Group g1 = this.locomotive();
        Group g2 = this.wagon();



        Scene s = new Scene(g1, 300, 300, Color.WHITE);



        primaryStage.setTitle("RichRail");





        primaryStage.setScene(s);




        primaryStage.show();



    }


    public Group locomotive() {

        Group g = new Group();

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(120);
        body.setHeight(60);
        body.setX(0);
        body.setY(40);
        body.setFill(Color.GREY);

        // Create the pipe
        Rectangle pipe = new Rectangle();
        pipe.setWidth(50);
        pipe.setHeight(90);
        pipe.setX(70);
        pipe.setY(0);
        pipe.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(15);
        frontWheel.setCenterX(25);
        frontWheel.setCenterY(115);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(15);
        backWheel.setCenterX(85);
        backWheel.setCenterY(115);
        backWheel.setFill(Color.BLACK);

        // Add all to group
        g.getChildren().add(body);
        g.getChildren().add(pipe);
        g.getChildren().add(frontWheel);
        g.getChildren().add(backWheel);

        return g;

    }

    public Group wagon() {


        Group g = new Group();

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(120);
        body.setHeight(60);
        body.setX(0);
        body.setY(40);
        body.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(15);
        frontWheel.setCenterX(25);
        frontWheel.setCenterY(115);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(15);
        backWheel.setCenterX(85);
        backWheel.setCenterY(115);
        backWheel.setFill(Color.BLACK);

        // Add all to group
        g.getChildren().add(body);
        g.getChildren().add(frontWheel);
        g.getChildren().add(backWheel);

        return g;

    }

}
