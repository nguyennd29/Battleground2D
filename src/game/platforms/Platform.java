package game.platforms;


import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

/**
 * Created by huynq on 8/3/17.
 */
public class Platform extends GameObject implements PhysicBody {
    private BoxCollider boxCollider;
    private int width;
    private int height;
    public Platform() {
        super();
        this.position=new Vector2D();
        width=80;
        height=80;
        this.boxCollider = new BoxCollider(width,height);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public static Platform create(int platformType) {
        Platform platform = new Platform();
        switch (platformType) {
            case 1:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-0-0.png", platform.width, platform.height);
                break;
            case 2:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-0-1.png", platform.width, platform.height);
                break;
            case 3:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-0-2.png", platform.width, platform.height);
                break;
            case 4:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-0-3.png", platform.width, platform.height);
                break;
            case 5:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-0-4.png", platform.width, platform.height);
                break;
            case 17:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-1-0.png", platform.width, platform.height);
                break;
            case 18:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-1-1.png", platform.width, platform.height);
                break;
            case 19:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-1-2.png", platform.width, platform.height);
                break;
            case 20:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-1-3.png", platform.width, platform.height);
                break;
            case 21:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-1-4.png", platform.width, platform.height);
                break;
            case 33:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-2-0.png", platform.width, platform.height);
                break;
            case 34:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-2-1.png", platform.width, platform.height);
                break;
            case 35:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-2-2.png", platform.width, platform.height);
                break;
            case 36:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-2-3.png", platform.width, platform.height);
                break;
            case 37:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-2-4.png", platform.width, platform.height);
                break;
            case 49:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-3-0.png", platform.width, platform.height);
                break;
            case 50:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-3-1.png", platform.width, platform.height);
                break;
            case 51:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-3-2.png", platform.width, platform.height);
                break;
            case 52:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-3-3.png", platform.width, platform.height);
                break;
            case 53:
                platform.renderer = new ImageRenderer("resources/PlatformImage/0x72_16x16DungeonTileset_walls.v1 [www.imagesplitter.net]-3-4.png", platform.width, platform.height);
                break;
        }
        return platform;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public boolean isActive() {
        return true;
    }

    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x - width/2, this.position.y - height/2);
    }
}
