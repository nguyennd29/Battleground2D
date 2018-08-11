package input;
import base.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    public boolean clicked = false;
    public Vector2D vector2D;
    public static MouseInput instance = new MouseInput();
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.clicked = true;
        vector2D = new Vector2D(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
