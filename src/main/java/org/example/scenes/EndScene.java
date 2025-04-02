package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DinoCommute;
import org.example.ui.button.Button;
import org.example.ui.button.QuitButton;
import org.example.ui.button.StartButton;
import org.example.ui.text.HealthText;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.ScoreText;
import org.example.ui.text.Text;

import java.util.ArrayList;

public class EndScene extends StaticScene {
    private final DinoCommute GAME;

    public EndScene(DinoCommute dinoCommute) {
        GAME = dinoCommute;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        int offset = (int) (getWidth() / 50);
        int textSize = 30;

        ArrayList<Text> textEntities = new ArrayList<>();
        textEntities.add(new HealthText(new Coordinate2D(offset, offset), textSize));
        textEntities.add(new HighScoreText(new Coordinate2D(getWidth() - offset, offset), textSize));
        textEntities.add(new ScoreText(new Coordinate2D(getWidth() - offset, (offset * 2) + textSize), textSize));
        textEntities.add(new Text(new Coordinate2D(getWidth() / 2, (getHeight() / 2) - 70), 80, "Game Over"));
        for (Text text : textEntities) {
            if (text instanceof HealthText) {
                text.setAnchorPoint(AnchorPoint.TOP_LEFT);
            } else if (text instanceof HighScoreText || text instanceof ScoreText) {
                text.setAnchorPoint(AnchorPoint.TOP_RIGHT);
            } else if (text instanceof Text) {
                text.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            }
            addEntity(text);
        }

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(new StartButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 0), GAME, 30));
        buttons.add(new QuitButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 70), GAME, 30));
        for (Button button : buttons) {
            button.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            addEntity(button);
        }
    }
}
