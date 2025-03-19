package org.example.ui.button;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import org.example.DinoGame;

public class StartButton extends Button{
    public StartButton(Coordinate2D initialLocation, DinoGame game, int fontSize) {
        super(initialLocation, game, fontSize);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
}
