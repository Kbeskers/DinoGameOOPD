package org.example.entities.Obstacles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Obstacle extends DynamicSpriteEntity implements Collider, Collided, SceneBorderCrossingWatcher {
    protected Obstacle(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }
}
