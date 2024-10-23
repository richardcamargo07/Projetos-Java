package DAO;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDAO {
   
    public Connection conectBD(){
         Connection conn = null;
         
         try {
            String url = "jdbc:mysql://localhost:3306/javabd";
            String user = "root";
            String password ="";
            conn = DriverManager.getConnection(url, user, password);
                    
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "ConnectionDAO" + erro.getMessage());
        }
         return conn;
    }
}
