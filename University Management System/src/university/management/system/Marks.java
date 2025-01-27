package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;


public class Marks extends JFrame implements ActionListener{
    String rollno;
    JButton cancel;
    
    Marks(String rollno) {
        this.rollno = rollno;
        
        setSize(500, 600);
        setLocation(500, 100);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Indian Institude Of Technology");
        heading.setBounds(60, 10, 500, 25);
        heading.setFont(new Font("Tahoma",Font.BOLD, 22));
        add(heading);
        
        JLabel subHeading = new JLabel("Result Of Examination");
        subHeading.setBounds(120, 50, 500, 18);
        subHeading.setFont(new Font("Tahoma",Font.BOLD, 18));
        add(subHeading);
        
        JLabel lRollno = new JLabel("Roll Number "+ rollno);
        lRollno.setBounds(60, 100, 500, 20);
        lRollno.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(lRollno);
        
        JLabel lSemester = new JLabel();
        lSemester.setBounds(60, 130, 500, 20);
        lSemester.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(lSemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Serif",Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Serif",Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Serif",Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Serif",Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Serif",Font.PLAIN, 18));
        add(sub5);
        
        try{
            Con c = new Con();
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5")); 
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5")); 
                
                lSemester.setText(rs2.getString("semester"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 450, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        new ExaminationDetails();
        setVisible(false);
    }
    public static void main(String []args){
        new Marks("");
    }
    
}
