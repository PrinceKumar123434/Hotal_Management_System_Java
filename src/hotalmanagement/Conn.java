
package hotalmanagement;
import java.sql.*;
public class Conn
{
  Connection c;
  Statement s;
 Conn()
 {
  try
  {
   Class.forName("com.mysql.cj.jdbc.Driver");
  c = DriverManager.getConnection("Jdbc:mysql://localhost:3306/hotal","root","");
  s=c.createStatement();
   
  }
  catch(Exception e)
  {
      System.out.println(e);
  }   
 }   
public static void main(String arg[])
{
 new Conn();   
}       
}
