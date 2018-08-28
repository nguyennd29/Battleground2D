import base.GameObjectManager;
import base.Settings;
import base.Vector2D;
import game.Gun.CreateDesertEagle;
import game.Gun.CreateGunAK47;
import game.Gun.CreateGunKar98;
import game.Gun.CreateGunShotGun;
import game.ViewPort;


import game.boss.CreateBoss;
import game.enemyfollow.EnemyFollowCreate;
import game.player.Player;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {


    private BufferedImage backBuffered;
    public Player player;
    private Graphics2D g2d;
//    private ViewPort viewPort;


    public GameCanvas() {
        this.setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
        setupBackBuffered();
        this.setBackground(Color.black);
        SceneManager.instance.changeScene(new GamePlayScene());
//        this.viewPort=new ViewPort();
        ViewPort.instance.getFollowOffset().set(-Settings.GAMEPLAY_WIDTH/2,-Settings.GAMEPLAY_HEIGHT/2);
        this.setVisible(true);
    }

    private void setupBackBuffered() {

        this.backBuffered = new BufferedImage(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        this.g2d =(Graphics2D) this.backBuffered.getGraphics();
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.black);
        g2d.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        GameObjectManager.instance.renderBackground(this.g2d,ViewPort.instance);
        GameObjectManager.instance.renderAll(this.g2d,ViewPort.instance);
        this.repaint();

    }

    public void runAll() {

        GameObjectManager.instance.runAll();
        ViewPort.instance.follow(Player.instance);
        SceneManager.instance.performChangeSceneIfNeeded();
        }
    }


