package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;

public class Pterodactyl extends Enemy {
    public Pterodactyl(Coordinate2D initialLocation, double speed) {
        super("sprites/pterodactyl.png", initialLocation, speed);
    }
}
