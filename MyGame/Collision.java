package MyGame;

import javax.swing.*;
import java.awt.*;

public class Collision extends JPanel implements Runnable {
    static Thread thread;
    public static int x, y;
    public static int frame;

    public Collision(Graphics g){
        thread = new Thread(this);
        paint(g);
        thread.start();
    }

    public ImageIcon[] frames(){
        ImageIcon[] frames_exp = new ImageIcon[14];

        frames_exp[0] = new ImageIcon("MyGame/efectos/img1.png");
        frames_exp[1] = new ImageIcon("MyGame/efectos/img2.png");
        frames_exp[2] = new ImageIcon("MyGame/efectos/img3.png");
        frames_exp[3] = new ImageIcon("MyGame/efectos/img4.png");
        frames_exp[4] = new ImageIcon("MyGame/efectos/img5.png");
        frames_exp[5] = new ImageIcon("MyGame/efectos/img6.png");
        frames_exp[6] = new ImageIcon("MyGame/efectos/img7.png");
        frames_exp[7] = new ImageIcon("MyGame/efectos/img8.png");
        frames_exp[8] = new ImageIcon("MyGame/efectos/img9.png");
        frames_exp[9] = new ImageIcon("MyGame/efectos/img10.png");
        frames_exp[10] = new ImageIcon("MyGame/efectos/img11.png");
        frames_exp[11] = new ImageIcon("MyGame/efectos/img12.png");
        frames_exp[12] = new ImageIcon("MyGame/efectos/img13.png");
        frames_exp[13] = new ImageIcon("MyGame/efectos/img14.png");
        return frames_exp;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        repaint();
        ImageIcon[] fragments = frames();
        g.drawImage(fragments[Collision.frame].getImage(), x-10, y-10, 210, 150, this);
    }

    public static void stopThread(){
        thread.interrupt();
    }

    public static void startThread(){
        thread.start();
    }

    @Override
    public void run() {
        for (int i=0; i < 14; i++){
            try {

                Thread.sleep(500);
                Collision.frame = i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
