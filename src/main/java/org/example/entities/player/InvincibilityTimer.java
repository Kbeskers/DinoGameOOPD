package org.example.entities.player;

import org.example.entities.GeneralOneShotTimer;

public class InvincibilityTimer extends GeneralOneShotTimer {
    private final Player PLAYER;

    public InvincibilityTimer(long intervalInMs, Player player) {
        super(intervalInMs);
        this.PLAYER = player;
    }

    public void timerTriggered() {
        PLAYER.setInvincible(false);
    }
}
