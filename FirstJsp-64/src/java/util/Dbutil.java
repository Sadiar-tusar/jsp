
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Dbutil {
    
    private static Connection connection=null;
    private static String url="jdbc:mysql://localhost:3306/jsp";
    private static String user="root";
    private static String password="1234";
    private static String driver="com.mysql.cj.jdbc.Driver";
    
    public Connection getCon(){
    
        try {
            Class.forName(driver);
            
            connection=DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbutil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbutil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
}
