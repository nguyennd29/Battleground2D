package game.player;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import input.MouseInput;

public class PlayerShoot implements Attribute<Player> {

    long lastTime;

    public PlayerShoot() {
        this.lastTime = 0;
    }


    @Override
    public void run(Player gameObject) {


            if (MouseInput.instance.clicked) {
                long currentTime = System.nanoTime();
                if (currentTime - this.lastTime >= 100_000_000) {
                    BulletPlayer bulletPlayer = new BulletPlayer();
                    bulletPlayer.position.set(gameObject.position);

                    GameObjectManager.instance.add(bulletPlayer);

                    bulletPlayer.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0,25).normalized().multiply(16.0f));
                    this.lastTime = currentTime;
                }
            }

    }
}