package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Coin extends Powerup {
    public Coin(Coordinate2D initialLocation, double speed) {
        super("sprites/coin.png", initialLocation, new Size(50, 50), speed);
    }
}
