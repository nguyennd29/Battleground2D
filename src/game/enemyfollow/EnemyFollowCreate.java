package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemyFollowCreate extends GameObject {
    public Random rd;
    public FrameCounter frameCounter;


    public EnemyFollowCreate() {
        this.rd = new Random();
         this.frameCounter = new FrameCounter(100);

    }

    public void run() {

        if (frameCounter.run()) {
            EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
            enemyFollow.position.set(this.rd.nextInt(1024), this.rd.nextInt(2000));
            enemyFollow.velocity.set(this.rd.nextInt(5) + 1, this.rd.nextInt(2) + 1);
            frameCounter.reset();


        }


    }
}
