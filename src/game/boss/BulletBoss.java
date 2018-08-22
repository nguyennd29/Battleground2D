package game.boss;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class BulletBoss extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public BulletBoss() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 10, 10);
        this.boxCollider = new BoxCollider(10, 10);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        this.boxCollider.position.set(this.position.x - 5, this.position.y - 5);

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
