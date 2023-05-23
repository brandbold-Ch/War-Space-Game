package MyGame;

import javax.swing.*;
import java.awt.*;

public class Obstacle extends JPanel {

    public int X = 100;
    public int Y = 100;
    public Airplane airplane;

    public Obstacle(Airplane airplane){
        this.airplane = airplane;
    }

    public ImageIcon[] icons(){

        ImageIcon[] icons = new ImageIcon[5];

        icons[0] = new ImageIcon("src/MyGame/images/drone.png");
        icons[1] = new ImageIcon("src/MyGame/images/misil.png");
        icons[2] = new ImageIcon("src/MyGame/images/misil(1).png");
        icons[3] = new ImageIcon("src/MyGame/images/misil(2).png");
        icons[4] = new ImageIcon("src/MyGame/images/bomba.png");

        return icons;
    }

    public void actions(Graphics g) {
        ImageIcon[] missiles = icons();

        while (true){

            for (int i=0; i < 1000; i++){
                try {
                    super.repaint();
                    g.drawImage(missiles[0].getImage(), X, i, 95, 95, this);
                    g.drawImage(missiles[1].getImage(), X, i, 95, 95, this);
                    g.drawImage(missiles[2].getImage(), X, i, 95, 95, this);
                    g.drawImage(missiles[3].getImage(), X, i, 95, 95, this);
                    g.drawImage(missiles[4].getImage(), X, i, 95, 95, this);
                    Thread.sleep((10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
