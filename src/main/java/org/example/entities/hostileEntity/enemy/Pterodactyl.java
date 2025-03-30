package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;

public class Pterodactyl extends Enemy {
    public Pterodactyl(Coordinate2D initialLocation, int speed) {
        super("sprites/zwaard.png", initialLocation, speed);
    }
}
