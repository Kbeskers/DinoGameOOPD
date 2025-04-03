package org.example.entities.sword;

import org.example.entities.GeneralOneShotTimer;

public class SwordTimer extends GeneralOneShotTimer {
    private final SwordItem SWORD;

    public SwordTimer(long intervalInMs, SwordItem sword) {
        super(intervalInMs);
        this.SWORD = sword;
    }

    public void timerTriggered() {
        SWORD.setSwordActive(false);
    }
}
