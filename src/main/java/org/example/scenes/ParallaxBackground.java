package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;
import java.util.List;

public class ParallaxBackground extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    private final Size SIZE;
    private final String RESOURCE;
    private final Coordinate2D INITIAL_LOCATION;
    private final GameScene GAME_SCENE;
    private final int VIEW_INDEX;
    private final double BASE_SPEED;
    private double speed;

    private static final List<ParallaxBackground> parallaxlayers = new ArrayList<>();
    private static double SpeedMultiplier = 1.0;

    public ParallaxBackground(final String resource, final Coordinate2D initialLocation, final Size size, final GameScene scene, final int viewIndex, double base_speed) {
        super(resource, initialLocation, size);

        this.RESOURCE = resource;
        this.INITIAL_LOCATION = initialLocation;
        this.SIZE = size;
        this.GAME_SCENE = scene;
        this.VIEW_INDEX = viewIndex;
        this.BASE_SPEED = base_speed;
        this.speed = base_speed;

        setPreserveAspectRatio(false);
        setViewOrder(viewIndex);
        setMotion(speed, Direction.LEFT);
        parallaxlayers.add(this);
    }

    private boolean shouldRemoveBackground() {
        return Math.round(this.getAnchorLocation().getX() / speed) == -(int) (this.SIZE.width() / speed);
    }

    private int calculateWidthInterval() {
        return -(int) ((this.SIZE.width() / speed) /
                ((SIZE.width() / GAME_SCENE.getWidth()) / (((SIZE.width() / GAME_SCENE.getWidth()) - 1))));
    }

    private boolean shouldCreateNewBackground() {
        return Math.round(this.getAnchorLocation().getX() / speed) == calculateWidthInterval();
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT) && shouldCreateNewBackground()) {
            var newLocation = new Coordinate2D(GAME_SCENE.getWidth(), INITIAL_LOCATION.getY());
            var newBackground = new ParallaxBackground(RESOURCE, newLocation, SIZE, GAME_SCENE, VIEW_INDEX, BASE_SPEED);
            newBackground.speed = newBackground.BASE_SPEED * SpeedMultiplier;
            newBackground.setMotion(newBackground.speed, Direction.LEFT);
            GAME_SCENE.addEntity(newBackground);
        }

        if (border.equals(SceneBorder.LEFT) && shouldRemoveBackground()) {
            parallaxlayers.remove(this);
            this.remove();
        }
    }

    public static void setAllBackgroundSpeeds(double speedMultiplier) {
        SpeedMultiplier = speedMultiplier;
        for (ParallaxBackground background : parallaxlayers) {
            background.speed = background.BASE_SPEED * speedMultiplier;
            background.setMotion(background.speed, Direction.LEFT);
        }
    }
}
