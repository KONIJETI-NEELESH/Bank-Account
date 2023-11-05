package neelesh;
import java.util.*;
import java.sql.*;
public class MainProject 
{
 public static void createTable() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  String query = "create table account(acno INT,acname VARCHAR(20),actype VARCHAR(20),balance INT)";
  Statement st = conn.createStatement();
  st.execute(query);
  System.out.println("Account Table is created successfully");
  String Query = "create table accountdetails(acno INT,acname VARCHAR(20),actype VARCHAR(20),credit INT,debit INT,balance INT)";
  Statement St = conn.createStatement();
  St.execute(Query);
  System.out.println("Account Details Table is created successfully");
  String QUERY = "create table bank(username INT,password VARCHAR(20))";
  Statement ST = conn.createStatement();
  ST.execute(QUERY);
  System.out.println("Bank Table is created successfully");
  PreparedStatement pst = conn.prepareStatement("insert into bank values(577,'neelesh')");
  pst.executeUpdate();
  PreparedStatement Pst = conn.prepareStatement("insert into bank values(540,'jithin')");
  Pst.executeUpdate();
  PreparedStatement PST = conn.prepareStatement("insert into bank values(500,'srikanth')");
  PST.executeUpdate();
  System.out.println("Bank records are created successfully");
 }
 public static void createAccount() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement pst = conn.prepareStatement("insert into Account values(?,?,?,?)");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Account Number:");
  int acno = sc.nextInt();
  sc.nextLine();
  System.out.println("Enter Account Name:");
  String acname = sc.nextLine();
  System.out.println("Enter Account Type:");
  String actype = sc.nextLine();
  System.out.println("Enter Account Balance:");
  int balance = sc.nextInt();
  pst.setInt(1, acno);
  pst.setString(2, acname);
  pst.setString(3, actype);
  pst.setInt(4, balance);
  pst.executeUpdate();
  System.out.println("Account with Account Number "+acno+" is inserted successfully");
  PreparedStatement Pst = conn.prepareStatement("insert into AccountDetails values(?,?,?,?,?,?)");
  Pst.setInt(1,acno);
  Pst.setString(2, acname);
  Pst.setString(3, actype);
  Pst.setInt(4, balance);
  Pst.setInt(5,0);
  Pst.setInt(6,balance);
  Pst.executeUpdate();
  System.out.println("AccountDetails with Account Number "+acno+" is updated successfully");
 }
 public static void displayTable() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement pst = conn.prepareStatement("select * from account");
  ResultSet rs = pst.executeQuery();
  System.out.println("AccountNo\tAccountName\tAccountType\tBalance");
  while(rs.next())
  {
   System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4));
  }
 }
 public static void deposit() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Account Number:");
  int acno = sc.nextInt();
  PreparedStatement ps = conn.prepareStatement("select distinct acno from account");
  ResultSet rs = ps.executeQuery();
  PreparedStatement  Ps = conn.prepareStatement("select count(*) from account");
  ResultSet Rs = Ps.executeQuery();
  int n=0;
  while(Rs.next())
  {
   n = Rs.getInt(1);
  }
  int a[] = new int[n];
  int i=0;
  while(rs.next())
  {
   a[i] = rs.getInt(1);
   i=i+1;
  }
  int s=0;
  for(i=0;i<a.length;i++)
  {
   if(a[i]==acno)
   {
	s=1;
	break;
   }
  }
  if(s==0)
  {
   System.out.println("Sorry! Account Number is not valid.");
  }
  else
  {
   System.out.println("Enter Amount you want to deposit:");
   int amount = sc.nextInt();  
   PreparedStatement pst = conn.prepareStatement("select * from account where acno=?");
   pst.setInt(1, acno);
   ResultSet r = pst.executeQuery();
   String acname="";
   String actype="";
   int balance=0;
   while(r.next())
   {
	 acname = r.getString(2);
	 actype = r.getString(3);
	 balance = r.getInt(4);
   }
   PreparedStatement Pst = conn.prepareStatement("insert into accountdetails values(?,?,?,?,?,?)");
   Pst.setInt(1,acno);
   Pst.setString(2,acname);
   Pst.setString(3,actype);
   Pst.setInt(4,amount);
   Pst.setInt(5,0);
   Pst.setInt(6,amount+balance);
   Pst.executeUpdate();
   PreparedStatement PST = conn.prepareStatement("update account set balance=? where acno=?");
   PST.setInt(1, amount+balance);
   PST.setInt(2, acno);
   PST.executeUpdate();
   System.out.println(amount+" is deposited to Account Number "+acno+" successfully");
  } 
 }
 public static void withdraw() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Account Number:");
  int acno = sc.nextInt();
  PreparedStatement ps = conn.prepareStatement("select distinct acno from account");
  ResultSet rs = ps.executeQuery();
  PreparedStatement  Ps = conn.prepareStatement("select count(*) from account");
  ResultSet Rs = Ps.executeQuery();
  int n=0;
  while(Rs.next())
  {
   n = Rs.getInt(1);
  }
  int a[] = new int[n];
  int i=0;
  while(rs.next())
  {
   a[i] = rs.getInt(1);
   i=i+1;
  }
  int s=0;
  for(i=0;i<a.length;i++)
  {
   if(a[i]==acno)
   {
	s=1;
	break;
   }
  }
  if(s==0)
  {
   System.out.println("Sorry! Account Number is not valid.");
  }
  else
  {
   PreparedStatement pst = conn.prepareStatement("select balance from account where acno=?");
   pst.setInt(1, acno);
   ResultSet r = pst.executeQuery();
   int balance=0;
   while(r.next())
   {
    balance = r.getInt(1);
   }
   System.out.println("Enter the amount you want to withdraw:");
   int amount = sc.nextInt(); 
   if(balance<amount)
   {
	System.out.println("Insufficient Amount");   
   }
   else
   {
	PreparedStatement Pst = conn.prepareStatement("update account set balance=? where acno=?");
	Pst.setInt(1, balance-amount);
	Pst.setInt(2,acno);
	Pst.executeUpdate();
	PreparedStatement st = conn.prepareStatement("select * from account where acno=?");
	st.setInt(1, acno);
	ResultSet R = st.executeQuery();
	String acname="";
    String actype="";
    while(R.next())
	{
	 acname = R.getString(2);
     actype = R.getString(3);
	}
	PreparedStatement PST = conn.prepareStatement("insert into accountdetails values(?,?,?,?,?,?)");
    PST.setInt(1,acno);
	PST.setString(2,acname);
	PST.setString(3,actype);
    PST.setInt(4,0);
	PST.setInt(5,amount);
    PST.setInt(6,balance-amount);
	PST.executeUpdate();
	System.out.println("Withdraw Successfull!");
   }
  }
 }
 public static void MiniStatement() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Account Number:");
  int acno = sc.nextInt();
  PreparedStatement ps = conn.prepareStatement("select distinct acno from account");
  ResultSet RS = ps.executeQuery();
  PreparedStatement  Ps = conn.prepareStatement("select count(*) from account");
  ResultSet Rs = Ps.executeQuery();
  int n=0;
  while(Rs.next())
  {
   n = Rs.getInt(1);
  }
  int a[] = new int[n];
  int i=0;
  while(RS.next())
  {
   a[i] = RS.getInt(1);
   i=i+1;
  }
  int s=0;
  for(i=0;i<a.length;i++)
  {
   if(a[i]==acno)
   {
	s=1;
	break;
   }
  }
  if(s==0)
  {
   System.out.println("Sorry! Account Number is not valid.");
  }
  else
  {
   PreparedStatement pst = conn.prepareStatement("select * from accountdetails where acno=?");
   pst.setInt(1, acno);
   ResultSet rs = pst.executeQuery();
   System.out.println("AccountNo\tAccountName\tAccountType\tDebit\tCredit\tBalance");
   while(rs.next())
   {
    System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6));
   }
  }
 }
 public static void checkBalance() throws Exception
 {
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter Account Number:");
  int acno = sc.nextInt();
  PreparedStatement ps = conn.prepareStatement("select distinct acno from account");
  ResultSet rs = ps.executeQuery();
  PreparedStatement  Ps = conn.prepareStatement("select count(*) from account");
  ResultSet Rs = Ps.executeQuery();
  int n=0;
  while(Rs.next())
  {
   n = Rs.getInt(1);
  }
  int a[] = new int[n];
  int i=0;
  while(rs.next())
  {
   a[i] = rs.getInt(1);
   i=i+1;
  }
  int s=0;
  for(i=0;i<a.length;i++)
  {
   if(a[i]==acno)
   {
	s=1;
	break;
   }
  }
  if(s==0)
  {
   System.out.println("Sorry! Account Number is not valid.");
  }
  else
  {	  
   PreparedStatement pst = conn.prepareStatement("select balance from account where acno=?");
   pst.setInt(1, acno);
   ResultSet RS = pst.executeQuery();
   int balance=0;
   while(RS.next())
   {
    balance = RS.getInt(1);
   }
   System.out.println("The Balance of your account with Account Number "+acno+" is "+balance);
  }
 }
 public static void main(String[] args) throws Exception 
 { 
//  createTable();
  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","k.neelesh009");
  PreparedStatement PST = conn.prepareStatement("select count(*) from bank");
  ResultSet RS = PST.executeQuery();
  int n=0;
  while(RS.next())
  {
   n=RS.getInt(1);
  }
  int a[] = new int[n];
  PreparedStatement pst = conn.prepareStatement("select distinct username from bank");
  ResultSet rs = pst.executeQuery();
  int i=0;
  while(rs.next())
  {
   a[i] = rs.getInt(1);
   i=i+1;
  }
  Scanner SC = new Scanner(System.in);
  System.out.println("Enter Username:");
  int username = SC.nextInt();
  SC.nextLine();
  System.out.println("Enter Password:");
  String password = SC.nextLine();
  for(i=0;i<a.length;i++)
  {
   if(a[i]==username)
   {
	PreparedStatement ps = conn.prepareStatement("select password from bank where username=?");
	ps.setInt(1, username);
	ResultSet r = ps.executeQuery();
	String pass="";
	while(r.next())
	{
	 pass = r.getString(1);
	}
	if(pass.equals(password))
	{
	 do
	 {
	  Scanner sc = new Scanner(System.in);
      System.out.println("Choose your option:");
	  System.out.println("1.Insert 2.Display 3.Deposit 4.Withdraw 5.Mini Statement 6.Balance 7.Exit");
	  int choice = sc.nextInt();
      switch(choice)
      {
	   case 1:
		   createAccount();
		   break;
	   case 2:
		   displayTable();
		   break;
	   case 3:
		   deposit();
		   break;
	   case 4:
		   withdraw();
		   break;
	   case 5:
		   MiniStatement();
		   break;
	   case 6:
		   checkBalance();
		   break;
	   case 7:
		   System.exit(0);
	   default:
		   System.out.println("Please Enter correct choice");
	   }
	  }while(true);	
	}
	else
	{
	 System.out.println("Password is incorrect!");
	 System.exit(0);
	}
   }
  }
  System.out.println("Invalid Username!");
 }
} 