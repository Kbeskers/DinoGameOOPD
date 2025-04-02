package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Sword extends Powerup {
    public Sword(Coordinate2D initialLocation, double speed) {
        super("sprites/zwaard.png", initialLocation, new Size(50, 50), speed);
    }
}
