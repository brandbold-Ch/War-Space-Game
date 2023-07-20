package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Briskness extends JPanel implements Runnable {
    public static int x=0, y=0;
    JProgressBar progressBar = new JProgressBar(0 , 100);
    ImageIcon[] arrayImages = Obstacles.icons();
    
    public Briskness(){
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        add(progressBar);
    }

    @Override
    public void paint(Graphics g){
        Briskness briskness = new Briskness();
        Thread thread = new Thread(briskness);

        g.setFont(new Font("Ravie", Font.BOLD, 30));
        g.setColor(Color.GREEN);
        g.drawString("Score: 000", 1000, 20);

        g.drawImage(arrayImages[0].getImage(), 45, y, 90, 100, this);
        g.drawImage(arrayImages[1].getImage(), 120, y, 90, 100, this);
        g.drawImage(arrayImages[2].getImage(), 100, y, 90, 100, this);
        g.drawImage(arrayImages[3].getImage(), 260, y, 90, 100, this);
        g.drawImage(arrayImages[4].getImage(), 90, y, 90, 100, this);
        super.repaint();
        thread.start();
    }

    @Override
    public void run() {
        for (int i=0; i <= 500; i++){
            if (i == 500){
                y = 0;
                i = 0;
            }
            try {
                Thread.sleep(800);
                y += i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
