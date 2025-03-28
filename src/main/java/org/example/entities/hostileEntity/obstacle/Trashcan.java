package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

public class Trashcan extends Obstacle {
    protected Trashcan(String resource, Coordinate2D initialLocation, int speed) {
        super("sprites/prullenbak.png", initialLocation, speed);
    }
}
