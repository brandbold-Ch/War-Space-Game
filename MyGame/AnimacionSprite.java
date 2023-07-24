package MyGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Spring;

/**
 *
 * @author Alexander
 */
public class AnimacionSprite extends JFrame implements Runnable{

    Image img;
    Thread hilo1;
    int incremento;
    BufferedImage bi;
    
    public AnimacionSprite(){
        setSize(500,400);
        getContentPane().setBackground(Color.ORANGE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Animacion Sprite");
        setResizable(false);
        
        hilo1 = new Thread(this);
        //empaqueta en pixeles la imagen 8 bits
        bi = new BufferedImage(500,400,BufferedImage.TYPE_INT_RGB);
        Toolkit herramienta = Toolkit.getDefaultToolkit();
        //Devuelve una imagen que obtiene datos de píxeles de la URL especificada.
        img = herramienta.getImage(getClass().getResource("/MyGame/efectos/img.png"));
        hilo1.start();
        
    }

    @Override
    public void paint(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillRect(0, 0, 500, 400);
        Graphics2D g2d;
        g.drawImage(bi, 0, 0, this);
        g2d = bi.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 500, 400);
        //g2d = (Graphics2D)g;
        int mx = (incremento %5 )*125;
        int my = (incremento /5 )*125;
        //                   posicion      anchura           animacion    tamaño animacion
        g2d.drawImage(img,200,200,200+120,200+120,mx,my,mx+120,my+120,this);
        repaint();
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimacionSprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            incremento = incremento +1;
            if(incremento>25){
                incremento=0;
            }
        }
    }
   public static void main(String[] args) {
        new AnimacionSprite().setVisible(true);
    } 
}
