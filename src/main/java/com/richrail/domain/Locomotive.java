package com.richrail.domain;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Locomotive implements RollingComponent {
    public String id;

    public Locomotive(String id) {
        this.id = id;
    }

    public Locomotive() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
