package game.Gun;
import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;



import java.util.Random;

public class CreateGunKar98 extends GameObject {
    public Random rd;

    public CreateGunKar98() {
        this.rd = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(
                        10,
                        new SequenceAction(
                                new WaitAction(150),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        GunKar98 gunKar98 = GameObjectManager.instance.recycle(GunKar98.class);
                                        GunKar98 gunKar982 = GameObjectManager.instance.recycle(GunKar98.class);
                                        GunKar98 gunKar983 = GameObjectManager.instance.recycle(GunKar98.class);
                                        GunKar98 gunKar984 = GameObjectManager.instance.recycle(GunKar98.class);
                                        GunKar98 gunKar985 = GameObjectManager.instance.recycle(GunKar98.class);
                                        gunKar98.position.set(2762,3550);
                                        gunKar982.position.set(715,4748);
                                        gunKar982.position.set(4465,5363);
                                        gunKar982.position.set(5105,5275);
                                        gunKar982.position.set(5692,5620);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}