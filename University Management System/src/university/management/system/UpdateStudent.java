package university.management.system;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class UpdateStudent extends JFrame implements ActionListener{
    JTextField address, phoneNo, email, course;
    Choice rollNo;
    JLabel rollno;
    JButton submit, cancel;
    
    UpdateStudent(){
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(300, 10, 500, 50);
        heading.setFont(new Font("Serif",Font.BOLD, 30));
        add(heading);
        
        JLabel heading2 = new JLabel("Search By Roll Number");
        heading2.setBounds(50, 100, 200, 20);
        heading2.setFont(new Font("Serif",Font.PLAIN, 18));
        add(heading2);
        
        rollNo = new Choice();
        rollNo.setBounds(250, 100, 150, 20);
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
        lName.setBounds(50, 150, 100, 30);
        lName.setFont(new Font("Serif",Font.BOLD, 20));
        add(lName);
        
        JLabel name = new JLabel();
        name.setBounds(200, 150, 150, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(name);
        
        JLabel lFatherName = new JLabel("Father's Name");
        lFatherName.setBounds(400, 150, 200, 30);
        lFatherName.setFont(new Font("Serif",Font.BOLD, 20));
        add(lFatherName);
        
        JLabel fName = new JLabel();
        fName.setBounds(600, 150, 150, 30);
        fName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(fName);
        
        JLabel lGender = new JLabel("Gender");
        lGender.setBounds(50, 200, 150, 30);
        lGender.setFont(new Font("Serif",Font.BOLD, 20));
        add(lGender);
        
        JLabel gender = new JLabel();
        gender.setBounds(200, 200, 100, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(gender);
        
        JLabel lRoll = new JLabel("Roll Number");
        lRoll.setBounds(50, 250, 200, 30);
        lRoll.setFont(new Font("Serif",Font.BOLD, 20));
        add(lRoll);
        
        rollno = new JLabel();
        rollno.setBounds(200, 250, 200, 30);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(rollno);
        
        JLabel lDOB = new JLabel("Date Of Birth");
        lDOB.setBounds(400, 250, 200, 30);
        lDOB.setFont(new Font("Serif",Font.BOLD, 20));
        add(lDOB);
        
        JLabel dob = new JLabel();
        dob.setBounds(600, 250, 150, 30);
        dob.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
        
        JLabel X = new JLabel();
        X.setBounds(200, 400, 150, 30);
        X.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(X);
        
        JLabel lXII = new JLabel("Class XII (%)");
        lXII.setBounds(400, 400, 150, 30);
        lXII.setFont(new Font("Serif",Font.BOLD, 20));
        add(lXII);
        
        JLabel XII = new JLabel();
        XII.setBounds(600, 400, 150, 30);
        XII.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(XII);
        
        JLabel lAadhar = new JLabel("Aadhar Number");
        lAadhar.setBounds(50, 450, 200, 30);
        lAadhar.setFont(new Font("Serif",Font.BOLD, 20));
        add(lAadhar);
        
        JLabel aadhar = new JLabel();
        aadhar.setBounds(200, 450, 150, 30);
        aadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(aadhar);
        
        JLabel lCourse = new JLabel("Course");
        lCourse.setBounds(50, 500, 200, 30);
        lCourse.setFont(new Font("Serif",Font.BOLD, 20));
        add(lCourse);
        
        course = new JTextField();
        course.setBounds(200, 500, 200, 30);
        add(course);
        
        try{
            Con c = new Con();
            String query = "select * from student where rollno = '"+rollNo.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("name"));
                fName.setText(rs.getString("father_name"));
                gender.setText(rs.getString("gender"));
                rollno.setText(rs.getString("rollno"));
                dob.setText(rs.getString("dob"));
                address.setText(rs.getString("address"));
                email.setText(rs.getString("email"));
                phoneNo.setText(rs.getString("phoneno"));
                X.setText(rs.getString("class_x"));
                XII.setText(rs.getString("class_xii"));
                aadhar.setText(rs.getString("aadhar"));
                course.setText(rs.getString("course"));
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
                    gender.setText(rs.getString("gender"));
                    rollno.setText(rs.getString("rollno"));
                    dob.setText(rs.getString("dob"));
                    address.setText(rs.getString("address"));
                    email.setText(rs.getString("email"));
                    phoneNo.setText(rs.getString("phoneno"));
                    X.setText(rs.getString("class_x"));
                    XII.setText(rs.getString("class_xii"));
                    aadhar.setText(rs.getString("aadhar"));
                    course.setText(rs.getString("course"));
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
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
             String Rollno = rollno.getText();
             String Address = address.getText();
             String Phoneno = phoneNo.getText();
             String Email = email.getText();
             String Course = course.getText();
             
             try{
                 String query = "Update student set address = '"+Address+"',email ='"+Email+"', phoneno = '"+Phoneno+"', course = '"+Course+"' Where rollno = '"+ Rollno+"'";
                 Con c = new Con();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                 setVisible(false); 
             } catch(Exception e){
                 e.printStackTrace();
             }
             
         } else if(ae.getSource() == cancel){
             setVisible(false);
         }
    }
    public static void main(String [] args){
        new UpdateStudent();
    }
}
