package university.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JOptionPane;

public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    
    ExaminationDetails(){
        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 25, 400, 50);
        heading.setFont(new Font("Tahoma",Font.BOLD, 24));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Submit");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        cancel.addActionListener(this);
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);
        
        try{
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 3).toString());
            }
        });
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            if((search.getText()).equals("")){
                JOptionPane.showMessageDialog(null, "Select Your Roll Number");
                return;
            }
            new Marks(search.getText());
            setVisible(false);
        } else {
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new ExaminationDetails();
    }
}
