package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;

public class Dino extends Enemy {
    public Dino(Coordinate2D initialLocation, double speed) {
        super(getRandomSprite("sprites/enemyDino1.png", "sprites/enemyDino2.png"), initialLocation, speed + 1, 40);
    }
}