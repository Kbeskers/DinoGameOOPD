package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final Size SIZE;
    private final String RESOURCE;
    private final Coordinate2D INITIAL_LOCATION;
    private final GameScene GAME_SCENE;
    private final int VIEW_INDEX;
    private final double SPEED;

    public ParallaxBackground(final String resource, final Coordinate2D initialLocation, final Size size, final GameScene scene, final int viewIndex, final double speed) {
        super(resource, initialLocation, size);

        this.RESOURCE = resource;
        this.INITIAL_LOCATION = initialLocation;
        this.SIZE = size;
        this.GAME_SCENE = scene;
        this.VIEW_INDEX = viewIndex;
        this.SPEED = speed;

        setViewOrder(viewIndex);
        setPreserveAspectRatio(false);
        setMotion(speed, Direction.LEFT);
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / SPEED) == -(int) ((this.SIZE.width() / SPEED) / ( (SIZE.width()/ GAME_SCENE.getWidth())
                / ( ((SIZE.width()/ GAME_SCENE.getWidth())  - 1) )))) { //formule om de juiste interval tussen het laden van parrallax sprites te berekenen
            var newLocation = new Coordinate2D(GAME_SCENE.getWidth(), INITIAL_LOCATION.getY());
            GAME_SCENE.addEntity(new ParallaxBackground(RESOURCE, newLocation, SIZE, GAME_SCENE, VIEW_INDEX, SPEED));
            System.out.println("ParallaxBackground added" + newLocation + getWidth());
        }

        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / SPEED) == -(int) (this.SIZE.width() / SPEED)) {
            this.remove();
        }
    }
}