package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameScene;
import org.example.scenes.TitleScene;


public class DinoCommute extends YaegerGame
{
    private GameScene gameScene;

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Dino Commute!");
        setSize(new Size(1200, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
    }
}
