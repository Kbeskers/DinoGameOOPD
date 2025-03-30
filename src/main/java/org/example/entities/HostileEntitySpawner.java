package org.example.entities;

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

    private int spawnIntervalMs;
    private int speed;
    private double speedMultiplier;

    public HostileEntitySpawner( DynamicScene gameScene) {
        super(3000);//starting interval

        this.GAME_SCENE = gameScene;
        spawnIntervalMs = 3000;
        speed = 5;
        speedMultiplier = 1;
    }

    @Override
    protected void spawnEntities() {
        int rand = random(0, 3);
        System.out.println(rand);
        switch(rand) {
            case 0:
                spawn(new Pterodactyl(new Coordinate2D(GAME_SCENE.getWidth() - 1, random(200, (int) GAME_SCENE.getHeight())) , speed));
                break;
            case 1:
                spawn(new Bike(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight()) , speed));
                break;
            case 2:
                spawn(new Trashcan(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight()) , speed));
                break;
            case 3:
                spawn(new Car(new Coordinate2D(GAME_SCENE.getWidth() - 1, GAME_SCENE.getHeight()) , speed));
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
    }

    private int random(int min, int max) {
        Random rand = new Random();
        return min + (rand.nextInt ((max - min) + 1));
    }

    // functie om interval in te stellen/aanpassen.
    // setIntervalInMs(long intervalInMs)

}
