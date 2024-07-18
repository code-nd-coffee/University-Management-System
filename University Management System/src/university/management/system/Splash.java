package university.management.system;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        add(j1);
        
        t = new Thread(this);
        t.start();
        
        setVisible(true);
        
        for(int i = 2,x = 1; i <= 600; i += 4, x++){
            setSize((i + 3 * x) - 30, i + x/2);
            setLocation(600 - ((i + x)/2), 350 - (i /2));
            try{
                Thread.sleep(10);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
              
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        new Splash();
    }

    

}
