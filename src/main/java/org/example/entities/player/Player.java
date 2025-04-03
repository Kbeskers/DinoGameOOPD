package org.example.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.DinoCommute;
import org.example.entities.ScoreManager;
import org.example.entities.hostileEntity.HostileEntity;
import org.example.entities.sword.SwordItem;
import org.example.entities.powerup.Coin;
import org.example.entities.powerup.Heart;
import org.example.entities.powerup.Sword;
import org.example.scenes.GameScene;
import org.example.ui.text.HealthText;
import org.example.ui.text.ScoreText;
import org.example.ui.text.HighScoreText;

import java.util.List;
import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener, Newtonian, UpdateExposer, TimerContainer {
    private final DinoCommute GAME;
    private final ScoreText SCORE_TEXT;
    private final HealthText HEALTH_TEXT;
    private PlayerSprite playerSprite;
    private PlayerHitbox playerHitbox;
    private InvincibilityTimer invincibilityTimer;
    private SwordItem swordItem;
    private final ScoreManager SCORE_MANAGER;
    private final GameScene GAME_SCENE;

    private int score = 0;
    private int health = 100;
    private final int MAX_HEALTH = 100;
    private boolean invincible;

    public Player(Coordinate2D initialLocation, DinoCommute game, ScoreText scoreText, HealthText healthText, HighScoreText highScoreText, GameScene GameScene) {
        super(initialLocation);
        this.GAME = game;
        this.SCORE_TEXT = scoreText;
        this.HEALTH_TEXT = healthText;
        this.SCORE_MANAGER = new ScoreManager(scoreText, highScoreText);
        this.GAME_SCENE = GameScene;
    }

    @Override
    public void setupTimers() {
        this.invincibilityTimer = new InvincibilityTimer(1000, this);
        addTimer(invincibilityTimer);
    }

    @Override
    protected void setupEntities() {
        this.playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        addEntity(playerSprite);
        this.playerHitbox = new PlayerHitbox(new Coordinate2D(0, 0), this);
        addEntity(playerHitbox);
        this.swordItem = new SwordItem(new Coordinate2D(0, 0), 5000);
        addEntity(swordItem);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        setAnimation(set);
        if ((set.contains(KeyCode.UP) || set.contains(KeyCode.SPACE)) && isOnGround()) {
            setMotion(15, 180d);
        }
    }

    public void handleCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof HostileEntity) {
                takeDamage(((HostileEntity) collider).getDamage());
            } else if (collider instanceof Coin) {
                pickupCoin();
            } else if (collider instanceof Heart) {
                pickupHeart();
            } else if (collider instanceof Sword) {
                pickupSword();
            }
        }
    }

    protected void takeDamage(int damage) {
        if (!invincible) {
            setHealth(health - damage);
            setInvincible(true);
            invincibilityTimer.StartTimer(2000);
        }
    }

    private void pickupCoin() {
        SCORE_MANAGER.addPoints(100);
    }

    private void pickupHeart() {
        setHealth(health + 20);
    }

    private void pickupSword() {
        swordItem.setSwordActive(true);
    }

    protected void setInvincible(boolean state) {
        invincible = state;
        if (state) {
            setOpacity(0.6);
        } else {
            setOpacity(1);
        }
    }

    private void setHealth(int newHealth) {
        if (newHealth > MAX_HEALTH) {
            health = MAX_HEALTH;
        } else {
            health = newHealth;
        }
        HEALTH_TEXT.setHealthText(health);
        if (isDead()) {
            GAME_SCENE.showEndScene();
        }
    }

    private void setAnimation(Set<KeyCode> set) {
        if (set.contains(KeyCode.DOWN) && isOnGround()) {
            playerSprite.setAnimationRow(1);
            playerHitbox.setHitBoxLow();
        } else {
            playerSprite.setAnimationRow(0);
            playerHitbox.setHitBoxHigh();
        }
    }

    public void setSpeedMultiplier(double speedMultiplier) {
        playerSprite.setAnimationSpeed(speedMultiplier);
    }

    //CHECKS
    private boolean isDead() {
        if (health <= 0) {
            return true;
        }
        return false;
    }

    private boolean isOnGround() {
        if (getLocationInScene().getY() >= getSceneHeight() - getHeight() - 100) {
            return true;
        }
        return false;
    }

    //Called every GWU
    public final void explicitUpdate(long timestamp) {
        if (getLocationInScene().getY() > getSceneHeight() - getHeight() - 100) {
            setAnchorLocationY(getSceneHeight() - getHeight() - 100);
            setSpeed(0);
        }
    }
}