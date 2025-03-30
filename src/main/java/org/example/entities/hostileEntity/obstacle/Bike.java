package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

public class Bike extends Obstacle {
    public Bike(Coordinate2D initialLocation, int speed) {
        super("sprites/fiets.png", initialLocation, speed);
    }
}
