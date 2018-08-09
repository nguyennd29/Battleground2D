package game.background;

import base.GameObject;
import base.GameObjectManager;
import game.wall.Wall;

import java.util.ArrayList;
import java.util.List;

public class MapCreator {

    public void run() {
        for (int i = 25; i < 1024; i++) {
            GameObjectManager.instance.add(new Wall(i, 25));
            i+=50;
        }
        for (int i = 25; i < 1024; i++) {
            GameObjectManager.instance.add(new Wall(i, 550));
            i += 50;
        }
        for (int i = 25; i < 600; i++) {
            GameObjectManager.instance.add(new Wall(25, i));
            i += 50;
        }
        for (int i = 25; i < 600; i++) {
            GameObjectManager.instance.add(new Wall(1024-25, i));
            i += 50;
        }
    }
}

