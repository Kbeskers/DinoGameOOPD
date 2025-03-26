package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.DinoCommute;
import org.example.ui.text.ScoreText;
import org.example.ui.text.Text;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Newtonian, Collider, Collided {
    //private HealthText healthText;
    private int health = 100;
    private int maxHealth = 100;
    private ScoreText scoreText;
    private int score = 0;
    private DinoCommute game;

    public Player(String resource, Coordinate2D initialLocation, DinoCommute game, Text scoreText) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
//        for (Collider collider : collidingObject) {
//            if (collider instanceof Enemy) {
//                handleEnemyCollision();
//            } else if (collider instanceof Obstacle) {
//                handleObstacleCollision();
//            } else if (collider instanceof CoinPowerup) {
//                handleCoinCollision();
//            } else if (collider instanceof HealthPowerup) {
//                handleHealthCollision();
//            } else if (collider instanceof SwordPowerup) {
//                handleSwordCollision();
//            }
//        }
    }
    private void handleEnemyCollision() {

    }
    private void handleObstacleCollision() {

    }
    private void handleCoinCollision() {
        score += 100;
    }
    private void handleHealthCollision() {
       setHealth(health + 20);
    }
    private void handleSwordCollision() {

    }

    private void setHealth(int newHealth){
        if(newHealth > maxHealth){
            health = maxHealth;
        } else {
            health = newHealth;
        }
        scoreText.setScoreText(health);
        if(isDead()){

        }
    }
    private boolean isDead(){
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if(set.contains(KeyCode.UP) && isOnGround()){
            setMotion(3,180d);
        } else if(set.contains(KeyCode.DOWN)){
            //set bowing sprite
        } else {
            //set running sprite
        }
    }

    private boolean isOnGround(){
        if (getAnchorLocation().getY() < 200) {
            return true;
        } else {
            return false;
        }
    }
}
