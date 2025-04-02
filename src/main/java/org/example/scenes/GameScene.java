package org.example.scenes;

import com.github.hanyaeger.api.*;
import org.example.entities.Entityspawner;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.DinoCommute;
import org.example.entities.spawner.HostileEntitySpawner;
import org.example.entities.player.Player;
import org.example.entities.SpeedManager;
import org.example.ui.text.HealthText;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.ScoreText;
import org.example.ui.text.Text;

import java.util.ArrayList;

public class GameScene extends DynamicScene implements EntitySpawnerContainer, TimerContainer {
    private final DinoCommute GAME;
    private final HostileEntitySpawner HOSTILE_SPAWNER = new HostileEntitySpawner(this);
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

        ArrayList<Text> textEntities = new ArrayList<>();
        textEntities.add(new HealthText(new Coordinate2D(offset, offset), textSize));
        textEntities.add(new HighScoreText(new Coordinate2D(getWidth() - offset, offset), textSize));
        textEntities.add(new ScoreText(new Coordinate2D(getWidth() - offset, (offset * 2) + textSize), textSize));
        for (Text text : textEntities) {
            if (text instanceof HealthText) {
                text.setAnchorPoint(AnchorPoint.TOP_LEFT);
            } else if (text instanceof HighScoreText || text instanceof ScoreText) {
                text.setAnchorPoint(AnchorPoint.TOP_RIGHT);
            }
            addEntity(text);
        }

        this.player = new Player(new Coordinate2D(100, 500), GAME, (ScoreText) textEntities.get(2), (HealthText) textEntities.get(0));
        addEntity(player);

        addEntity(new ParallaxBackground("backgrounds/lucht_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 104, 1.1));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achter_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 103, 1.3));
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
