package org.example.entities.sword;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class SwordItem extends DynamicCompositeEntity implements TimerContainer {
    private SwordSprite swordSprite;
    private SwordHitbox swordHitbox;
    private SwordTimer swordTimer;
    private final long DURATION;

    public SwordItem(Coordinate2D initialLocation, long duration) {
        super(initialLocation);
        this.DURATION = duration;
    }

    @Override
    protected void setupEntities() {
        this.swordSprite = new SwordSprite(new Coordinate2D(80, 0));
        addEntity(swordSprite);
        this.swordHitbox = new SwordHitbox(new Coordinate2D(80, 0));
        addEntity(swordHitbox);
    }

    @Override
    public void setupTimers() {
        this.swordTimer = new SwordTimer(DURATION, this);
        addTimer(swordTimer);
    }

    public void setSwordActive(boolean value){
        if (value){
            swordTimer.StartTimer(DURATION);
        }
        swordSprite.setVisible(value);
        swordHitbox.setActive(value);
    }
}
