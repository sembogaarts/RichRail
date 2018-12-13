package com.richrail.storage;


import com.richrail.domain.Train;

import java.util.List;

public interface TrainStorage {
    List<Train> loadTrains();
    void saveTrains(List<Train> trains);
}