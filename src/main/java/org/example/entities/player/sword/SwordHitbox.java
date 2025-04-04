package org.example.entities.player.sword;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class SwordHitbox extends RectangleEntity implements Collider {
    private final double WIDTH = 200;
    private final double HEIGHT = 200;

    public SwordHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.TRANSPARENT);
        setActive(false);
    }

    protected void setActive(boolean value) {
        if (value) {
            setWidth(WIDTH);
            setHeight(HEIGHT);
        } else {
            setWidth(0);
            setHeight(0);
        }
    }
}
