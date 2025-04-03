package org.example.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;
import org.example.DinoCommute;
import org.example.ui.TitlescreenImage;
import org.example.ui.button.Button;
import org.example.ui.button.QuitButton;
import org.example.ui.button.StartButton;
import org.example.ui.text.HighScoreText;
import org.example.ui.text.Text;

import java.util.ArrayList;

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

        TitlescreenImage dinoImage = new TitlescreenImage(new Coordinate2D(getWidth() / 2, (getHeight() / 2)),new Size(getWidth(), getHeight()));
        dinoImage.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(dinoImage);

        ArrayList<Text> textEntities = new ArrayList<>();
        textEntities.add(new HighScoreText(new Coordinate2D(getWidth() - offset, offset), textSize));
        textEntities.add(new Text(new Coordinate2D(getWidth() / 2, (getHeight() / 2) - 70), 80, "Dino Commute!"));
        for (Text text : textEntities) {
            if (text instanceof HighScoreText) {
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
