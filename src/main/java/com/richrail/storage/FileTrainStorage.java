package com.richrail.storage;

import com.richrail.domain.Train;

import java.util.List;

public class FileTrainStorage implements TrainStorage {
    public FileTrainStorage(String fileLocation) {

    }

    @Override
    public List<Train> loadTrains() {
        return null;
    }

    @Override
    public void saveTrains(List<Train> trains) {

    }
}
