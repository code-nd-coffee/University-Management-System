package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{
    JButton cancel;
    About(){
        setSize(700, 500);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 175, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(400, 0, 300, 200);
        add(j1);
        
        JLabel heading = new JLabel("<html>University <br> Management System</html>");
        heading.setBounds(70, 30, 500, 130);
        heading.setFont(new Font("Tahoma",Font.BOLD, 30));
        add(heading);
        
        JLabel dev = new JLabel("Developed By: Shivam");
        dev.setBounds(70, 220, 500, 40);
        dev.setFont(new Font("Tahoma",Font.BOLD, 30));
        add(dev);
        
        JLabel email = new JLabel("Contact: shivam7266194@gmail.com");
        email.setBounds(70, 280, 500, 40);
        email.setFont(new Font("Tahoma",Font.PLAIN, 25));
        add(email);
        
        JLabel logo = new JLabel("Code & Coffee");
        logo.setBounds(250, 370, 500, 40);
        logo.setFont(new Font("Serif",Font.PLAIN, 25));
        add(logo);
         
        cancel = new JButton("Back");
        cancel.setBounds(850, 10, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String [] args){
        new About();
    }
}
