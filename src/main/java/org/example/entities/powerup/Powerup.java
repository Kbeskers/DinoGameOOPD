package org.example.entities.powerup;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import org.example.entities.hostileEntity.HostileEntity;
import org.example.entities.player.PlayerHitbox;

import java.util.List;

public abstract class Powerup extends DynamicSpriteEntity implements Collider, Collided {
    protected Powerup(String resource, Coordinate2D initialLocation, double speed) {
        super(resource, initialLocation);
        setMotion(speed, 270d);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    protected Powerup(String resource, Coordinate2D initialLocation, Size size, double speed) {
        super(resource, initialLocation, size);
        setMotion(speed, 270d);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof PlayerHitbox) {
                remove();
            }
        }
    }
}
