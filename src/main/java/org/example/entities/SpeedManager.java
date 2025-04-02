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

    private double speedMultiplier;

    public SpeedManager(Player player, HostileEntitySpawner HostileEntitySpawner, PowerUpSpawner powerUpSpawner) {
        super(1000);
        this.PLAYER = player;
        this.HOSTILE_SPAWNER = HostileEntitySpawner;
        this.POWERUP_SPAWNER = powerUpSpawner;

        speedMultiplier = 1;
    }

    @Override
    public void onAnimationUpdate(long l) {
        speedMultiplier += 0.02;
        PLAYER.setSpeedMultiplier(speedMultiplier);
        HOSTILE_SPAWNER.setSpeedMultiplier(speedMultiplier);
        POWERUP_SPAWNER.setSpeedMultiplier(speedMultiplier);
        ParallaxBackground.setAllBackgroundSpeeds(speedMultiplier);
    }
}
