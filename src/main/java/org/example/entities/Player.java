package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.DinoCommute;
import org.example.ui.text.Text;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Newtonian, Collider, Collided {
    private HealthText healthText;
    private int health = 10;
    private ScoreText scoreText;
    private int score = 0;
    private DinoCommute game;

    public Player(String resource, Coordinate2D initialLocation, DinoCommute game, Text scoreText) {
        super(resource, initialLocation);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof Enemy) {
                handleEnemyCollision();
            } else if (collider instanceof Obstacle) {
                handleObstacleCollision();
            } else if (collider instanceof CoinPowerup) {
                handleCoinCollision();
            } else if (collider instanceof HealthPowerup) {
                handleHealthCollision();
            } else if (collider instanceof SwordPowerup) {
                handleSwordCollision();
            }
        }

        if (coinPowerupCollision) {
            scoreText.setBubbleText(100);
        }
        if (enemyCollision) {
            healthText.setHealthText(--health);

            if (isDead()) {
                pause();
                //set game over overlay
            }
        }
    }
    private void handleEnemyCollision() {}
    private void handleObstacleCollision() {}
    private void handleCoinCollision() {}
    private void handleHealthCollision() {}
    private void handleSwordCollision() {}


    private boolean isDead(){
        if (health <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }
}
