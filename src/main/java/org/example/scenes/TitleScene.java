package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DinoCommute;
import org.example.ui.button.StartButton;
import org.example.ui.text.Text;

public class TitleScene extends StaticScene {
    private DinoCommute game;

    public TitleScene(DinoCommute dinoCommute) {
        game = dinoCommute;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var titleText = new Text(new Coordinate2D(getWidth() / 2, getHeight() / 2), 80, "Dino Commute!");
        titleText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(titleText);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2, (getHeight() / 2) + 50), game, 30);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }
}
