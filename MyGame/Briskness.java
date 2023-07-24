package MyGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Briskness extends JPanel implements Runnable {
    public static int x=0, y=-30, align_1, align_2, obstacle_random_1, obstacle_random_2, score=0, count=0, level=1;
    Random random = new Random();
    ImageIcon[] arrayImages;
    Collision collition;
    public static boolean pause = false;
    static int option = -1;
    int speed = 5;
    double angle_rotation;
    static Thread thread;

    public Briskness(){
        thread = new Thread(this);
        thread.start();
        this.arrayImages = Obstacles.images_enemies();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Collision.x = x;
        Collision.y = y;
        Graphics2D g2 = (Graphics2D)g;
        repaint();

        if (assets()){
            if (obstacle_random_1 == 10){
                change_fond();
                y = -30;
                level ++;
                speed --;
                score ++; score *= 10;
                repaint();
            }else {
                pause = true;
                collition = new Collision(g);
            }
        }

        g2.setFont(new Font("Ravie", Font.BOLD, 30));
        g2.setColor(Color.GREEN);
        g2.drawString("Score: " + score, 1300, 25);
        g2.drawString("Level: " + level, 1000, 25);
        g2.rotate(angle_rotation, x, y);
        g2.drawImage(this.arrayImages[obstacle_random_1].getImage(), x-210/2, y-150/2, 210, 150, this);
    }

    public boolean assets(){
        return (collision_1())? true : false;
    }

    public void status(){
        if (pause){
            option = JOptionPane.showConfirmDialog(null, "Haz perdido, ¿Quieres jugar otra vez?", "Alert", JOptionPane.YES_OPTION);
            System.out.println("hay me paraste");
            if (option == 0){
                pause = false;
            }
            else {
                System.exit(0);
            }
        }
    }

    public void change_fond(){
        switch (level){
            case 1 -> Fond.image_url = "space1.png";
            case 2 -> Fond.image_url = "space2.jpg";
            case 3 -> Fond.image_url = "space3.jpg";
            case 4 -> Fond.image_url = "space4.jpg";
            case 5 -> Fond.image_url = "space5.jpg";
        }
    }

    public static Rectangle getAreaObstacle_1(){
        return new Rectangle(x-210/2, y-150/2, 210, 150);
    }

    public boolean collision_1(){
        return Airplane.getAreaNave().getBounds().intersects(getAreaObstacle_1());
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(speed);
                if (count == 900){
                    count = 0;
                    y = -30;
                    x = random.nextInt(1100);
                    obstacle_random_1 = random.nextInt(11);
                }
                if (pause){
                    status();
                }
                angle_rotation += Math.toRadians(1);
                y += 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }
}
