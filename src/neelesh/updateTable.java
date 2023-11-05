package neelesh;
import java.sql.*;
import java.util.*;
public class updateTable 
{
 public static void main(String[] args) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement pst = conn.prepareStatement("update employee set ename=? where eid=?");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Employee ID:");
  int eid = sc.nextInt();
  sc.nextLine();
  System.out.println("Enter the Employee Name you need to update:");
  String ename = sc.nextLine();
  pst.setString(1, ename);
  pst.setInt(2, eid);
  pst.executeUpdate();
  System.out.println("Employee Name with Employee ID "+eid+" is updated successfully");
 }
}
