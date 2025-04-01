package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SwordItem extends DynamicSpriteEntity implements Collider {
    public SwordItem(Coordinate2D initialLocation) {
        super("sprites/zwaard.png", initialLocation);
    }

    //Write code to delete after x seconds
    //needs different class for equipped sword, since player will delete normal sword power-up upon pickup
}
