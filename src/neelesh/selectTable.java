package neelesh;
import java.sql.*;
import java.util.*;
public class selectTable 
{
 public static void main(String[] args) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement pst = conn.prepareStatement("select ename from employee where eid=1");
  ResultSet rs = pst.executeQuery();
//  int rs = pst.executeQuery();
//  System.out.println(rs.getObject(1));
//  System.out.println("EmployeeID\tEmployeeName\tEmployeeSalary");
  String s="";
  while(rs.next())
  {
	  s=rs.getString(1);
//	  System.out.println(rs.getInt(1));
//   System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDouble(3));
  }
  System.out.println(s);
 }
}
