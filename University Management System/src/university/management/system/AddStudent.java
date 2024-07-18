package university.management.system;

import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class AddStudent extends JFrame implements ActionListener{
    JTextField name, fName, address, phoneNo, email, X, XII, aadhar;
    JLabel rollno;
    JDateChooser dob;
    JRadioButton b1, b2, b3, b4;
    ButtonGroup gb;
    JComboBox course;
    JButton submit, cancel;
    
    Random random = new Random();
    long first4 = Math.abs((random.nextLong() % 9000L) + 1000L);
    
    AddStudent(){
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD, 30));
        add(heading);
        
        JLabel lName = new JLabel("Name");
        lName.setBounds(50, 150, 100, 30);
        lName.setFont(new Font("Serif",Font.BOLD, 20));
        add(lName);
        
        name = new JTextField();
        name.setBounds(200, 150, 150, 30);
        add(name);
        
        JLabel lFatherName = new JLabel("Father's Name");
        lFatherName.setBounds(400, 150, 200, 30);
        lFatherName.setFont(new Font("Serif",Font.BOLD, 20));
        add(lFatherName);
        
        fName = new JTextField();
        fName.setBounds(600, 150, 150, 30);
        add(fName);
        
        JLabel lGender = new JLabel("Gender");
        lGender.setBounds(50, 200, 150, 30);
        lGender.setFont(new Font("Serif",Font.BOLD, 20));
        add(lGender);
        
        b1 = new JRadioButton("Male");
        b1.setBounds(200, 200, 100, 30);
        b1.setFont(new Font("Serif",Font.PLAIN, 18));
        add(b1);
        
        b2 = new JRadioButton("Female");
        b2.setBounds(320, 200, 100, 30);
        b2.setFont(new Font("Serif",Font.PLAIN, 18));
        add(b2);
        
        b3 = new JRadioButton("Trans");
        b3.setBounds(440, 200, 100, 30);
        b3.setFont(new Font("Serif",Font.PLAIN, 18));
        add(b3);
        
        b4 = new JRadioButton("Others");
        b4.setBounds(560, 200, 100, 30);
        b4.setFont(new Font("Serif",Font.PLAIN, 18));
        add(b4);
        
        gb = new ButtonGroup();
        gb.add(b1);
        gb.add(b2);
        gb.add(b3);
        gb.add(b4);
        
        JLabel lRoll = new JLabel("Roll Number");
        lRoll.setBounds(50, 250, 200, 30);
        lRoll.setFont(new Font("Serif",Font.BOLD, 20));
        add(lRoll);
        
        rollno = new JLabel("1267" + first4);
        rollno.setBounds(200, 250, 200, 30);
        rollno.setFont(new Font("Serif",Font.PLAIN, 20));
        add(rollno);
        
        JLabel lDOB = new JLabel("Date Of Birth");
        lDOB.setBounds(400, 250, 200, 30);
        lDOB.setFont(new Font("Serif",Font.BOLD, 20));
        add(lDOB);
        
        dob = new JDateChooser();
        dob.setBounds(600, 250, 150, 30);
        add(dob);
        
        JLabel lAddress = new JLabel("Address");
        lAddress.setBounds(50, 300, 100, 30);
        lAddress.setFont(new Font("Serif",Font.BOLD, 20));
        add(lAddress);
        
        address = new JTextField();
        address.setBounds(200, 300, 300, 30);
        add(address);
        
        JLabel lPhoneNo = new JLabel("Phone Number");
        lPhoneNo.setBounds(400, 350, 200, 30);
        lPhoneNo.setFont(new Font("Serif",Font.BOLD, 20));
        add(lPhoneNo);
        
        phoneNo = new JTextField();
        phoneNo.setBounds(600, 350, 150, 30);
        add(phoneNo);
        
        JLabel lEmail = new JLabel("Email");
        lEmail.setBounds(50, 350, 100, 30);
        lEmail.setFont(new Font("Serif",Font.BOLD, 20));
        add(lEmail);
        
        email = new JTextField();
        email.setBounds(200, 350, 150, 30);
        add(email);
        
        JLabel lX = new JLabel("Class X (%)");
        lX.setBounds(50, 400, 200, 30);
        lX.setFont(new Font("Serif",Font.BOLD, 20));
        add(lX);
        
        X = new JTextField();
        X.setBounds(200, 400, 150, 30);
        add(X);
        
        JLabel lXII = new JLabel("Class XII (%)");
        lXII.setBounds(400, 400, 150, 30);
        lXII.setFont(new Font("Serif",Font.BOLD, 20));
        add(lXII);
        
        XII = new JTextField();
        XII.setBounds(600, 400, 150, 30);
        add(XII);
        
        JLabel lAadhar = new JLabel("Aadhar Number");
        lAadhar.setBounds(50, 450, 200, 30);
        lAadhar.setFont(new Font("Serif",Font.BOLD, 20));
        add(lAadhar);
        
        aadhar = new JTextField();
        aadhar.setBounds(200, 450, 150, 30);
        add(aadhar);
        
        JLabel lCourse = new JLabel("Course");
        lCourse.setBounds(50, 500, 200, 30);
        lCourse.setFont(new Font("Serif",Font.BOLD, 20));
        add(lCourse);
        
        String [] courses = {"B.Tech", "BCA", "B.Sc", "BBA", "B.Com", "BA", "B.Ed", "M.Tech", "MCA", "M.Sc", "MBA", "M.Com", "MA", "M.Ed", "PhD"};
        course = new JComboBox(courses);
        course.setBounds(200, 500, 200, 30);
        course.setBackground(Color.WHITE);
        add(course);
        
        submit = new JButton("Submit");
        submit.setBounds(300, 580, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 580, 100, 30);
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
             String Name = name.getText();
             String Fname = fName.getText();
             String Gender = null;
            if (b1.isSelected()){
                Gender = "Male";
            } else if (b2.isSelected()) {
                Gender = "Female";
            } else if (b3.isSelected()) {
                Gender = "Trans";
            } else {
                Gender = "Others";
            }
             String Rollno = rollno.getText();
             String DOB = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
             String Address = address.getText();
             String Phoneno = phoneNo.getText();
             String Email = email.getText();
             String x = X.getText();
             String xii = XII.getText();
             String Aadhar = aadhar.getText();
             String Course = (String)course.getSelectedItem();
             
             try{
                 String query = "Insert into student values('"+Name+"','"+Fname+"','"+Gender+"','"+Rollno+"','"+DOB+"','"+Address+"','"+Email+"','"+Phoneno+"','"+x+"','"+xii+"','"+Aadhar+"','"+Course+"')";
                 Con c = new Con();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Student Details Submitted Successfully");
                 setVisible(false); 
             } catch(Exception e){
                 e.printStackTrace();
             }
             
         } else if(ae.getSource() == cancel){
             setVisible(false);
         }
    }
    public static void main(String [] args){
        new AddStudent();
    }
}
