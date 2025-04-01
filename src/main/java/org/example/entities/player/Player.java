package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.DinoCommute;
import org.example.entities.hostileEntity.enemy.Pterodactyl;
import org.example.entities.hostileEntity.obstacle.Bike;
import org.example.entities.hostileEntity.obstacle.Car;
import org.example.entities.hostileEntity.obstacle.Trashcan;
import org.example.entities.powerups.Coin;
import org.example.entities.powerups.Heart;
import org.example.entities.powerups.Sword;
import org.example.ui.text.HealthText;
import org.example.ui.text.ScoreText;

import java.util.List;
import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener, Newtonian, UpdateExposer {
    private final DinoCommute GAME;
    private final ScoreText SCORE_TEXT;
    private final HealthText HEALTH_TEXT;
    private PlayerSprite playerSprite;
    private PlayerHitbox playerHitbox;
    private int score = 0;
    private int health = 100;
    private final int MAX_HEALTH = 100;

    private long invicibleDuration;

    private final int ANIMATION_DURATION = 200;
    private double speedMultiplier = 1;


    public Player(Coordinate2D initialLocation, DinoCommute game, ScoreText scoreText, HealthText healthText) {
        super(initialLocation);
        this.GAME = game;
        this.SCORE_TEXT = scoreText;
        this.HEALTH_TEXT = healthText;
    }

    @Override
    protected void setupEntities() {
        this.playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        addEntity(playerSprite);
        this.playerHitbox = new PlayerHitbox(new Coordinate2D(0, 0), this);
        addEntity(playerHitbox);
    }

    public void handleCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof Pterodactyl) {
                takeDamage(25);
            } else if (collider instanceof Bike) {
                takeDamage(10);
            } else if (collider instanceof Car) {
                takeDamage(20);
            } else if (collider instanceof Trashcan) {
                takeDamage(5);
            } else if (collider instanceof Coin) {
                handleCoinCollision();
            } else if (collider instanceof Heart) {
                handleHealthCollision();
            } else if (collider instanceof Sword) {
                handleSwordCollision();
            }
        }
    }

    private void handleCoinCollision() {
        score += 100;
        SCORE_TEXT.setScoreText(score);
    }
    private void handleHealthCollision() {
       setHealth(health + 20);
    }
    private void handleSwordCollision() {

    }

    private void takeDamage(int damage) {
        if (invicibleDuration <= 0) {
            setHealth(health - damage);
            invicibleDuration = 3000;
            setOpacity(0.6);
        }
    }
    private void setHealth(int newHealth){
        if(newHealth > MAX_HEALTH){
            health = MAX_HEALTH;
        } else {
            health = newHealth;
        }
        HEALTH_TEXT.setHealthText(health);
        if(isDead()){
            GAME.setActiveScene(2);
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
        setSprite(set);
        if(set.contains(KeyCode.UP) && isOnGround()){
            setMotion(15,180d);
        }
    }

    private boolean isOnGround(){
        if (getLocationInScene().getY() >= getSceneHeight() - getHeight() - 100) {
            return true;
        } else {
            return false;
        }
    }

    public final void explicitUpdate(long timestamp){
        if (getLocationInScene().getY() > getSceneHeight() - getHeight() - 100){
            setAnchorLocationY(getSceneHeight() - getHeight() - 100);
            setSpeed(0);
        }

    }

    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
        playerSprite.setAnimationSpeed(speedMultiplier);
    }

    private void setSprite(Set<KeyCode> set){
        System.out.print("Player is on ground: " + isOnGround());
        if (set.contains(KeyCode.DOWN) && isOnGround()) {
            playerSprite.setAnimationRow(1);
            playerHitbox.setHitBoxLow();
        } else {
            playerSprite.setAnimationRow(0);
            playerHitbox.setHitBoxHigh();
        }
    }
}
