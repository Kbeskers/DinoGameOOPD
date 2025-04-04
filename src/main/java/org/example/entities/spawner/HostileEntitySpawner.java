package org.example.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.hostileEntity.HostileEntity;
import org.example.entities.hostileEntity.enemy.Dino;
import org.example.entities.hostileEntity.enemy.Pterodactyl;
import org.example.entities.hostileEntity.obstacle.Bike;
import org.example.entities.hostileEntity.obstacle.Car;
import org.example.entities.hostileEntity.obstacle.Trashcan;

public class HostileEntitySpawner extends GeneralSpawner {
    private final double PTERODACTYL_CHANCE = 0.25;
    private final double DINO_CHANCE = 0.25;
    private final double BIKE_CHANCE = 0.25;
    private final double TRASHCAN_CHANCE = 0.15;
    private final double CAR_CHANCE = 0.10;

    public HostileEntitySpawner(DynamicScene gameScene) {
        super(3000, gameScene);
    }

    @Override
    protected void spawnEntities() {
        double rand = random.nextDouble();
        int groundOffset = 100;

        HostileEntity entity;
        if (rand < PTERODACTYL_CHANCE) {
            entity = new Pterodactyl(new Coordinate2D(GAME_SCENE.getWidth() - 1, randomDouble(500, GAME_SCENE.getHeight())), getCurrentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE) {
            entity = new Bike(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE) {
            entity = new Trashcan(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE + CAR_CHANCE) {
            entity = new Car(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE + CAR_CHANCE + DINO_CHANCE) {
            entity = new Dino(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), getCurrentSpeed());
        } else {
            return;
        }
        if (!(entity instanceof Pterodactyl) && !(entity instanceof Dino)) {
            spawnedEntities.add(entity);
        }
        spawn(entity);
    }
}
