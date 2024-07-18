
package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StudentFeeForm extends JFrame implements ActionListener{
    
    Choice rollNo;
    JComboBox course, semester;
    JLabel total;
    JButton update, pay, cancel;
    
    StudentFeeForm(){
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(400, 50, 500, 300);
        add(j1);
        
        JLabel heading = new JLabel("Fee Submit Page");
        heading.setBounds(50, 5, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD, 30));
        add(heading);
        
        JLabel heading2 = new JLabel("Search By Roll No.");
        heading2.setBounds(40, 70, 150, 20);
        heading2.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(heading2);
        
        rollNo = new Choice();
        rollNo.setBounds(200, 70, 150, 20);
        add(rollNo);
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                rollNo.add(rs.getString("rollno"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lName = new JLabel("Name");
        lName.setBounds(40, 110, 150, 20);
        lName.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lName);
        
        JLabel name = new JLabel();
        name.setBounds(200, 110, 150, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        JLabel lFatherName = new JLabel("Father's Name");
        lFatherName.setBounds(40, 150, 150, 20);
        lFatherName.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lFatherName);
        
        JLabel fName = new JLabel();
        fName.setBounds(200, 150, 150, 20);
        fName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fName);
        
        try{
            Con c = new Con();
            String query = "select * from student where rollno = '"+rollNo.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("name"));
                fName.setText(rs.getString("father_name"));
                
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        rollNo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Con c = new Con();
                    String query = "select * from student where rollno = '"+rollNo.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                    name.setText(rs.getString("name"));
                    fName.setText(rs.getString("father_name"));
                    
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lCourse = new JLabel("Course");
        lCourse.setBounds(40, 190, 150, 20);
        lCourse.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lCourse);
        
        String [] courses = {"BTech", "BCA", "B.Sc", "BBA", "BCom", "BA", "B.Ed", "MTech", "MCA", "MSc", "MBA", "MCom", "MA", "M.Ed", "PhD"};
        course = new JComboBox(courses);
        course.setBounds(200, 190, 150, 20);
        course.setBackground(Color.WHITE);
        add(course);
        
        JLabel lSelectSemester = new JLabel("Semester");
        lSelectSemester.setBounds(40, 230, 150, 20);
        lSelectSemester.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lSelectSemester);
        
        String sem[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
        semester = new JComboBox(sem);
        semester.setBounds(200, 230, 150, 20);
        semester.setBackground(Color.WHITE);
        add(semester);
        
        JLabel lTotal = new JLabel("Total Fees");
        lTotal.setBounds(40, 280, 150, 20);
        lTotal.setFont(new Font("Tahoma",Font.BOLD, 16));
        add(lTotal);
        
        total = new JLabel();
        total.setBounds(200, 280, 150, 20);
        total.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(total);
        
        update = new JButton("Update");
        update.setBounds(40, 360, 110, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.PLAIN, 12));
        update.addActionListener(this);
        add(update);
        
        pay = new JButton("Pay Fee");
        pay.setBounds(160, 360, 110, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma", Font.PLAIN, 12));
        pay.addActionListener(this);
        add(pay);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 110, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String Course = (String)course.getSelectedItem();
            String Semester = (String)semester.getSelectedItem();
            
            String query = "Select * from fee where course ='"+Course+"'";
            
            try{
                Con c = new Con();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    total.setText(rs.getString(Semester));
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == pay){
            if((total.getText()).equals("")){
                JOptionPane.showMessageDialog(null, "Select the Semester and Click on Update Button");
                return;
            }
            String Rollno = rollNo.getSelectedItem();
            String Course = (String)course.getSelectedItem();
            String Semester = (String)semester.getSelectedItem();
            String Total = total.getText();
            
            try{
                Con c = new Con();
                String query = "Insert into college_fee values('"+Rollno+"','"+Course+"','"+Semester+"','"+Total+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Fee Paid Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new StudentFeeForm();
    }
}
