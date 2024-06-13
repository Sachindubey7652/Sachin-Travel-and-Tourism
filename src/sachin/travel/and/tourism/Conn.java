package sachin.travel.and.tourism;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author SACHIN DUBEY
 */
public class Conn {
    Connection connection;
    Statement s;
    Conn()  {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Database URL
        String url = "jdbc:mysql://localhost:3306/sachintravelandtourism";

        // Database ccredentials
        String username = "root";
        String password = "Hardest@321";

        // Establish Connection
        
        connection = DriverManager.getConnection(url, username, password);
             s= connection.createStatement();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
    
