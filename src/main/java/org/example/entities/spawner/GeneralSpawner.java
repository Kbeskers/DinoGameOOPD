package org.example.entities.spawner;

import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.hostileEntity.HostileEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class GeneralSpawner extends EntitySpawner {
    protected final DynamicScene GAME_SCENE;
    protected final Random random = new Random();
    protected final double BASE_SPEED = 2;
    protected double speedMultiplier = 1;

    protected final List<DynamicSpriteEntity> spawnedEntities = new ArrayList<>();

    protected GeneralSpawner(long intervalInMs, DynamicScene gameScene) {
        super(intervalInMs);
        this.GAME_SCENE = gameScene;
    }

    @Override
    protected abstract void spawnEntities();

    protected double getCurrentSpeed() {
        return BASE_SPEED * speedMultiplier;
    }

    protected double randomDouble(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        for (DynamicSpriteEntity entity : spawnedEntities) {
            entity.setMotion(getCurrentSpeed(), Direction.LEFT);
        }
    }
}
