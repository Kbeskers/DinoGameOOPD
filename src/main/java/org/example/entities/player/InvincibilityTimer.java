package org.example.entities.player;

import com.github.hanyaeger.api.Timer;

public class InvincibilityTimer extends Timer {
    private final Player PLAYER;

    public InvincibilityTimer(long intervalInMs, Player player) {
        super(intervalInMs);
        this.PLAYER = player;
    }

    @Override
    public void onAnimationUpdate(long l) {
        PLAYER.setInvincible(false);
        pause();
    }
}
