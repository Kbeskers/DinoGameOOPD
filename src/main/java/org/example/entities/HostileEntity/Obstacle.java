package org.example.entities.HostileEntity;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public abstract class Obstacle extends HostileEntity {
    protected Obstacle(String resource, Coordinate2D initialLocation, int speed) {
        super(resource, initialLocation, speed);
    }
}
