package org.example.entities;

import com.github.hanyaeger.api.Timer;

public abstract class GeneralOneShotTimer extends Timer {
    protected GeneralOneShotTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {
        timerTriggered();
        pause();
    }

    public final void StartTimer(long duration) {
        setIntervalInMs(duration);
        reset();
        resume();
    }
    public abstract void timerTriggered();
}
