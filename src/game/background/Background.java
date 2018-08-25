package game.background;

import base.GameObject;
import base.Vector2D;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {

    public Background() {
        renderer = new BackgroundRenderer(Color.BLACK, 1024, 600);
    }

    public void run(Vector2D parentPosition) {
        super.run();
    }
}
