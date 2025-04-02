package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;

import java.util.Random;

public class Dino extends Enemy {
    public Dino(Coordinate2D initialLocation, double speed) {
        super(getRandomSprite("sprites/Vijandige_dino1.png", "sprites/Vijandige_dino2.png"), initialLocation, speed + 1, 40);
    }
}