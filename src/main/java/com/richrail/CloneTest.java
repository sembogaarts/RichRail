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


    }


    public Group locomotive(int x, int y) {

        Group g = new Group();

        // Properties
        int bodyHeight = 60;
        int bodyWidth = 120;
        int pipeHeight = 90;
        int pipeWidth = 50;
        int wheelRadius = 15;
        int wheelOffset = 10;

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(bodyWidth);
        body.setHeight(bodyHeight);
        body.setX(x);
        body.setY(y - (bodyHeight - pipeHeight));
        body.setFill(Color.GREY);

        // Create the pipe
        Rectangle pipe = new Rectangle();
        pipe.setWidth(pipeWidth);
        pipe.setHeight(pipeHeight);

        pipe.setX(x + (bodyWidth - pipeWidth));
        pipe.setY(y);

        pipe.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(wheelRadius);
        frontWheel.setCenterX(x + (wheelRadius + wheelOffset));
        frontWheel.setCenterY(y + pipeHeight);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(wheelRadius);
        backWheel.setCenterX(x + (bodyWidth - wheelRadius - wheelOffset));
        backWheel.setCenterY(y + pipeHeight);
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

        // Properties
        int bodyHeight = 60;
        int bodyWidth = 120;
        int pipeHeight = 90;
        int pipeWidth = 50;
        int wheelRadius = 15;
        int wheelOffset = 10;

        // Create the body
        Rectangle body = new Rectangle();
        body.setWidth(bodyWidth);
        body.setHeight(bodyHeight);
        body.setX(x);
        body.setY(y - (bodyHeight - pipeHeight));
        body.setFill(Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(wheelRadius);
        frontWheel.setCenterX(x + (wheelRadius + wheelOffset));
        frontWheel.setCenterY(y + pipeHeight);
        frontWheel.setFill(Color.BLACK);

        // Create the wheel
        Circle backWheel = new Circle();
        backWheel.setRadius(wheelRadius);
        backWheel.setCenterX(x + (bodyWidth - wheelRadius - wheelOffset));
        backWheel.setCenterY(y + pipeHeight);
        backWheel.setFill(Color.BLACK);

        // Add all to group
        g.getChildren().add(body);
        g.getChildren().add(frontWheel);
        g.getChildren().add(backWheel);

        return g;

    }

}
