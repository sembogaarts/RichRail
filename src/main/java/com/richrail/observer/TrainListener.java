package com.richrail.observer;

import com.richrail.domain.Train;

public interface TrainListener {
    void onChanged(RichRail richRail);
}

