package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final Size size;
    private final String resource;
    private final Coordinate2D initialLocation;
    private final GameScene scene;
    private final int viewIndex;
    private final double speed;

    public ParallaxBackground(final String resource, final Coordinate2D initialLocation, final Size size, final GameScene scene, final int viewIndex, final double speed) {
        super(resource, initialLocation, size);

        this.resource = resource;
        this.initialLocation = initialLocation;
        this.size = size;
        this.scene = scene;
        this.viewIndex = viewIndex;
        this.speed = speed;

        setViewOrder(viewIndex);
        setPreserveAspectRatio(false);
        setMotion(speed, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int) ((this.size.width() / speed) / ((size.width()/scene.getWidth())/(((size.width()/scene.getWidth()) - 1))))) { //formule om de juiste interval tussen het laden van parrallax sprites te berekenen
            var newLocation = new Coordinate2D(scene.getWidth(), initialLocation.getY());
            scene.addEntity(new ParallaxBackground(resource, newLocation, size, scene, viewIndex, speed));
            System.out.println("ParallaxBackground added" + newLocation + getWidth());
        }

        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / speed) == -(int) (this.size.width() / speed)) {
            this.remove();
        }
    }
}
