package game.player;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import game.Gun.AK47;
import game.Gun.GunAK47;
import game.Gun.GunKar98;
import game.Gun.Kar98;
import game.enemy.BulletEnemy;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public GunAK47 gunAK47;
    public GunKar98 gunKar98;
    public AK47 ak47;
    public Kar98 kar98;
    public double angle;
    public boolean haveBulletAK = false;
    public boolean haveBulletKar98 = false;


    public Player() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20, 16);
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8));
        this.ak47 = new AK47();
        this.kar98 = new Kar98();
        this.attributes.add(new PlayerMove());
        this.runHitObject = new RunHitObject(
                EnemyFollow.class,
                Enemies.class, BulletEnemy.class);
        this.gunAK47 = new GunAK47();
        this.gunKar98 = new GunKar98();

    }

    public void run() {
        super.run();
//        this.ak47.shoot(this);
//        this.kar98.shoot(this);
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        this.runHitObject.run(this);
        if (this.haveBulletAK == true) {
            this.gunAK47.isHaveBulletAK();
        }
        if (this.haveBulletKar98 == true) {
            this.gunKar98.isHaveBulletKar98();
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof GunAK47) {
            this.isAlive = true;
            this.haveBulletAK = true;
            this.haveBulletKar98= false;
        }
        else if (gameObject instanceof GunKar98) {
            this.isAlive = true;
            this.haveBulletAK= false;
            this.haveBulletKar98 = true;
        }
        else{
                this.isAlive = false;
            }
        }
    }




