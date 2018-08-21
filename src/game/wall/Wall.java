package game.wall;

import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Wall extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public Wall(int x,int y) {
        this.position.set(x,y);
        this.renderer = new ImageRenderer("resources/images/brick.png",50,50);
        this.runHitObject = new RunHitObject(Player.class);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        GameObjectManager.instance.findPlayer().velocity.addUp(0,0);
    }
}
