package org.example.entities;

import com.github.hanyaeger.api.Timer;
import org.example.entities.player.Player;
import org.example.entities.spawner.HostileEntitySpawner;
import org.example.entities.spawner.PowerUpSpawner;
import org.example.scenes.ParallaxBackground;

public class SpeedManager extends Timer {
    private final Player PLAYER;
    private final HostileEntitySpawner HOSTILE_SPAWNER;
    private final PowerUpSpawner POWERUP_SPAWNER;
    private final ScoreManager SCORE_MANAGER;

    private double speedMultiplier;

    public SpeedManager(Player player, HostileEntitySpawner HostileEntitySpawner, PowerUpSpawner powerUpSpawner, ScoreManager scoreManager) {
        super(1000);
        this.PLAYER = player;
        this.HOSTILE_SPAWNER = HostileEntitySpawner;
        this.POWERUP_SPAWNER = powerUpSpawner;
        this.SCORE_MANAGER = scoreManager;

        speedMultiplier = 1;
    }

    @Override
    public void onAnimationUpdate(long l) {
        speedMultiplier += 0.02;
        PLAYER.setSpeedMultiplier(speedMultiplier);
        HOSTILE_SPAWNER.setSpeedMultiplier(speedMultiplier);
        POWERUP_SPAWNER.setSpeedMultiplier(speedMultiplier);
        ParallaxBackground.setAllBackgroundSpeeds(speedMultiplier);

        double pointsToAddDouble = 0.02 * speedMultiplier * speedMultiplier + 1;
        int pointsToAdd = (int) pointsToAddDouble;
        SCORE_MANAGER.addPoints(pointsToAdd);
    }
}
