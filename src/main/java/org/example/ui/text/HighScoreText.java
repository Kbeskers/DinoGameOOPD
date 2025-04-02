package org.example.ui.text;

import com.github.hanyaeger.api.Coordinate2D;

public class HighScoreText extends Text {
    public HighScoreText(Coordinate2D initialLocation, int size) {
        super(initialLocation, size, "High Score: 0");
    }

    public void setHighScoreText(int score) {
        setText("High Score: " + score);
    }
}