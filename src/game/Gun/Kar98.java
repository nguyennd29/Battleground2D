package game.Gun;

public class Kar98 extends GunObject {
    public Kar98(){
        this.lastTime=0;
        this.firingRate = 1;
        this.recoilRate = 1;
        this.bulletSpeed = 50;
        this.manaCost =10;
    }
}