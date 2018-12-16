package com.richrail.domain;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Locomotive implements RollingComponent {
    public String id;
    private int seats = 20;

    public Locomotive() {
    }

    public Locomotive(String id) {
        this.id = id;
    }

    public Locomotive(String id, int seats) {
        this.id = id;
        this.seats = seats;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }
}
