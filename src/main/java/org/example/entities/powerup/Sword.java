package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Sword extends Powerup {
    public Sword(Coordinate2D initialLocation, double speed) {
        super("sprites/sword.png", initialLocation, new Size(70, 70), speed);
    }
}
