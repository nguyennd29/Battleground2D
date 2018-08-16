package game.player;

import base.GameObject;
import base.Vector2D;
import game.Gun.AK47;
import game.Gun.GunObject;
import game.Gun.Kar98;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject {
    public Vector2D velocity;
    public AK47 ak47;
    public Kar98 kar98;
    public double angle;

    public Player() {
        this.velocity = new Vector2D();

//        this.renderer = new PolygonRenderer(Color.RED,
//                new Vector2D(),
//                new Vector2D(0, 16),
//                new Vector2D(20, 8));
        this.renderer = new ImageRenderer("resources/images/0x72_16x16DungeonTileset.v4.jpg",50,50);
        this.ak47 = new AK47();
        this.kar98 = new Kar98();
        this.attributes.add(new PlayerMove());

    }

    public void run() {
        super.run();
        this.ak47.shoot(this);
        // this.kar98.shoot(this);
        //((PolygonRenderer) this.renderer).angle = this.angle;


    }


}

