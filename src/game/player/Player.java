package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.Gun.AK47;
import game.Gun.Kar98;
import game.enemy.BulletEnemy;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import game.platforms.Platform;
import input.KeyboardInput;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;


public class Player extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public RunHitObject runHitPlatform;
    public AK47 ak47;
    public Kar98 kar98;
    public double angle;
    public float SPEED = 5;
    private int width;
    private int height;

    public Player() {
        this.velocity = new Vector2D();
        width=50;
        height=50;
        this.boxCollider = new BoxCollider(width, height);
        this.renderer = new ImageRenderer("resources/images/0x72_16x16DungeonTileset.v4.jpg", width, height);
        this.ak47 = new AK47();
        this.kar98 = new Kar98();
        this.runHitObject = new RunHitObject(
                EnemyFollow.class,
                Enemies.class, BulletEnemy.class);
        this.runHitPlatform = new RunHitObject(Platform.class);


    }

    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.ak47.shoot(this);
//        this.kar98.shoot(this);


        this.boxCollider.position.set(this.position.x - this.width/2, this.position.y - this.height/2);
        this.runHitObject.run(this);

        this.velocity.set(0, 0);

        if (KeyboardInput.instance.isUp) {
            this.velocity.y -= SPEED;
        }
        if (KeyboardInput.instance.isDown) {
            this.velocity.y += SPEED;
        }
        if (KeyboardInput.instance.isRight) {
            this.velocity.x += SPEED;
        }
        if (KeyboardInput.instance.isLeft) {
            this.velocity.x -= SPEED;
        }

        moveVertical();
        moveHorizontal();

//        this.position.addUp(velocity);



    }

    private void moveVertical() {
        BoxCollider nextBoxCollider = this.boxCollider.shift(0, velocity.y);
        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);
        if (platform != null) {
            float shiftDistance = Math.signum(velocity.y);
            boolean moveContinue = true;
            while (moveContinue) {
                if (GameObjectManager.instance.checkCollision(this.boxCollider.shift(0, shiftDistance), Platform.class) != null) {
                    moveContinue = false;
                } else {
                    shiftDistance += Math.signum(velocity.y);
                    this.position.addUp(0, Math.signum(velocity.y));
                }
            }
            velocity.y = 0;
        }
        this.position.addUp(0,velocity.y);
        this.screenPosition.addUp(0,velocity.y);
    }
    private void moveHorizontal() {
        BoxCollider nextBoxCollider = this.boxCollider.shift(velocity.x, 0);
        Platform platform = GameObjectManager.instance.checkCollision(nextBoxCollider, Platform.class);
        if (platform != null) {
            float shiftDistance = Math.signum(velocity.x);
            boolean moveContinue = true;
            while (moveContinue) {
                if (GameObjectManager.instance.checkCollision(this.boxCollider.shift(shiftDistance,0), Platform.class) != null) {
                    moveContinue = false;
                } else {
                    shiftDistance += Math.signum(velocity.x);
                    this.position.addUp(Math.signum(velocity.x), 0);
                }
            }
            velocity.x = 0;
        }
        this.position.addUp(velocity.x,0);
        this.screenPosition.addUp(velocity.x,0);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }

    @Override
    public boolean isActive() {
        return this.isAlive;
    }
}


