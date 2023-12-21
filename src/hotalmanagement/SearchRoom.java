
package hotalmanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener
{
 JTable table;   
 JButton back,submit;
 JComboBox bedType;
 JCheckBox available;
 SearchRoom()
 {
  getContentPane().setBackground(Color.WHITE);
  setLayout(null);
 
  
  JLabel text = new JLabel("Search Room");
  text.setFont(new Font("Tahoma",Font.PLAIN,20));
  text.setBounds(400,30,200,30);
  add(text);
  
  JLabel lblbed = new JLabel("Bed Type");
  lblbed.setBounds(50,100,100,20);
  add( lblbed);
  
    bedType= new JComboBox(new String[]{"Single Bed","Double Bed"});
    bedType.setBounds(150,100,150,25);
    bedType.setBackground(Color.WHITE);
    add( bedType);
  
    available = new JCheckBox("Only display Available");
    available.setBounds(650,100,150,25);
    available.setBackground(Color.WHITE);
    add(available);
    
    
    
    
  JLabel l1 = new JLabel("Room Number");
  l1.setBounds(50,160,100,20);
  add(l1);
  
  JLabel l2 = new JLabel("Availibility");
  l2.setBounds(270,160,100,20);
  add(l2);
  
  JLabel l3 = new JLabel("Cleaning status");
  l3.setBounds(450,160,100,20);
  add(l3);
  
  JLabel l4 = new JLabel("Price");
  l4.setBounds(670,160,100,20);
  add(l4);
  
  JLabel l5 = new JLabel("Bed Type");
  l5.setBounds(870,160,100,20);
  add(l5);
  
  table = new JTable();
  table.setBounds(0,200,1000,300);
  add(table);
  
  try
  {
  Conn c =new Conn();
  ResultSet rs = c.s.executeQuery("select * from room");
 table.setModel(DbUtils.resultSetToTableModel(rs));
  }  
  catch(Exception e)
  {
    e.printStackTrace();
  }   
  
      submit = new JButton("Submit");
      submit.setBounds(300,500,110,30);
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      add( submit);
   
   back = new JButton("Back");
   back.setBounds(500,500,110,30);
   back.setBackground(Color.BLACK);
   back.setForeground(Color.WHITE);
   back.addActionListener(this);
   add( back); 


  setBounds(300,200,1000,600);
  setVisible(true);     
 }   
 public static void main(String arg[])
 {
     new SearchRoom();
 }       

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == submit){
          try
          {
           String s1="select * from room where bed_type = '"+bedType.getSelectedItem()+"'";   
          String s2="select * from room where availability  = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";
          Conn con=new Conn();
          ResultSet rs;
          if(available.isSelected())
          {
           rs=con.s.executeQuery(s2);
          } 
          else
          {
           rs=con.s.executeQuery(s1);    
          }
          table.setModel(DbUtils.resultSetToTableModel(rs));
          }
          catch(Exception e)
          {
              System.out.print(e);
          }
        }
        else
        {
       setVisible(false);
       new Reception();
    }}
}

