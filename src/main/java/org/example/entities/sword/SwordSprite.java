package org.example.entities.sword;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SwordSprite extends SpriteEntity {
    protected SwordSprite(Coordinate2D initialLocation) {
        super("sprites/zwaard.png", initialLocation);
        setVisible(false);
    }
}
