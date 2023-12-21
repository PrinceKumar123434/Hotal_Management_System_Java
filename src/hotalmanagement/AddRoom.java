
package hotalmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRoom extends JFrame implements ActionListener
{
   JTextField tfroom, tfprice;
   JButton add,cancel;
   JComboBox typecombo,availablecombo,cleancombo; 
    
  AddRoom()
  {
   getContentPane().setBackground(Color.WHITE);
   setLayout(null);
   
    JLabel heading = new JLabel("Add Rooms");
    heading.setBounds(150,20,200,20);
    heading.setFont(new Font("Tahoma",Font.BOLD,18));
    add(heading);
  
    JLabel lblroomno = new JLabel("Room Number");
    lblroomno .setBounds(60,80,120,30);
    lblroomno .setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblroomno );
   
    tfroom = new JTextField();
    tfroom.setBounds(200,80,150,30);
    add(tfroom);
    
    JLabel lblavailable = new JLabel("Available");
    lblavailable .setBounds(60,130,120,30);
    lblavailable .setFont(new Font("Tahoma",Font.PLAIN,16));
    add( lblavailable );
    
    String availableOption[] ={"Available","Occupied"};
    availablecombo = new JComboBox(availableOption);
    availablecombo.setBounds(200,130,150,30);
    availablecombo.setBackground(Color.WHITE);
    add(availablecombo);

     JLabel lblclean = new JLabel("Cleaning Status");
     lblclean .setBounds(60,180,120,30);
     lblclean .setFont(new Font("Tahoma",Font.PLAIN,16));
     add(  lblclean );
    
    String cleanOption[] ={"Cleaned","Dirty"};
    cleancombo = new JComboBox(cleanOption);
    cleancombo.setBounds(200,180,150,30);
    cleancombo.setBackground(Color.WHITE);
    add(cleancombo);

    JLabel lblprice = new JLabel("Price");
    lblprice.setBounds(60,230,120,30);
    lblprice .setFont(new Font("Tahoma",Font.PLAIN,16));
    add(lblprice );
   
    tfprice = new JTextField();
    tfprice .setBounds(200,230,150,30);
    add(tfprice );
    
     JLabel lbltype = new JLabel("Bed Type");
     lbltype .setBounds(60,280,120,30);
     lbltype .setFont(new Font("Tahoma",Font.PLAIN,16));
     add(  lbltype );
    
    String typeOption[] ={"Single Bed","Double Bed"};
    typecombo = new JComboBox(typeOption);
    typecombo.setBounds(200,280,150,30);
    typecombo.setBackground(Color.WHITE);
    add(typecombo);
    
  add = new JButton("Add Room");
  add.setBounds(60,350,130,30);
  add.setBackground(Color.BLACK);
  add.setForeground(Color.WHITE);
  add.addActionListener(this);
  add(add);
  
  cancel = new JButton("Cancel");
  cancel.setBounds(220,350,130,30);
  cancel.setBackground(Color.BLACK);
  cancel.setForeground(Color.WHITE);
  cancel.addActionListener(this);
  add(cancel);
    
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/twelve.jpg"));
  Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(400, 30,500,300);
  add(image);  
    
   setBounds(260,200,940,470);
   setVisible(true);
  }   
  public static void main(String arg[])
  {
   new AddRoom();   
  }        

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
     if(ae.getSource() == add){
      String roomnumber=tfroom.getText();
      String availability=(String) availablecombo.getSelectedItem();
      String status =(String) cleancombo.getSelectedItem();
      String princ=tfprice.getText();
      String type=(String) typecombo.getSelectedItem();

      try
      {
       Conn c =new Conn();
       String query="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+princ+"','"+type+"')";
       c.s.executeUpdate(query);
      
       JOptionPane.showMessageDialog(null, "New Room Added Successfully!!!");
       setVisible(false);     
      }
      catch(Exception e)
      {
          System.out.println(e);
      }   
      
     }
     else{
         setVisible(false);
     }
    }
}
