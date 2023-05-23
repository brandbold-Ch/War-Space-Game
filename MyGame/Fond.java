package MyGame;

import javax.swing.*;
import java.awt.*;

public class Fond extends JFrame{
    public Image fond(){
        ImageIcon fond = new ImageIcon("src/MyGame/images/fond.png");
        return fond.getImage();
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(fond(),0, 0, getHeight(), getHeight(), this);
    }
}