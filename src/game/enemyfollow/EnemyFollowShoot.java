package game.enemyfollow;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;

public class EnemyFollowShoot implements Attribute<EnemyFollow> {

    private FrameCounter frameCounter;

    public EnemyFollowShoot() {
        this.frameCounter = new FrameCounter(20);
    }


    @Override
    public void run(EnemyFollow gameObject) {
        if (frameCounter.run()) {
            BulletEnemyFollow bulletEnemyFollow = GameObjectManager.instance.recycle(BulletEnemyFollow.class);
            bulletEnemyFollow.position.set(gameObject.position);
            bulletEnemyFollow.velocity.set(GameObjectManager.instance.findPlayer().position.subtract(gameObject.position).normalized().multiply(15));
            frameCounter.reset();
        }
    }
}
