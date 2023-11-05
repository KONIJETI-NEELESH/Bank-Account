package neelesh;
import java.sql.*;
public class JDBCConnection 
{
 public static void main(String[] args) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
   if(conn!=null)
   {
    System.out.println("Connection is established");
   }
   else 
   {
    System.out.println("Connection not established");   
   }
 }
}
