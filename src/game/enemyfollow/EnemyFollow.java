package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    private int HP;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/FlameDemon Evolved.png", 50, 50);
        this.boxCollider = new BoxCollider(50, 50);
         this.HP = 200;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        update();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);
    }


    public void update() {

        this.velocity.set(GameObjectManager.instance.findPlayer().position.subtract(this.position).normalized().multiply(1.4f));
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletPlayer) {
            this.HP -= ((BulletPlayer) gameObject).damage;
        }
        if (this.HP <= 0) {
            this.isAlive = false;
            this.HP = 200;
        }
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }
}
