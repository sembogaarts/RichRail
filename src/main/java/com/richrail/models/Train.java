package com.richrail.models;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.util.ArrayList;

public class Train {

    public String title;
    private Locomotive locomotive;
    private ArrayList<Wagon> wagons;

    public Train(String title) {
        this.title = title;
        this.wagons = new ArrayList<>();
    }

    public void addWagon(Wagon wagon) {
        this.wagons.add(wagon);
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public Group draw(int x, int y) {
        Group g = new Group();

        // Properties
        int bodyHeight = 60;
        int bodyWidth = 120;
        int pipeHeight = 90;
        int pipeWidth = 50;
        int wheelRadius = 15;
        int wheelOffset = 10;

        // Create the body
        javafx.scene.shape.Rectangle body = new javafx.scene.shape.Rectangle();
        body.setWidth(bodyWidth);
        body.setHeight(bodyHeight);
        body.setX(x);
        body.setY(y - (bodyHeight - pipeHeight));
        body.setFill(javafx.scene.paint.Color.GREY);

        // Create the pipe
        javafx.scene.shape.Rectangle pipe = new Rectangle();
        pipe.setWidth(pipeWidth);
        pipe.setHeight(pipeHeight);

        pipe.setX(x + (bodyWidth - pipeWidth));
        pipe.setY(y);

        pipe.setFill(javafx.scene.paint.Color.GREY);

        // Create the wheel
        Circle frontWheel = new Circle();
        frontWheel.setRadius(wheelRadius);
        frontWheel.setCenterX(x + (wheelRadius + wheelOffset));
        frontWheel.setCenterY(y + pipeHeight);
        frontWheel.setFill(javafx.scene.paint.Color.BLACK);

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

}
