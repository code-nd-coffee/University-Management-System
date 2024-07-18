package university.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class StudentLeaveDetails extends JFrame implements ActionListener{
    
    Choice rollNo;
    JTable table;
    JButton search, print, cancel;
    
    StudentLeaveDetails(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Search By Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        rollNo = new Choice();
        rollNo.setBounds(180, 20, 150, 20);
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
        
        table = new JTable();
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from student_leave");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(270, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(370, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(470, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(913, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "Select * from student_leave where rollno = '"+rollNo.getSelectedItem()+"'";
            try{
                Con c = new Con();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() == cancel){
            setVisible(false);
        }
        
    }
    public static void main(String []args){
        new StudentLeaveDetails();
    }
    
}
