package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Enemies extends GameObject implements PhysicBody {

//    public int width;
//    public int height;

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public Enemies() {

        this.velocity = new Vector2D();
        renderer = new ImageRenderer("resources/images/powerup_shield.png", 30, 30);
        boxCollider=new BoxCollider(30,30);
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        this.velocity.set(-1, 0);
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x-15,this.position.y-15);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }
}



