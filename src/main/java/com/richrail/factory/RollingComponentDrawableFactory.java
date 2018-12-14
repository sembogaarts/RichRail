package com.richrail.factory;

import com.richrail.domain.Locomotive;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Wagon;
import com.richrail.gui.drawable.LocomotiveDrawable;
import com.richrail.gui.drawable.RollingComponentDrawable;
import com.richrail.gui.drawable.WagonDrawable;

public class RollingComponentDrawableFactory {
    public RollingComponentDrawable getRollingComponentDrawable(RollingComponent rollingComponent) {
        RollingComponentDrawable rollingComponentDrawable = null;
        if (rollingComponent instanceof Wagon) {
            rollingComponentDrawable = new WagonDrawable(rollingComponent);
        } else if (rollingComponent instanceof Locomotive) {
            rollingComponentDrawable = new LocomotiveDrawable(rollingComponent);
        }

        return rollingComponentDrawable;
    }
}
