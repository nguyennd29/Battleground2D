package game.boss;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Boss extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public int HP = 9999;


    public Boss() {
        this.renderer = new ImageRenderer("resources/images/FlameDemon Evolved.png", 60, 60);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(60, 60);
        this.attributes.add(new BossShoot());
    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        this.boxCollider.position.set(this.position.x - 30, this.position.y - 30);

    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletPlayer) this.HP -= 50;
        if (this.HP <= 0) {
            this.isAlive = false;
            this.HP = 9999;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
