package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.example.DinoCommute;
import org.example.entities.Player;
import org.example.ui.text.HealthText;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.ScoreText;

public class GameScene extends DynamicScene {
    private DinoCommute game;
    public GameScene(DinoCommute dinoCommute) {
        game = dinoCommute;
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

        var player = new Player(new Coordinate2D(500, 500), game, this, scoreText, healthText);
        addEntity(player);

        addEntity(new ParallaxBackground("backgrounds/lucht_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 104, 0.1));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achter_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2,    getHeight()), this, 103, 0.3));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_achtergrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 102, 0.5));
        addEntity(new ParallaxBackground("backgrounds/gebouwen_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 101, 0.7));
        addEntity(new ParallaxBackground("backgrounds/straat_voorgrond.png", new Coordinate2D(0, 0), new Size(getWidth() * 1.2, getHeight()), this, 100, 1));
    }
}
