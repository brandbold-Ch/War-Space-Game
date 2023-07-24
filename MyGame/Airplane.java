package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Airplane extends JPanel implements KeyListener, MouseMotionListener, Runnable {

    // Dynamic variables //
    Briskness briskness;
    static Thread thread;
    Fond fond;
    //////////////////////////

    // Statics variables and class//
    final int VALUE = -1535;
    int count = 1;
    public int X = 0;
    public int Y = 0;
    public static int x = 275;
    public static int y = 300;
    public int y_misil = y;
    public boolean fire = false;
    /////////////////////////////

    public ImageIcon[] getNave(){
        ImageIcon[] naves = new ImageIcon[6];

        naves[0] = new ImageIcon("MyGame/naves/img.png");
        naves[1] = new ImageIcon("MyGame/naves/img_1.png");
        naves[2] = new ImageIcon("MyGame/naves/img_2.png");
        naves[3] = new ImageIcon("MyGame/naves/img_3.png");
        naves[4] = new ImageIcon("MyGame/naves/img_8.png");
        naves[5] = new ImageIcon("MyGame/naves/nave.png");
        return naves;
    }

    public Image getMisil(){
        ImageIcon image = new ImageIcon("MyGame/misiles/img.png");;
        return image.getImage();
    }

    public Airplane(){
        this.briskness = new Briskness();
        this.fond = new Fond();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.repaint();
        ImageIcon[] aircraft = getNave();

        g.drawImage(Fond.fond(), X, Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*2)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*3)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*4)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*5)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*6)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*7)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*8)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*9)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*10)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*11)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*12)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*13)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*14)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*15)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*16)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*17)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*18)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*19)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*20)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*21)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*22)+Y, getWidth(), getWidth(), this);
        g.drawImage(Fond.fond(), X, (VALUE*23)+Y, getWidth(), getWidth(), this);
        g.drawImage(aircraft[2].getImage(), x, y, 100, 120, this);

        if (fire){
            g.drawImage(getMisil(), x-5, y-25, 110, 50, this);
        }
        this.briskness.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 37 -> x -= 20;
            case 38 -> y -= 20;
            case 39 -> x += 20;
            case 40 -> y += 20;
            case 70 -> fire = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        fire = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        x = (int)e.getPoint().getX();
        y = (int)e.getPoint().getY();
    }

    public static Rectangle getAreaNave(){
        return new Rectangle(x, y, 100, 120);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
                if (fire){
                    y_misil -= 1;
                }
                Y += 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
