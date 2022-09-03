
package bank.management;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    PreparedStatement ps = null;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","toneri");
            s=c.createStatement();
            
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
    public Conn(String query){
         try{
            
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","toneri");
            s=c.createStatement();
            ps = c.prepareStatement(query);
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }
}
