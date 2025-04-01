package org.example.entities;

import com.github.hanyaeger.api.Timer;
import org.example.entities.player.Player;
import org.example.scenes.ParallaxBackground;

public class SpeedManager extends Timer {
    private final Player PLAYER;
    //private final ParalaxBackground BACKGROUND;
    private final HostileEntitySpawner SPAWNER;

    private double speedMultiplier;

    public SpeedManager(Player player, HostileEntitySpawner spawner) {
        super(1000);
        this.PLAYER = player;
        this.SPAWNER = spawner;

        speedMultiplier = 1;
    }

    @Override
    public void onAnimationUpdate(long l) {
        speedMultiplier += 0.02;
        PLAYER.setSpeedMultiplier(speedMultiplier);
        SPAWNER.setSpeedMultiplier(speedMultiplier);
        ParallaxBackground.setAllSpeeds(speedMultiplier);
    }
}
