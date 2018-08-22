package game.player;

import base.GameObject;
import base.Vector2D;
import game.Gun.AK47;
import game.Gun.GunObject;
import game.Gun.Kar98;
import game.enemy.BulletEnemy;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import game.wall.Wall;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public AK47 ak47;
    public Kar98 kar98;
    public double angle;
    public Player() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,16);
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8));
        this.ak47=new AK47();
        this.kar98=new Kar98();
        this.attributes.add(new PlayerMove());
        this.attributes.add(new PlayerShoot());
        this.runHitObject = new RunHitObject(
                EnemyFollow.class,
                Enemies.class, BulletEnemy.class);

    }
    public void run() {
        super.run();
//        this.ak47.shoot(this);
        this.kar98.shoot(this);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x-10,this.position.y-8);
        this.runHitObject.run(this);

    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive= false;

        }
    }


