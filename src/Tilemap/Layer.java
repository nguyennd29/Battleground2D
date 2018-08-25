package Tilemap;

import base.GameObject;
import base.GameObjectManager;
import game.platforms.Platform;

import java.util.List;

public class Layer {
    List<Integer> data;
    int height;
    int width;

    public void generate() {
        System.out.println(this);
       for(int  titleY =0;titleY<height;titleY++) {
           for (int titleX = 0; titleX < width; titleX++) {
               int mapData = data.get(titleY * width + titleX);
               if(mapData!=0){
                   Platform platform=Platform.create(mapData);
                   platform.position.set(80*titleX,titleY*80);

                   GameObjectManager.instance.add(platform);
               }
           }
       }
    }

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}