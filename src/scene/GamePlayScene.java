package scene;

import base.GameObjectManager;
import base.Vector2D;
import game.Gun.CreateDesertEagle;
import game.Gun.CreateGunAK47;
import game.Gun.CreateGunKar98;
import game.Gun.CreateGunShotGun;
import game.background.Background;
import game.boss.CreateBoss;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollowCreate;
import game.player.Player;
import util.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {
    Vector2D initPosition= new Vector2D(600,2000);
    private Clip clip;

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(Enemies.class);
        GameObjectManager.instance.add(new EnemyFollowCreate());
        GameObjectManager.instance.add(new CreateBoss());
        GameObjectManager.instance.add(new CreateGunAK47());
        GameObjectManager.instance.add(new CreateGunKar98());
        GameObjectManager.instance.add(new CreateDesertEagle());
        GameObjectManager.instance.add(new CreateGunShotGun());
        this.setupPlayer();

        this.clip = Utils.loadAudio("resources/audio/shot.wav");
//       this.clip.loop(-1);
//        this.clip.start();
    }

    private void setupPlayer() {
        Player.instance.position.set(initPosition);
        GameObjectManager.instance.add(Player.instance);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }
}