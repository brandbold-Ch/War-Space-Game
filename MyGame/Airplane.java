package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Airplane extends JPanel implements KeyListener {

    Obstacle obstacle = new Obstacle(this);
    Fond fond = new Fond();

    public int x = 275;
    public int y = 300;
    public byte speed = 3;

    public Image getImage(){
        ImageIcon image = new ImageIcon("src/MyGame/images/Airplane.png");
        return image.getImage();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(getImage(), getX(), getY(), 95, 95,this);
    }

    @Override
    public int getX(){return x;}

    @Override
    public int getY(){return y;}

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        super.repaint();

        switch (e.getKeyCode()) {
            case 37 -> x -= (1*speed);
            case 38 -> y -= 1;
            case 39 -> x += 1;
            case 40 -> y += 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}