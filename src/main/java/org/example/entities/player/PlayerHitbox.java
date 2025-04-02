package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collider, Collided {
    private final Player PLAYER;
    private final double WIDTH = 200;
    private final double HEIGHT = 200;

    public PlayerHitbox(Coordinate2D initialLocation, Player player) {
        super(initialLocation);
        this.PLAYER = player;
        setFill(Color.TRANSPARENT);
        setHitBoxHigh();
    }

    protected void setHitBoxLow() {
        setAnchorLocationY(HEIGHT / 2);
        setWidth(WIDTH);
        setHeight(HEIGHT / 2);
    }

    protected void setHitBoxHigh() {
        setAnchorLocationY(0);
        setWidth(WIDTH);
        setHeight(HEIGHT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        PLAYER.handleCollision(collidingObject);
    }
}
