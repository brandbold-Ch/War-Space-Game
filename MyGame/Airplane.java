package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Airplane extends JPanel implements KeyListener, MouseMotionListener {
    Fond fond = new Fond();
    Briskness briskness = new Briskness();
    public int x = 275;
    public int y = 300;

    public Image getImage(){
        ImageIcon image = new ImageIcon("MyGame/images/img.png");
        return image.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fond.fond(), 0, 0, getWidth(), getWidth(), this);
        g.drawImage(getImage(), x, y, 90, 150, this);
        super.repaint();
        briskness.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
            case 37 -> x -= 20;
            case 38 -> y -= 20;
            case 39 -> x += 20;
            case 40 -> y += 20;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Me mueves");
        x = (int)e.getPoint().getX();
        y = (int)e.getPoint().getY();
        super.repaint();
    }
}
