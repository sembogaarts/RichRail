package com.richrail.models;

import javafx.scene.Group;

public interface RollingComponent {

    int wheels = 4;

    Group draw(int x, int y);

}
