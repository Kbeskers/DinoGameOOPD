package org.example.entities.hostileEntity.obstacle;

import com.github.hanyaeger.api.Coordinate2D;

import java.util.Random;

public class Car extends Obstacle {
    public Car(Coordinate2D initialLocation, double speed) {
        super(getRandomCarSprite(), initialLocation, speed);
    }

    private static String getRandomCarSprite(){
        int randomIndex = random(0, 1);
        //System.out.println(randomIndex);
        if (randomIndex == 0) {
            return "sprites/auto1.png";
        } else {
            return "sprites/auto2.png";
        }
    }
    private static int random(int min, int max) {
        Random rand = new Random();
        return min + (rand.nextInt ((max - min) + 1));
    }
}
