package neelesh;
import java.sql.*;
public class createTable 
{
 public static void main(String[] args) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  String query = "create table employee(eid INT,ename VARCHAR(20),salary INT)";
  Statement st = conn.createStatement();
  st.execute(query);
  System.out.println("Employee Table is created successfully"); 
 }
}
