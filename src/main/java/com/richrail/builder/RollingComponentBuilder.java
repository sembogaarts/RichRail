package com.richrail.builder;

import com.richrail.domain.RollingComponentType;
import com.richrail.domain.Locomotive;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Wagon;

public class RollingComponentBuilder {
    private RollingComponent newRollingComponent;

    public RollingComponentBuilder() {

    }

    public RollingComponentBuilder setType(RollingComponentType rollingComponentType) {
        if (rollingComponentType.equals(RollingComponentType.LOCOMOTIVE)) {
            newRollingComponent = new Locomotive();
        } else if (rollingComponentType.equals(RollingComponentType.WAGON)) {
            newRollingComponent = new Wagon();
        }

        return this;
    }

    public RollingComponentBuilder setId(String id) {
        newRollingComponent.setId(id);

        return this;
    }


    public RollingComponentBuilder setSeats(int seats) {
        newRollingComponent.setSeats(seats);

        return this;
    }

    public RollingComponent build() {
        return newRollingComponent;
    }

}
