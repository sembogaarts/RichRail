package com.richrail.observer;

import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.gui.LoggerGUI;

public class RichRailLogger extends RichRail {
    private LoggerGUI loggerGUI;

    public RichRailLogger(LoggerGUI loggerGUI) {
        this.loggerGUI = loggerGUI;
    }

    @Override
    public void addTrain(Train newTrain) {
        super.addTrain(newTrain);
        loggerGUI.addInputText("[Train] new train added");
    }

    @Override
    public void addRollingComponentToTrain(int index, RollingComponent rollingComponent) {
        super.addRollingComponentToTrain(index, rollingComponent);
        loggerGUI.addInputText("[Train] added to rollingComponent " + rollingComponent.getId());
    }

    @Override
    public int getSeatsById(String name) {
        int number = super.getSeatsById(name);
        if (number == 0) {
            loggerGUI.addInputText("[ " + name + " ] is niet gevonden");
        } else {
            loggerGUI.addInputText("[ " + name + " ] number of seats: " + number);
        }
        return number;
    }

    @Override
    public void removeTrainById(String id) {
        super.removeTrainById(id);
        showRemovedLog();
    }

    @Override
    public void removeTrain(int i) {
        super.removeTrain(i);
        showRemovedLog();
    }

    @Override
    public void removeLastRollingComponentOrTrain(int index) {
        super.removeLastRollingComponentOrTrain(index);
        showRemovedLog();
    }

    @Override
    public void removeRollingComponentFromTrain(String id) {
        super.removeRollingComponentFromTrain(id);
        showRemovedLog();
    }

    private void showRemovedLog() {
        loggerGUI.addInputText("A RollingComponent has been removed");
    }
}
