package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

public class Trashcan extends Obstacle {
    public Trashcan(Coordinate2D initialLocation, double speed) {
        super("sprites/trashcan.png", initialLocation, speed, 5);
    }
}
