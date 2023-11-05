package neelesh;
import java.util.*;
import java.sql.*;
public class deleteRecord 
{
 public static void main(String[] args) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement pst = conn.prepareStatement("delete from employee where eid=?");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Employee ID to delete a record:");
  int eid = sc.nextInt();
  pst.setInt(1, eid);
  pst.executeUpdate();
  System.out.println("Record with Employee ID "+eid+" is deleted successfully");
 }
}
