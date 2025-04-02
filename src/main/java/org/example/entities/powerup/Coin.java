package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;

public class Coin extends Powerup {
    public Coin(Coordinate2D initialLocation) {
        super("sprites/coin.png", initialLocation);
    }
}
