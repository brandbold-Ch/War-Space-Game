package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BaseModel extends JFrame {
    Airplane logic;

    public BaseModel(){
        setTitle("War space");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setFocusable(true);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("MyGame/images/Airplane.png").getImage());
        logic = new Airplane();
        add(logic);
        addKeyListener(logic);
        addMouseMotionListener(logic);
    }

    public static void main(String[] args) {

        int option = JOptionPane.showConfirmDialog(null, "Quieres jugar?", "Space war", JOptionPane.YES_OPTION);

        if (option == 0){
            BaseModel obj = new BaseModel();
        }else {
            System.exit(0);
        }
    }
}
