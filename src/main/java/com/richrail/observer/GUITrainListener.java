package com.richrail.observer;

import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.factory.RollingComponentDrawableFactory;
import com.richrail.gui.drawable.RollingComponentDrawable;
import javafx.scene.Group;

public class GUITrainListener implements TrainListener {
    private RollingComponentDrawableFactory rollingComponentDrawableFactory;
    private Group main;

    public GUITrainListener(RollingComponentDrawableFactory rollingComponentDrawableFactory, Group main) {
        this.rollingComponentDrawableFactory = rollingComponentDrawableFactory;
        this.main = main;
    }

    @Override
    public void onChanged(RichRail richRail) {
        main.getChildren().clear();

        for (int i = 0; i < richRail.getTrains().size(); i++) {
            Train train = richRail.getTrain(i);
            Group trainGroup = new Group();

            // Offsets
            int offsetX = 160;
            int offsetY = 120 * i;

            // Draw the rollingcompontents
            for (int j = 0; j < train.getRollingComponents().size(); j++) {
                RollingComponent rollingComponent = train.getRollingComponents().get(j);
                RollingComponentDrawable rollingComponentDrawable = rollingComponentDrawableFactory.getRollingComponentDrawable(rollingComponent);

                Group rollingCompontentGroup = rollingComponentDrawable.draw(offsetX * (j + 1), offsetY);

                trainGroup.getChildren().add(rollingCompontentGroup);
            }

            main.getChildren().add(trainGroup);
        }
    }
}
