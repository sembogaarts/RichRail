package com.richrail.gui.drawable;

import com.richrail.domain.RollingComponent;
import javafx.scene.Group;

public interface RollingComponentDrawable {
    Group draw(int x, int y);

    RollingComponent rollingComponent();
}
