package org.example.entities.hostileEntity;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class HostileEntity extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    protected HostileEntity(String resource, Coordinate2D initialLocation, int speed) {
        super(resource, initialLocation);
        setMotion(speed, 270d);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
