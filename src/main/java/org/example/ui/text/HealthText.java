package org.example.ui.text;

import com.github.hanyaeger.api.Coordinate2D;

public class HealthText extends Text{
    public HealthText(Coordinate2D initialLocation, int size) {
        super(initialLocation, size, "Health: 100");
    }
    public void setHealthText(int health){
        setText("Health: " + health);
    }
}
