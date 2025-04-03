package org.example.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.powerup.Coin;
import org.example.entities.powerup.Heart;
import org.example.entities.powerup.Powerup;
import org.example.entities.powerup.Sword;

public class PowerUpSpawner extends GeneralSpawner {
    private final double COIN_CHANCE = 0.8;
    private final double HEART_CHANCE = 0.1;
    private final double SWORD_CHANCE = 0.1;

    public PowerUpSpawner(DynamicScene gameScene) {
        super(1000, gameScene);
    }

    @Override
    protected void spawnEntities() {
        double rand = random.nextDouble();
        int groundOffset = 100;

        Powerup entity;
        if (rand < COIN_CHANCE) {
            entity = new Coin(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else if (rand < COIN_CHANCE + HEART_CHANCE) {
            entity = new Heart(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else if (rand < COIN_CHANCE + HEART_CHANCE + SWORD_CHANCE) {
            entity = new Sword(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else {
            return;
        }

        spawnedEntities.add(entity);
        spawn(entity);
    }
} 