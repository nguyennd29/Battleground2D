package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public EnemyFollow(){
        this.velocity=new Vector2D();
        this.renderer = new ImageRenderer("resources/images/FlameDemon Evolved.png",50,50);
       this.boxCollider =new BoxCollider(50,50);
    }
    @Override
    public void run() {
        super.run();
        update();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-25,this.position.y-25);
    }


    public void update(){

      this.velocity.set(GameObjectManager.instance.findPlayer().position.subtract(this.position).normalized().multiply(1.4f));
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
            this.isAlive = false;
    }
}
