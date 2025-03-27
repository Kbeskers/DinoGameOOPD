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
import org.example.DinoCommute;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    protected DinoCommute game;

    public Button(Coordinate2D initialLocation, DinoCommute game, int fontSize, String text) {
        super(initialLocation, text);
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
