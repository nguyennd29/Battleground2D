package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.Gun.AK47;
import game.Gun.GunAK47;
import game.Gun.GunKar98;
import game.Gun.Kar98;
import game.boss.BossShoot;
import game.boss.BulletBoss;
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
    public static Player instance = new Player();
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public RunHitObject runHitPlatform;
    public AK47 ak47;
    public Kar98 kar98;
    public GunAK47 gunAK47;
    public GunKar98 gunKar98;
    public double angle;
    public float SPEED = 5;
    private int width;
    private int height;
    public boolean haveBulletAK = false;
    public boolean haveBulletKar98 = false;
    public int Mana =0;

   private Player() {
        this.isAlive = true;
        this.velocity = new Vector2D();
        width=50;
        height=50;
        this.boxCollider = new BoxCollider(width, height);
        this.renderer = new ImageRenderer("resources/PlatformImage/PlayerImage.png", width, height);
        this.ak47 = new AK47();
        this.kar98 = new Kar98();
        this.runHitObject = new RunHitObject(
                EnemyFollow.class,
                Enemies.class, BulletEnemy.class, BulletBoss.class);
        this.runHitPlatform = new RunHitObject(Platform.class);
        this.gunAK47 = new GunAK47();
        this.gunKar98 = new GunKar98();



    }

    public void run() {
        super.run();
//        this.ak47.shoot(this);
//        this.kar98.shoot(this);


        this.boxCollider.position.set(this.position.x - this.width/2, this.position.y - this.height/2);
        this.runHitObject.run(this);

        this.velocity.set(0, 0);
        if(Mana>=3) {
            if (this.haveBulletAK == true) {
                this.gunAK47.isHaveBulletAK();
            }
            if (this.haveBulletKar98 == true) {
                this.gunKar98.isHaveBulletKar98();
            }
        }
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
        if (gameObject instanceof GunAK47)
        {
            this.Mana = 200;
            this.isAlive = true;
            this.haveBulletAK = true;
            this.haveBulletKar98= false;
        }
        else if (gameObject instanceof GunKar98) {
            this.Mana = 200;
            this.isAlive = true;
            this.haveBulletAK= false;
            this.haveBulletKar98 = true;
        }
        else{
            this.isAlive = false;
        }
    }

    @Override
    public boolean isActive() {
        return this.isAlive;
    }
}


