package org.example.scenes;

import com.github.hanyaeger.api.*;
import com.github.hanyaeger.api.entities.EntitySpawner;
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
    private HostileEntitySpawner hostileSpawner;
    private Player player;

    public GameScene(DinoCommute dinoCommute) {
        GAME = dinoCommute;
    }

    @Override
    public void setupScene() {
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

        addEntity(new ParallaxBackground("backgrounds/lucht_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 104, 0.1));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achter_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2,    getHeight()), this, 103, 0.3));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 102, 0.5));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 101, 0.7));
        addEntity(new ParallaxBackground("backgrounds/straat_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 100, 1));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new Entityspawner());

        this.hostileSpawner = new HostileEntitySpawner(this);
        addEntitySpawner(hostileSpawner);
    }

    @Override
    public void setupTimers() {
        var speedManager = new SpeedManager(player, hostileSpawner);
        addTimer(speedManager);
    }
}
