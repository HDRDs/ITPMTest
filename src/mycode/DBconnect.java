
package mycode;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class DBconnect {
    
    public static Connection connect(){
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itprojdb","root","");
            
        }
        catch (Exception e){
            
            System.out.println(e);
            
        }
        
        
        return con;
    }
    
}
