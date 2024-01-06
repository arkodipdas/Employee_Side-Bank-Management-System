
package firstapplication;

import java.sql.*;
import java.sql.Statement;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
           
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234567890");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
    
}
