package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

import java.util.Random;

public class Car extends Obstacle {
    public Car(Coordinate2D initialLocation, double speed) {
        super(getRandomSprite("sprites/auto1.png", "sprites/auto2.png"), initialLocation, speed, 20);
    }
}
