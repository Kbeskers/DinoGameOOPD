package org.example.entities;

import com.github.hanyaeger.api.Timer;

public abstract class GeneralTimer extends Timer {
    protected GeneralTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {
        pause();
    }

    public void StartTimer(long duration) {
        setIntervalInMs(duration);
        reset();
        resume();
    }
}
