package org.example.scenes;

import com.github.hanyaeger.api.*;
import javafx.scene.image.Image;
import org.example.entities.Entityspawner;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.DinoCommute;
import org.example.entities.HostileEntitySpawner;
import org.example.entities.Player;
import org.example.entities.SpeedManager;
import org.example.ui.text.HealthText;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.ScoreText;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, TimerContainer {
    private final DinoCommute GAME;
    private final HostileEntitySpawner HOSTILE_SPAWNER = new HostileEntitySpawner(this);
    private Player player;

    public GameScene(DinoCommute dinoCommute) {
        GAME = dinoCommute;
    }

    @Override
    public void setupScene() {
//        new Image(getClass().getResource("/backgrounds/lucht_achtergrond.png").toExternalForm(), false);
//        new Image(getClass().getResource("/backgrounds/gebouwen_achter_achtergrond.png").toExternalForm(), false);
//        new Image(getClass().getResource("/backgrounds/gebouwen_achtergrond.png").toExternalForm(), false);
//        new Image(getClass().getResource("/backgrounds/gebouwen_voorgrond.png").toExternalForm(), false);
//        new Image(getClass().getResource("/backgrounds/straat_voorgrond.png").toExternalForm(), false);
    }


    @Override
    public void addEntity(final YaegerEntity yaegerEntity) {
        super.addEntity(yaegerEntity);
    }

    @Override
    public void setupEntities() {
        int offset = (int) (getWidth() / 50);
        int textSize = 30;
        var healthText = new HealthText(new Coordinate2D(offset, offset), textSize);
        healthText.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(healthText);

        var highScoreText = new HighScoreText(new Coordinate2D(getWidth() - offset, offset), textSize);
        highScoreText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(highScoreText);

        var scoreText = new ScoreText(new Coordinate2D(getWidth() - offset, (offset * 2) + textSize), textSize);
        scoreText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(scoreText);

        this.player = new Player(new Coordinate2D(100, 500), GAME, this, scoreText, healthText);
        addEntity(player);

        addEntity(new ParallaxBackground("backgrounds/lucht_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 104, 1.1));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achter_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2,    getHeight()), this, 103, 1.3));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 102, 1.5));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 101, 1.7));
        addEntity(new ParallaxBackground("backgrounds/straat_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 100, 2));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new Entityspawner());
        addEntitySpawner(HOSTILE_SPAWNER);
    }

    @Override
    public void setupTimers() {
        var speedManager = new SpeedManager(player, HOSTILE_SPAWNER);
        addTimer(speedManager);
    }
}
