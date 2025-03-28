package org.example.entities.powerups;

import com.github.hanyaeger.api.Coordinate2D;

public class Coin extends Powerup {
    public Coin(Coordinate2D initialLocation) {
        super("sprites/munt.png", initialLocation);
    }
}
