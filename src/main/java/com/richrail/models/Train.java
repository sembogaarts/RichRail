package com.richrail.models;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Train {

    public String title;
    private Locomotive locomotive;
    private ArrayList<Wagon> wagons;

    public Train(String title) {
        this.title = title;
    }

    public void addWagon(Wagon wagon) {
        this.wagons.add(wagon);
    }

    public void draw(JPanel drawPanel, int offset) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30, 80 + offset, 80, 40);
        g.fillRect(80, 60 + offset, 30, 30);
        g.drawRoundRect(85, 40 + offset, 20, 20, 20, 20);
        g.drawRoundRect(85, offset, 40, 40, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35, 120 + offset, 20, 20, 20, 20);
        g.fillRoundRect(80, 120 + offset, 20, 20, 20, 20);
        g.drawString(this.title, 40, 105 + offset);
    }

}
