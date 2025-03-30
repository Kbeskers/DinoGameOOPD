package org.example.ui.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.DinoCommute;

public class QuitButton extends Button{
    public QuitButton(Coordinate2D initialLocation, DinoCommute game, int fontSize) {
        super(initialLocation, game, fontSize, "Quit Game");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        GAME.quit();
    }
}
