package university.management.system;

import java.sql.*;

public class Con {
    
    Connection c;
    Statement s;
    
    Con(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_management_system", "root", "7266194@MySql");
            s = c.createStatement();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
