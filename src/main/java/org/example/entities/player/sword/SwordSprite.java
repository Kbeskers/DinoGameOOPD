package org.example.entities.player.sword;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class SwordSprite extends SpriteEntity {
    protected SwordSprite(Coordinate2D initialLocation) {
        super("sprites/sword.png", initialLocation, new Size(190, 190));
        setVisible(false);
    }
}