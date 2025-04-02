package org.example.ui.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.DinoCommute;

public class StartButton extends Button {
    public StartButton(Coordinate2D initialLocation, DinoCommute game, int fontSize) {
        super(initialLocation, game, fontSize, "Start Game");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        GAME.setActiveScene(1);
    }
}
