package game.wall;

import base.GameObject;
import renderer.ImageRenderer;

public class Wall extends GameObject {
    public Wall(int x,int y) {
        this.position.set(x,y);
        this.renderer = new ImageRenderer("resources/images/brick.png",50,50);
    }
}
