package com.richrail.gui.drawable;

import com.richrail.domain.RollingComponent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LocomotiveDrawable implements RollingComponentDrawable {
    private RollingComponent rollingComponent;

    public LocomotiveDrawable(RollingComponent rollingComponent) {
        this.rollingComponent = rollingComponent;
    }

    @Override
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
        Rectangle body = new javafx.scene.shape.Rectangle();
        body.setWidth(bodyWidth);
        body.setHeight(bodyHeight);
        body.setX(x);
        body.setY(y - (bodyHeight - pipeHeight));
        body.setFill(javafx.scene.paint.Color.GREY);

        // Create the pipe
        Rectangle pipe = new Rectangle();
        pipe.setWidth(pipeWidth);
        pipe.setHeight(pipeHeight);

        pipe.setX(x + (bodyWidth - pipeWidth));
        pipe.setY(y);

        pipe.setFill(javafx.scene.paint.Color.GREY);

        // Add the name
        Text name = new Text();
        name.setText(this.rollingComponent().getId());
        name.setX(x);
        name.setY(y + 25);

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
        g.getChildren().add(name);

        return g;
    }

    @Override
    public RollingComponent rollingComponent() {
        return rollingComponent;
    }
}
