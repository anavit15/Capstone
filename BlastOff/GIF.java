
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.Random;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class GIF extends JPanel {

    private int x = 0;
    private int y = 0;
    private URL url;
    private BufferedImage bi;
    public GIF()
    {
        url= new URL("http://wallpapercave.com/wp/8cEpZrx.jpg");
        bi=ImageIO.read(url);
    }
    
    private void move() {
        Random rn=new Random();
        if (rn.nextInt(2)==0)
        {
            x+=rn.nextInt(50);
        }
        else
        {
            x-=rn.nextInt(30);
            if (x<0)
            {
                x=0;
            }
            else if(x>500)
            {
                x=300;
            }
            
        }
        if (rn.nextInt(2)==0)
        {
            y+=rn.nextInt(50);
        }
        else
        {
            y-=rn.nextInt(20);
            if (y<0)
            {
                y=0;
            }
            else if (y>500)
            {
                y=300;
            }
        }    
       
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.drawImage(bi,x,y,null);
        g2.fillOval(x, y, 30, 30);
        //g2.setBackground(Color.RED);
        
      }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Space");
        GIF gif = new GIF();
        frame.add(gif);
        frame.setSize(600, 600);
        frame.setVisible(true);
        //      ImageIcon image=new ImageIcon("background.jpeg");
        //      JLabel label=new JLabel();
        //      label.setIcon(image);
        //      frame.add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            gif.move();
            gif.repaint();
            Thread.sleep(300);
        }
    }
}