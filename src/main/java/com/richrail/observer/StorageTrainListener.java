package com.richrail.observer;

import com.richrail.storage.TrainStorage;

public class StorageTrainListener implements TrainListener {
    private TrainStorage trainStorage;

    public StorageTrainListener(TrainStorage trainStorage) {
        this.trainStorage = trainStorage;
    }

    @Override
    public void onChanged(RichRail richRail) {
        trainStorage.saveTrains(richRail.getTrains());
    }
}
