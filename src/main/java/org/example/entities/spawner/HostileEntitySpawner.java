package org.example.entities.spawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.entities.hostileEntity.enemy.Pterodactyl;
import org.example.entities.hostileEntity.obstacle.Bike;
import org.example.entities.hostileEntity.obstacle.Car;
import org.example.entities.hostileEntity.obstacle.Trashcan;

import java.util.Random;

public class HostileEntitySpawner extends EntitySpawner {
    private final DynamicScene GAME_SCENE;
    private final Random random = new Random();
    private final double BASE_SPEED = 5;
    private double speedMultiplier = 1;

    private static final double PTERODACTYL_CHANCE = 0.25;
    private static final double BIKE_CHANCE = 0.25;
    private static final double TRASHCAN_CHANCE = 0.4;
    private static final double CAR_CHANCE = 0.1;


    public HostileEntitySpawner(DynamicScene gameScene) {
        super(3000);//starting interval
        this.GAME_SCENE = gameScene;
    }

    @Override
    protected void spawnEntities() {
        double rand = random.nextDouble();
        double currentSpeed = BASE_SPEED * speedMultiplier;
        int groundOffset = 100;
        System.out.println(rand);

        if (rand < PTERODACTYL_CHANCE) {
            spawn(new Pterodactyl(new Coordinate2D(GAME_SCENE.getWidth() - 1, randomDouble(200, GAME_SCENE.getHeight())), currentSpeed));
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE) {
            spawn(new Bike(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed));
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE) {
            spawn(new Trashcan(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed));
        } else if (rand < PTERODACTYL_CHANCE + BIKE_CHANCE + TRASHCAN_CHANCE + CAR_CHANCE) {
            spawn(new Car(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight() - groundOffset), currentSpeed));
        }
    }

    private double randomDouble(double min, double max) {
        return min + (random.nextDouble() * (max - min));
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }
}
