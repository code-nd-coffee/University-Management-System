package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnterMarks extends JFrame implements ActionListener{
    Choice rollno;
    JComboBox semester;
    JTextField sub1, sub2, sub3, sub4, sub5, marks1, marks2, marks3, marks4, marks5; 
    JButton submit, cancel;
    
    EnterMarks(){
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(500, 40, 400, 300);
        add(j1);
        
        JLabel heading = new JLabel("Enter Marks Of Student");
        heading.setBounds(90, 0, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD, 24));
        add(heading);
        
        JLabel lRollno = new JLabel("Select Roll Number");
        lRollno.setBounds(50, 70, 150, 20);
        add(lRollno);
        
        rollno = new Choice();
        rollno.setBounds(200, 70, 150, 20);
        add(rollno);
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                rollno.add(rs.getString("rollno"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lSelectSemester = new JLabel("Select Your Semester");
        lSelectSemester.setBounds(50, 120, 150, 20);
        add(lSelectSemester);
        
        String sem[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        semester = new JComboBox(sem);
        semester.setBounds(200, 120, 150, 20);
        semester.setBackground(Color.WHITE);
        add(semester);
        
        JLabel lEnterSubject = new JLabel("Enter Subject");
        lEnterSubject.setBounds(100, 160, 200, 40);
        add(lEnterSubject);
        
        JLabel lEnterMarks = new JLabel("Enter Marks");
        lEnterMarks.setBounds(320, 160, 200, 40);
        add(lEnterMarks);
        
        sub1 = new JTextField();
        sub1.setBounds(50, 200, 200, 20);
        add(sub1);
        
        sub2 = new JTextField();
        sub2.setBounds(50, 230, 200, 20);
        add(sub2);
        
        sub3 = new JTextField();
        sub3.setBounds(50, 260, 200, 20);
        add(sub3);
        
        sub4 = new JTextField();
        sub4.setBounds(50, 290, 200, 20);
        add(sub4);
        
        sub5 = new JTextField();
        sub5.setBounds(50, 320, 200, 20);
        add(sub5);
        
        marks1 = new JTextField();
        marks1.setBounds(250, 200, 200, 20);
        add(marks1);
        
        marks2 = new JTextField();
        marks2.setBounds(250, 230, 200, 20);
        add(marks2);
        
        marks3 = new JTextField();
        marks3.setBounds(250, 260, 200, 20);
        add(marks3);
        
        marks4 = new JTextField();
        marks4.setBounds(250, 290, 200, 20);
        add(marks4);
        
        marks5 = new JTextField();
        marks5.setBounds(250, 320, 200, 20);
        add(marks5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Con c = new Con();
                String query1 = "Insert into subject values ('"+rollno.getSelectedItem()+"','"+semester.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"', '"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String query2 = "Insert into marks values ('"+rollno.getSelectedItem()+"','"+semester.getSelectedItem()+"','"+marks1.getText()+"','"+marks2.getText()+"', '"+marks3.getText()+"','"+marks4.getText()+"','"+marks5.getText()+"')";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
                
            } catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new EnterMarks();
    }
}
