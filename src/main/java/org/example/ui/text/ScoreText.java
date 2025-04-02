package org.example.ui.text;

import com.github.hanyaeger.api.Coordinate2D;

public class ScoreText extends Text {
    public ScoreText(Coordinate2D initialLocation, int size) {
        super(initialLocation, size, "Score: 0");
    }

    public void setScoreText(int score) {
        setText("Score: " + score);
    }
}
