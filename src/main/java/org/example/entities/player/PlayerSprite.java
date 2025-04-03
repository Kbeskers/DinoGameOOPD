package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlayerSprite extends DynamicSpriteEntity {
    private final int ANIMATION_DURATION = 200;

    public PlayerSprite(Coordinate2D initialLocation) {
        super("sprites/dinoAnimation.png", initialLocation, 2, 8);
        setAutoCycle(ANIMATION_DURATION);
        setAutoCycleRow(0);
    }

    protected void setAnimationSpeed(double speedMultiplier) {
        setAutoCycle((long) (ANIMATION_DURATION / speedMultiplier));
    }

    protected void setAnimationRow(int row) {
        setAutoCycleRow(row);
    }

}