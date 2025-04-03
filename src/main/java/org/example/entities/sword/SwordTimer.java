package org.example.entities.sword;

import org.example.entities.GeneralTimer;

public class SwordTimer extends GeneralTimer {
    private final SwordItem SWORD;

    public SwordTimer(long intervalInMs, SwordItem sword) {
        super(intervalInMs);
        this.SWORD = sword;
    }

    @Override
    public void onAnimationUpdate(long l) {
        SWORD.setSwordActive(false);
        pause();
    }
}
