package org.example.entities.player;

import org.example.entities.GeneralTimer;

public class InvincibilityTimer extends GeneralTimer {
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
