package org.example.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.powerup.Coin;
import org.example.entities.powerup.Heart;
import org.example.entities.powerup.Powerup;
import org.example.entities.powerup.Sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpSpawner extends EntitySpawner {
    private final DynamicScene GAME_SCENE;
    private final Random random = new Random();
    private final double BASE_SPEED = 2;
    private double speedMultiplier = 1;

    private final double COIN_CHANCE = 0.7;
    private final double HEART_CHANCE = 0.1;
    private final double SWORD_CHANCE = 0.1;

    private final List<Powerup> spawnedEntities = new ArrayList<>();

    public PowerUpSpawner(DynamicScene gameScene) {
        super(1000);
        this.GAME_SCENE = gameScene;
    }

    @Override
    protected void spawnEntities() {
        double rand = random.nextDouble();
        int groundOffset = 100;

        Powerup entity;
        if (rand < COIN_CHANCE) {
            entity = new Coin(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset));
        } else if (rand < COIN_CHANCE + HEART_CHANCE) {
            entity = new Heart(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset));
        } else if (rand < COIN_CHANCE + HEART_CHANCE + SWORD_CHANCE) {
            entity = new Sword(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset));
        } else {
            return;
        }

        spawnedEntities.add(entity);
        spawn(entity);
    }

    private double currentSpeed() {
        return BASE_SPEED * speedMultiplier;
    }

    private double randomDouble(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        for (Powerup entity : spawnedEntities) {
            entity.setMotion(currentSpeed(), Direction.LEFT);
        }
    }
} 