package org.example.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.hostileEntity.HostileEntity;
import org.example.entities.hostileEntity.enemy.Pterodactyl;
import org.example.entities.hostileEntity.obstacle.Bike;
import org.example.entities.hostileEntity.obstacle.Car;
import org.example.entities.hostileEntity.obstacle.Trashcan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HostileEntitySpawner extends EntitySpawner {
    private final DynamicScene GAME_SCENE;
    private final Random random = new Random();
    private final double BASE_SPEED = 2;
    private double speedMultiplier = 1;

    private final double PTERODACTYL_CHANCE = 0.25;
    private final double BIKE_CHANCE = 0.25;
    private final double TRASHCAN_CHANCE = 0.4;
    private final double CAR_CHANCE = 0.1;

    private final List<HostileEntity> spawnedEntities = new ArrayList<>();

    public HostileEntitySpawner(DynamicScene gameScene) {
        super(3000);//starting interval
        this.GAME_SCENE = gameScene;
    }


    @Override
    protected void spawnEntities() {
        double rand = random.nextDouble();
        int groundOffset = 100;
        System.out.println(rand);

        HostileEntity entity;
        if (rand < PTERODACTYL_CHANCE) {
            entity = new Pterodactyl(new Coordinate2D(GAME_SCENE.getWidth() - 1, randomDouble(200, GAME_SCENE.getHeight())), currentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE) {
            entity = new Bike(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE) {
            entity = new Trashcan(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE + CAR_CHANCE) {
            entity = new Car(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed());
        } else {
            return;
        }
        if (!(entity instanceof Pterodactyl)) {
        spawnedEntities.add(entity);
        }
        spawn(entity);

    }

    private double currentSpeed() {
        return BASE_SPEED * speedMultiplier;
    };

    private double randomDouble(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        for (HostileEntity entity : spawnedEntities) {
            entity.setMotion(currentSpeed(), Direction.LEFT);
        }
    }
}
