package org.example.ui.button;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.DinoGame;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    protected DinoGame game;

    public Button(Coordinate2D initialLocation, DinoGame game, int fontSize) {
        super(initialLocation,"Play game");
        setFill(Color.BLACK);
        setFont(Font.font("Roboto", FontWeight.BOLD, fontSize));

        this.game = game;
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
