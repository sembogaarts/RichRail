package com.richrail.domain;

import javafx.scene.Group;

import java.util.ArrayList;

public class Train {
    private ArrayList<RollingComponent> rollingComponents = new ArrayList<>();


    public Train() {
    }

    public ArrayList<RollingComponent> getRollingComponents() {
        return rollingComponents;
    }

    public void setRollingComponents(ArrayList<RollingComponent> rollingComponents) {
        this.rollingComponents = rollingComponents;
    }

    public void addRollingComponent(RollingComponent rollingComponent) {
        rollingComponents.add(rollingComponent);
    }


    public void removeLastRollingComponent() {
        rollingComponents.remove(rollingComponents.size() - 1);
    }

}
