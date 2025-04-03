package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import org.example.DinoCommute;
import org.example.ui.button.Button;
import org.example.ui.button.QuitButton;
import org.example.ui.button.StartButton;
import org.example.ui.text.Text;

import java.util.ArrayList;

public class EndScreen extends CompositeEntity {
    private final DinoCommute GAME;
    private final double SCENE_WIDTH;
    private final double SCENE_HEIGHT;
    private final int CURRENT_SCORE;
    private final int HIGH_SCORE;

    public EndScreen(Coordinate2D initialLocation, DinoCommute game, double sceneWidth, double sceneHeight, int currentScore, int highScore) {
        super(initialLocation);
        this.GAME = game;
        this.SCENE_WIDTH = sceneWidth;
        this.SCENE_HEIGHT = sceneHeight;
        this.CURRENT_SCORE = currentScore;
        this.HIGH_SCORE = highScore;
    }

    @Override
    protected void setupEntities() {

        ArrayList<Text> textEntities = new ArrayList<>();
        if (CURRENT_SCORE >= HIGH_SCORE) {
            textEntities.add(new Text(new Coordinate2D(SCENE_WIDTH / 2, (SCENE_HEIGHT / 2) - 150), 40, "New High Score!"));
        }
        textEntities.add(new Text(new Coordinate2D(SCENE_WIDTH / 2, (SCENE_HEIGHT / 2) - 70), 80, "Game Over"));
        textEntities.add(new Text(new Coordinate2D(SCENE_WIDTH / 2, (SCENE_HEIGHT / 2) - 10), 30, "Score: " + CURRENT_SCORE));
        for (Text text : textEntities) {
            text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            addEntity(text);
        }

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(new StartButton(new Coordinate2D(SCENE_WIDTH / 2, (SCENE_HEIGHT / 2) + 50), GAME, 30));
        buttons.add(new QuitButton(new Coordinate2D(SCENE_WIDTH / 2, (SCENE_HEIGHT / 2) + 120), GAME, 30));
        
        for (Button button : buttons) {
            button.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            addEntity(button);
        }
    }
} 