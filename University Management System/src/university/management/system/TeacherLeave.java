package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TeacherLeave extends JFrame implements ActionListener{
    Choice employeeID, time;
    JDateChooser date;
    JButton submit, cancel;
    
    TeacherLeave(){
        setSize(500, 550);
        setLayout(null);
        setLocation(550, 100);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel roll = new JLabel("Search By Teacher ID");
        roll.setBounds(60, 100, 200, 20);
        roll.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(roll);
        
        employeeID = new Choice();
        employeeID.setBounds(60, 130, 200, 20);
        add(employeeID);
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                employeeID.add(rs.getString("employee_id"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lDate = new JLabel("Date");
        lDate.setBounds(60, 180, 200, 20);
        lDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lDate);
        
        date = new JDateChooser();
        date.setBounds(60, 210, 200, 25);
        add(date);
        
        JLabel lTime = new JLabel("Time Duration");
        lTime.setBounds(60, 260, 200, 20);
        lTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lTime);
        
        time = new Choice();
        time.setBounds(60, 290, 200, 20);
        time.add("Full Day");
        time.add("Half Day");
        add(time);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 360, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(190, 360, 100, 25);
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
            String EmployeeID = employeeID.getSelectedItem();
            String Date = ((JTextField)date.getDateEditor().getUiComponent()).getText();
            String Duration = time.getSelectedItem();
            String query = "Insert into teacher_leave values('"+EmployeeID+"', '"+Date+"', '"+Duration+"')";
            try{
                Con c = new Con();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if(ae.getSource() == cancel){
            setVisible(false);
        } 
    }
    public static void main(String [] args){
        new TeacherLeave();
    }
}
