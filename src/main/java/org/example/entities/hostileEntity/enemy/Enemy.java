package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.example.entities.hostileEntity.HostileEntity;

import java.util.List;

public abstract class Enemy extends HostileEntity implements Collided {
    protected Enemy(String resource, Coordinate2D initialLocation, int speed) {
        super(resource, initialLocation, speed);
    }
    @Override
    public void onCollision(List<Collider> collidingObject) {
        //implement collision code that detects if player has sword power-up
        //for (Collider collider : collidingObject) {
            //if (collider instanceof Sword) {
                //handleSwordCollision();
    }
    private void handleSwordCollision() {
        remove();
    }
}
