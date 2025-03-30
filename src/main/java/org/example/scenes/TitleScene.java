package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DinoCommute;
import org.example.ui.button.QuitButton;
import org.example.ui.button.StartButton;
import org.example.ui.text.HealthText;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.Text;

public class TitleScene extends StaticScene {
    private final DinoCommute GAME;

    public TitleScene(DinoCommute dinoCommute) {
        GAME = dinoCommute;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        int offset = (int) (getWidth() / 50);
        int textSize = 30;

        var highScoreText = new HighScoreText(new Coordinate2D(getWidth() - offset, offset), textSize);
        highScoreText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(highScoreText);

        var titleText = new Text(new Coordinate2D(getWidth() / 2, (getHeight() / 2) - 70), 80, "Dino Commute!");
        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(titleText);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 0), GAME, 30);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        var quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 70), GAME, 30);
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitButton);
    }
}
