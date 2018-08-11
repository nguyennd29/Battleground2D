package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import game.star.Star;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 5, 5);
        this.boxCollider = new BoxCollider(5, 5);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);

        EnemyFollow enemyFollow = (EnemyFollow) GameObjectManager.instance.checkCollisionKillEnemyFollow(this);
        if (enemyFollow != null) {
            this.isAlive = false;
            enemyFollow.isAlive = false;
        }
        if (this.isAlive == true) {
            Enemies enemy = (Enemies) GameObjectManager.instance.checkCollisionKillEnemy(this);
            if (enemy != null) {
                this.isAlive = false;
                enemy.isAlive = false;
            }
        }

        if (this.isAlive == true) {
           Star star = (Star) GameObjectManager.instance.checkCollisionKillStar(this);
            if (star != null) {
                this.isAlive = false;
                star.isAlive = false;
            }
        }

    }
}
