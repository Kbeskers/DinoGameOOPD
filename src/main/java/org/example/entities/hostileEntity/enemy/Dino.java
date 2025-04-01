package org.example.entities.hostileEntity.enemy;

import com.github.hanyaeger.api.Coordinate2D;

import java.util.Random;

public class Dino extends Enemy {
    public Dino(Coordinate2D initialLocation, double speed) {
        super(getRandomDinoSprite(), initialLocation, speed);
    }
    private static String getRandomDinoSprite(){
        int randomIndex = random(0, 1);
        System.out.println(randomIndex);
        if (randomIndex == 0) {
            return "sprites/dino1.png";
        } else {
            return "sprites/dino2.png";
        }
    }
    private static int random(int min, int max) {
        Random rand = new Random();
        return min + (rand.nextInt ((max - min) + 1));
    }
}