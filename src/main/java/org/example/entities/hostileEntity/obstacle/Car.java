package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

public class Car extends Obstacle {
    public Car(Coordinate2D initialLocation, double speed) {
        super(getRandomSprite("sprites/car1.png", "sprites/car2.png"), initialLocation, speed, 20);
    }
}
