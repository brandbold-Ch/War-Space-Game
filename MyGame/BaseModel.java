package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BaseModel extends JFrame {

    public BaseModel(){
        setTitle("War space");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("MyGame/images/Airplane.png").getImage());
        Briskness briskness = new Briskness();
        Airplane logic = new Airplane();
        add(logic);
        addKeyListener(logic);
        addMouseMotionListener(logic);
    }

    public static void main(String[] args) {
        BaseModel obj = new BaseModel();
    }
}
