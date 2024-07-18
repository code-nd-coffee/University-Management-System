package university.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1540, 850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        add(j1);
        
        JMenuBar mb = new JMenuBar();
        
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);
        
        
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        
        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);
        
        
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);
        
        
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examinationResult = new JMenuItem("Examination Result");
        examinationResult.setBackground(Color.WHITE);
        examinationResult.addActionListener(this);
        exam.add(examinationResult);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        
        JMenu updateDetails = new JMenu("Update Details");
        updateDetails.setForeground(Color.RED);
        mb.add(updateDetails);
        
        JMenuItem facultyUpdateDetails = new JMenuItem("Update Faculty Details");
        facultyUpdateDetails.setBackground(Color.WHITE);
        facultyUpdateDetails.addActionListener(this);
        updateDetails.add(facultyUpdateDetails);
        
        JMenuItem studentUpdateDetails = new JMenuItem("Update Student Details");
        studentUpdateDetails.setBackground(Color.WHITE);
        studentUpdateDetails.addActionListener(this);
        updateDetails.add(studentUpdateDetails);
        
        
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);
        
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            System.exit(0);
        } else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        } else if(msg.equals("New Student Information")){
            new AddStudent();
        } else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        } else if(msg.equals("View Student Details")){
            new StudentDetails();
        } else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        } else if(msg.equals("Student Leave")){
            new StudentLeave();
        } else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        } else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        } else if(msg.equals("Examination Result")){
            new ExaminationDetails();
        } else if(msg.equals("Enter Marks")){
            new EnterMarks();
        } else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        } else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        } else if(msg.equals("Fee Structure")){
            new FeeStructure();
        } else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        } else if(msg.equals("About")){
            new About();
        } 
        
    }
    public static void main(String [] args){
        new Project();
    }
    
}
