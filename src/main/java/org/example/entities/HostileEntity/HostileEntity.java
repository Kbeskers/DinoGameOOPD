package org.example.entities.HostileEntity;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public abstract class HostileEntity extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    protected HostileEntity(String resource, Coordinate2D initialLocation, int speed) {
        super(resource, initialLocation);
        setSpeed(speed);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
