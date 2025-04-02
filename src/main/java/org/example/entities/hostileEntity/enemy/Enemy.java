package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.SwordItem;
import org.example.entities.hostileEntity.HostileEntity;

import java.util.List;

public abstract class Enemy extends HostileEntity implements Collided {
    protected Enemy(String resource, Coordinate2D initialLocation, double speed, int damage) {
        super(resource, initialLocation, speed, damage);
    }
    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof SwordItem) {
                remove();
            }
        }
    }
}
