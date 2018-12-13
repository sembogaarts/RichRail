package com.richrail.models;

import javafx.scene.Group;

import java.util.ArrayList;

public class Train {
    public Locomotive locomotive;
    private ArrayList<Wagon> wagons = new ArrayList<>();

    public Train(Locomotive locomotive, ArrayList<Wagon> wagons) {
        this.locomotive = locomotive;
        this.wagons = wagons;
    }

    public Train() {
    }


    public void addWagon(Wagon wagon) {
        this.wagons.add(wagon);
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public Group draw(int x, int y) {

        // Offsets
        int offsetX = 160;

        // Create a new group for the train
        Group g = new Group();

        // Draw the locomotive
        Group locomotiveGroup = this.locomotive.draw(x, y);

        // Add the locomotive
        g.getChildren().add(locomotiveGroup);

        // Loop trough all the wagons and add them
        for (int j = 0; j < this.wagons.size(); j++) {
            // Get the wagon
            Wagon wagon = this.wagons.get(j);
            // Draw the wagon and add it
            Group wagonGroup = wagon.draw(offsetX * (j + 1), y);
            g.getChildren().add(wagonGroup);
        }

        return g;

    }

    public void removeLastWagon() {
        wagons.remove(wagons.size() - 1);
    }
}
