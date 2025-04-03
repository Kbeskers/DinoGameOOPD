package org.example.ui;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class TitlescreenImage extends SpriteEntity {

    public TitlescreenImage(Coordinate2D initialLocation, Size size) {
        super("backgrounds/titlescreenBackground.png", initialLocation, new Size(size.width(), size.height()));
    }
}