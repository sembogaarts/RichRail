package com.richrail.models;

import javax.swing.*;
import java.awt.*;

public class Wagon implements RollingComponent {
    private String title;

    public Wagon(String title) {
        this.title = title;
    }

    public void draw(JPanel drawPanel, int offsetLength, int offset) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30 + offsetLength, 80 + offset, 80, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35 + offsetLength, 120 + offset, 20, 20, 20, 20);
        g.fillRoundRect(80 + offsetLength, 120 + offset, 20, 20, 20, 20);
        g.drawString(title, 40 + offsetLength, 105 + offset);
    }
}
