package org.example.ui.button;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.example.DinoCommute;
import org.example.ui.text.Text;

public abstract class Button extends Text implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    protected final DinoCommute GAME;

    public Button(Coordinate2D initialLocation, DinoCommute game, int fontSize, String text) {
        super(initialLocation,fontSize, text);

        this.GAME = game;
    }

    @Override
    abstract public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);

    @Override
    public void onMouseEntered() {
        setFill(Color.GREY);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.BLACK);
    }
}
