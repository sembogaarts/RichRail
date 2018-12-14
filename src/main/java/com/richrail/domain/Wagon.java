package com.richrail.domain;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Wagon implements RollingComponent {
    private String id;

    public Wagon(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
