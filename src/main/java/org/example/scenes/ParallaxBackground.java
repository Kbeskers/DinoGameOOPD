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
    private double SPEED;
    private final double BASE_SPEED;

    private static final List<ParallaxBackground> instances = new ArrayList<>();
    private static double SpeedMultiplier;

   // private static int totalInstancesCreated = 0;
    public ParallaxBackground(final String resource, final Coordinate2D initialLocation, final Size size, final GameScene scene, final int viewIndex, double base_speed) {
        super(resource, initialLocation, size);

        this.RESOURCE = resource;
        this.INITIAL_LOCATION = initialLocation;
        this.SIZE = size;
        this.GAME_SCENE = scene;
        this.VIEW_INDEX = viewIndex;
        this.BASE_SPEED = base_speed;
        this.SPEED = base_speed;

        setViewOrder(viewIndex);
        setPreserveAspectRatio(false);
        setMotion(SPEED, Direction.LEFT);
        instances.add(this);

        //debugging
//
//        totalInstancesCreated++;
//
//        System.out.println("New Parallax Background loaded!");
//        System.out.println("Total instances created: " + totalInstancesCreated);
//        System.out.println("Current active instances: " + instances.size());
//        System.out.println("Resource: " + resource);
//        System.out.println("----------------------------------------");
    }

    @Override
    public void notifyBoundaryTouching(final SceneBorder border) {
        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / SPEED) == -(int) ((this.SIZE.width() / SPEED) / ((SIZE.width() / GAME_SCENE.getWidth())
                / (((SIZE.width() / GAME_SCENE.getWidth()) - 1))))) {
            var newLocation = new Coordinate2D(GAME_SCENE.getWidth(), INITIAL_LOCATION.getY());
            var newBackground = new ParallaxBackground(RESOURCE, newLocation, SIZE, GAME_SCENE, VIEW_INDEX, BASE_SPEED);
            newBackground.SPEED = newBackground.BASE_SPEED * SpeedMultiplier;
            newBackground.setMotion(newBackground.SPEED, Direction.LEFT);
            GAME_SCENE.addEntity(newBackground);
        }

        if (border.equals(SceneBorder.LEFT) && Math.round(this.getAnchorLocation().getX() / SPEED) == -(int) (this.SIZE.width() / SPEED)) {
            this.remove();
            instances.remove(this);
        }
    }

    public static void setAllSpeeds(double speedMultiplier) {
        SpeedMultiplier = speedMultiplier;
        //System.out.println("SpeedMultiplier: " + instances);

        for (ParallaxBackground background : instances) {
            background.SPEED = background.BASE_SPEED * speedMultiplier;
            background.setMotion(background.SPEED, Direction.LEFT);
        }
    }
}
