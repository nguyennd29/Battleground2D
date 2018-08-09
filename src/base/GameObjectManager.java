package base;

import game.enemyfollow.EnemyFollow;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();


    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void runAll() {
        this.list.stream().filter(gameObject -> gameObject.isAlive).forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list.stream().filter(gameObject -> gameObject.isAlive).forEach(gameObject -> gameObject.render(graphics));
    }


    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public Player findPlayer() {
//        for (GameObject gameObject:this.list) {
//            if(gameObject instanceof Player)
//                return (Player)gameObject;
//        }


        return (Player) this.list.stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

    public EnemyFollow checkCollision(BulletPlayer bulletPlayer) {
        return (EnemyFollow) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof EnemyFollow)
                .filter(gameObject -> {
                    BoxCollider other = ((EnemyFollow) gameObject).boxCollider;
                    return bulletPlayer.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }


}
