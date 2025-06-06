package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;
import org.example.entities.hostileEntity.HostileEntity;

public abstract class Obstacle extends HostileEntity {
    protected Obstacle(String resource, Coordinate2D initialLocation, double speed, int damage) {
        super(resource, initialLocation, speed, damage);
    }
}
