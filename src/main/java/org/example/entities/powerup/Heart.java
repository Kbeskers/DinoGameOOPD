package org.example.entities.powerup;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Heart extends Powerup {
    public Heart(Coordinate2D initialLocation, double speed) {
        super("sprites/heart.png", initialLocation, new Size(50, 50), speed);
    }
}
