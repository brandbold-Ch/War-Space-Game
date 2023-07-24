package MyGame;

import javax.swing.*;
import java.awt.*;

public class Fond extends JPanel {

    public static String image_url = "19333449.jpg";

    public static Image fond() {
        ImageIcon fond = new ImageIcon("MyGame/fondos/"+image_url);
        return fond.getImage();
    }

    public Fond() {}

    @Override
    public void paint(Graphics g){
        super.paint(g);
        super.repaint();

    }
}
