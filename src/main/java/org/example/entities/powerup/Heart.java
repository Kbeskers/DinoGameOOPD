package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;

public class Heart extends Powerup {
    public Heart(Coordinate2D initialLocation) {
        super("sprites/heart.png", initialLocation);
    }
}
