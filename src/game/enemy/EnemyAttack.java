package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class EnemyAttack extends EnemyShoot {




    public FrameCounter frameCounter;

    public EnemyAttack() {

        this.frameCounter = new FrameCounter(200);
    }

    @Override
    public void run(Enemies enemy) {
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle < 360; angle += 360 / 30) {
                BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(new Vector2D(2, 0).rotate(angle));
            }
            this.frameCounter.reset();
        }
    }
}

