package org.example.entities.hostileEntity;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public abstract class HostileEntity extends DynamicSpriteEntity implements Collider, SceneBorderCrossingWatcher {
    private int damage;

    protected HostileEntity(String resource, Coordinate2D initialLocation, double speed, int damage) {
        super(resource, initialLocation);
        setMotion(speed, 270d);
        setAnchorPoint(AnchorPoint.BOTTOM_LEFT);
        this.damage = damage;
    }

    @Override
    public final void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }

    protected final static String getRandomSprite(String sprite1, String sprite2){
        int randomIndex = randomMinMax(0, 1);
        if (randomIndex == 0) {
            return sprite1;
        } else {
            return sprite2;
        }
    }

    private static int randomMinMax(int min, int max) {
        Random rand = new Random();
        return min + (rand.nextInt((max - min) + 1));
    }

    public final int getDamage() {
        return damage;
    }
}
