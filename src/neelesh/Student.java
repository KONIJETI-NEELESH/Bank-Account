package neelesh;
import java.util.Scanner;
class StudentDetails
{
 int sno;
 String sname;
 int age;
 public void setData()
 {
  Scanner input = new Scanner(System.in);
  System.out.println("Enter Student ID:");
  sno = input.nextInt();
  input.nextLine();
  System.out.println("Enter Student Name:");
  sname = input.nextLine();
  System.out.println("Enter Student Age:");
  age = input.nextInt();
 }
 public void getData()
 {
  System.out.println("ID\tName\tAge");
  System.out.println(sno+"\t"+sname+"\t"+age);
 }
}
class Marks extends StudentDetails
{
 int m1,m2,m3,total;
 double avg;
 public void setInput()
 { 
  Scanner input = new Scanner(System.in);
  System.out.println("Enter the marks in Java:");
  m1 = input.nextInt();
  System.out.println("Enter the marks in Python:");
  m2 = input.nextInt();
  System.out.println("Enter the marks in C:");
  m3 = input.nextInt();
 }
 public void process()
 {
  total = m1 + m2 + m3;
  avg = total/3;
 }
}
class Result extends Marks
{
 String result;
 String grade;
 public void getResult()
 {
  if(m1>=35 && m2>=35 && m3>=35)
  {
   result = "Pass";
   if(avg>=75)
   {
    grade = "Distinction";
   }
   else if(avg>=60)
   {
	grade = "First Class";
   }
   else if(avg>=50)
   {
	grade = "Second Class";
   }
   else if(avg>=40)
   {
	grade = "Third Class";
   }
   else
   {
	grade = "Just Pass";
   }
  }
  else
  {
   result = "Fail";
   grade = "No Grade";
  }
 }
 public void display()
 {
  System.out.println("Total\t:\t"+total);
  System.out.println("Average\t:\t"+avg);
  System.out.println("Result\t:\t"+result);
  System.out.println("Grade\t:\t"+grade);
 }
}
public class Student 
{
 public static void main(String[] args) 
 {
  Result obj = new Result();
  obj.setData();
  obj.getData();
  obj.setInput();
  obj.process();
  obj.getResult();
  obj.display();
 }
}
