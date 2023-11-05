package neelesh;
import java.util.*;
import java.sql.*;
public class insertExample 
{
 public static void main(String args[]) throws Exception 
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  do 
  {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter 1 for inserting a record:");
   System.out.println("Enter any key for exit");
   int choice = sc.nextInt();
   if(choice==1)
   {
	System.out.println("Enter Employee ID:");
	int eid = sc.nextInt();
	sc.nextLine();
	System.out.println("Enter Employee Name:");
	String ename = sc.nextLine();
	System.out.println("Enter Salary:");
	double salary = sc.nextDouble();
	PreparedStatement pst = conn.prepareStatement("insert into employee values(?,?,?)");
	pst.setInt(1,eid);
	pst.setString(2,ename);
	pst.setDouble(3,salary);
	pst.executeUpdate();
	System.out.println("Record with Employee ID "+eid+" is inserted successfully");
   }
   else
   {
	break;
   }
  }while(true);  
 }
}
