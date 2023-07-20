package MyGame;

import javax.swing.*;

public class Obstacles extends JPanel {

    public static ImageIcon[] icons(){

        ImageIcon[] icons = new ImageIcon[5];

        icons[0] = new ImageIcon("MyGame/images/drone.png");
        icons[1] = new ImageIcon("MyGame/images/misil.png");
        icons[2] = new ImageIcon("MyGame/images/misil(1).png");
        icons[3] = new ImageIcon("MyGame/images/misil(2).png");
        icons[4] = new ImageIcon("MyGame/images/bomba.png");
        return icons;
    }
}
