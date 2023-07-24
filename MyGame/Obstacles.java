package MyGame;

import javax.swing.*;

public class Obstacles extends JPanel {

    public static ImageIcon[] images_enemies(){
        ImageIcon[] icons = new ImageIcon[11];

        icons[0] = new ImageIcon("MyGame/obstaculos/img_1.png");
        icons[1] = new ImageIcon("MyGame/obstaculos/img_2.png");
        icons[2] = new ImageIcon("MyGame/obstaculos/img_3.png");
        icons[3] = new ImageIcon("MyGame/obstaculos/img_4.png");
        icons[4] = new ImageIcon("MyGame/obstaculos/img_5.png");
        icons[5] = new ImageIcon("MyGame/obstaculos/img_6.png");
        icons[6] = new ImageIcon("MyGame/obstaculos/img_8.png");
        icons[7] = new ImageIcon("MyGame/obstaculos/img_9.png");
        icons[8] = new ImageIcon("MyGame/obstaculos/img_10.png");
        icons[9] = new ImageIcon("MyGame/obstaculos/img.png");
        icons[10] = new ImageIcon("MyGame/efectos/hole.gif");
        return icons;
    }
}
