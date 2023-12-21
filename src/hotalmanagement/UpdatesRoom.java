
package hotalmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdatesRoom extends JFrame implements ActionListener
{
 Choice ccustomer;  
 JTextField tfroom,tfavailable,tfstatus; 
 JButton check,update,back;
 UpdatesRoom()
 {  
  getContentPane().setBackground(Color.WHITE);
  setLayout(null);
  
  JLabel text = new JLabel("Update Room Status");
  text.setFont(new Font("Tahoma",Font.PLAIN,25));
  text.setBounds(30,20,250,30);
  text.setForeground(Color.BLUE);
  add(text);
  
  JLabel lblid = new JLabel("Customer id");
  lblid .setBounds(30,80,100,20);
  add( lblid );
  
  ccustomer = new Choice();
  ccustomer.setBounds(200,80,150,25);
  add(ccustomer);
  
  try
  {
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from customer");
   while(rs.next())
   {
    ccustomer.add(rs.getString("number"));   
   }    
  }   
  catch(Exception e)
  {
   System.out.println(e);
  }    
  JLabel lblroom = new JLabel("Room Number");
  lblroom.setBounds(30,130,100,20);
  add(  lblroom );
  
  tfroom = new JTextField();
  tfroom.setBounds(200,130,150,25);
  add(tfroom );
  
   JLabel lblavailable = new JLabel("Availability");
   lblavailable.setBounds(30,180,100,20);
   add(lblavailable );
  
  tfavailable = new JTextField();
  tfavailable.setBounds(200,180,150,25);
  add(tfavailable );
  
   JLabel lblclean = new JLabel("Cleaning status");
   lblclean  .setBounds(30,230,100,20);
   add( lblclean   );
  
  tfstatus = new JTextField();
  tfstatus.setBounds(200,230,150,25);
  add( tfstatus );
    
      check = new JButton("Check");
      check.setBounds(30,300,100,30);
      check.setBackground(Color.BLACK);
      check.setForeground(Color.WHITE);
      check.addActionListener(this);
      add(check);
  
     update = new JButton("Update");
     update.setBounds(150,300,100,30);
     update.setBackground(Color.BLACK);
     update.setForeground(Color.WHITE);
     update.addActionListener(this);
     add(update);  
     
     back= new JButton("Back");
     back.setBounds(270,300,100,30);
     back.setBackground(Color.BLACK);
     back.setForeground(Color.WHITE);
     back.addActionListener(this);
     add(back); 
     
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/seventh.jpg"));
  Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(400, 50,500,300);
  add(image);     
     
  setBounds(300,200,980,450);
  setVisible(true);    
 }   
 public static void main(String arg[])
 {
   new UpdatesRoom();  
 }       

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    if(ae.getSource() == check){
     String id=ccustomer.getSelectedItem();
     String query = "select * from customer where number = '"+id+"'";
     
     try
     {
     Conn c=new Conn();
     ResultSet rs = c.s.executeQuery(query);
     while(rs.next())
     {
     tfroom.setText(rs.getString("room"));
     }  
     ResultSet rs1=c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
     while(rs1.next())
     {
       tfavailable.setText(rs1.getString("availability"));
       tfstatus.setText(rs1.getString("cleaning_status"));
     }    
     }
     catch(Exception e)
     {
        System.out.print(e);
     }   
    }  
    else if(ae.getSource() == update){
    String number=ccustomer.getSelectedItem(); 
    String room = tfroom.getText();
    String available = tfavailable.getText();
    String status =tfstatus.getText();
    
    try
    {
      Conn c= new Conn();
      c.s.executeUpdate("update room set availability = '"+available+"', cleaning_status= '"+status+"' where roomnumber = '"+room+"'");
     JOptionPane.showMessageDialog(null, "Data updated Successfully!");
     setVisible(false);
       new Reception();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }    
    }  
    else{
         setVisible(false);
       new Reception();   
    }
    }
}

