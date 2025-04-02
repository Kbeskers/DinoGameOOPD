package org.example.entities.sword;

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
        disableHitbox();
    }

    protected void setActive(boolean value) {
        if (value) {
            setHitBoxHigh();
        } else {
            disableHitbox();
        }
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
    private void disableHitbox() {
        setWidth(0);
        setHeight(0);
    }
}
