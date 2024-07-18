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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{
    JLabel userName, userPassword;
    JTextField name;
    JPasswordField password;
    JButton login, cancel;
    Login(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        userName = new JLabel("Username: ");
        userName.setBounds(40, 20, 100, 20);
        add(userName);
        
        name = new JTextField();
        name.setBounds(150, 20, 150, 20);
        add(name);
        
        userPassword = new JLabel("Password: ");
        userPassword.setBounds(40, 70, 100, 20);
        add(userPassword);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 20);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 100, 25);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 12));
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(350, 00, 200, 200);
        add(j1);
        
        setSize(600, 300);
        setLocation(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
            String userName = name.getText();
            String pass = password.getText();
            
            String query = "Select * from login where username = '"+userName+ "' and password = '"+pass+"'";
            try{
                Con c = new Con();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Project();
                    setVisible(false);
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                c.s.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource()== cancel){
            System.exit(0);
        }
        
    }
    public static void main(String[] args){
        new Login();
    }
}
