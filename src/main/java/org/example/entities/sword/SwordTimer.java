package org.example.entities.sword;

import com.github.hanyaeger.api.Timer;

public class SwordTimer extends Timer {
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
