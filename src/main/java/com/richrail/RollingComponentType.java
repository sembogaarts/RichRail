package com.richrail;

import com.richrail.domain.Locomotive;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.domain.Wagon;

import java.io.Serializable;

public enum RollingComponentType implements Serializable {
    WAGON("wagon"),
    LOCOMOTIVE("locomotive"),
    UNKNOWN("unkown");

    private String type;

    RollingComponentType(String type) {
        this.type = type;
    }

    public static RollingComponentType getTypeByInstance(RollingComponent rollingComponent) {
        if (rollingComponent instanceof Locomotive) {
            return LOCOMOTIVE;
        } else if (rollingComponent instanceof Wagon) {
            return WAGON;
        }
        return UNKNOWN;
    }

    public static RollingComponentType getTypeByText(String type) {
        for (RollingComponentType rollingComponentType : values()) {
            if (rollingComponentType.getType().equals(type)) {
                return rollingComponentType;
            }
        }
        return UNKNOWN;
    }

    public String getType() {
        return type;
    }
}