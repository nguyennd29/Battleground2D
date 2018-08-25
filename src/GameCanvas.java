import base.GameObjectManager;
import base.Settings;
import base.Vector2D;
import game.ViewPort;
import game.background.Background;

import game.boss.CreateBoss;
import game.enemy.EnemyCreate;
import game.enemyfollow.EnemyFollowCreate;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GameCanvas extends JPanel {


    private BufferedImage backBuffered;
    public Player player;
    private Graphics2D g2d;
//    private ViewPort viewPort;
    Vector2D initPosition= new Vector2D(600,2000);

    public GameCanvas() {
        this.setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);

        setupBackBuffered();
        this.setBackground(Color.black);

        setupCharacter();

//        this.viewPort=new ViewPort();
        ViewPort.instance.getFollowOffset().set(-Settings.GAMEPLAY_WIDTH/2,-Settings.GAMEPLAY_HEIGHT/2);
        this.setVisible(true);
    }

    private void setupBackBuffered() {

        this.backBuffered = new BufferedImage(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        this.g2d =(Graphics2D) this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
//        GameObjectManager.instance.add(new Background());
       //GameObjectManager.instance.add(new StarCreate());
        GameObjectManager.instance.add(new EnemyFollowCreate());
        //GameObjectManager.instance.add(new EnemyCreate());
        GameObjectManager.instance.add(new CreateBoss());

        this.setupPlayer();

    }


    private void setupPlayer() {

        this.player = new Player();
        this.player.position.set(initPosition);

        GameObjectManager.instance.add(player);

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

        GameObjectManager.instance.renderAll(this.g2d,ViewPort.instance);
        this.repaint();

    }

    public void runAll() {

        GameObjectManager.instance.runAll();
        ViewPort.instance.follow(player);
        }
    }


