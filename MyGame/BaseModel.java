package MyGame;

import javax.swing.*;
import java.awt.*;

public class BaseModel extends JFrame {

    public BaseModel(){

        setTitle("War space");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/MyGame/images/Airplane.png").getImage());
        Airplane logic = new Airplane();
        add(logic);
        addKeyListener(logic);
    }

    public static void main(String[] args) {
        BaseModel obj = new BaseModel();
    }
}
