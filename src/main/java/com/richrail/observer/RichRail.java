package com.richrail.observer;

import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;

import java.util.ArrayList;
import java.util.List;

public class RichRail {
    private List<Train> trains = new ArrayList<>();
    private List<TrainListener> listeners = new ArrayList<>();

    public RichRail() {
    }

    public void registerTrainListener(TrainListener listener) {
        this.listeners.add(listener);
    }

    public void unregisterTrainListener(TrainListener listener) {
        // Remove the listener from the list of the registered listeners
        this.listeners.remove(listener);
    }

    protected void notifyTrainListeners() {
        // Notify each of the listeners in the list of registered listeners
        this.listeners.forEach(listener -> listener.onChanged(this));
    }

    public void addTrain(Train train) {
        this.trains.add(train);
        this.notifyTrainListeners();
    }

    public void addAllTrains(List<Train> trains) {
        this.trains = trains;
        this.notifyTrainListeners();
    }

    public Train getTrain(int i) {
        return trains.get(i);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void removeTrain(int i) {
        trains.remove(i);
        this.notifyTrainListeners();
    }

    public void addRollingComponentToTrain(int index, RollingComponent rollingComponent) {
        trains.get(index).addRollingComponent(rollingComponent);
        this.notifyTrainListeners();
    }

    public void removeLastRollingComponentOrTrain(int index) {
        Train train = getTrain(index);
        train.removeLastRollingComponent();
        if (train.getRollingComponents().isEmpty()) {
            removeTrain(index);
        }
        this.notifyTrainListeners();
    }
}
