
package hotalmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
 Dashboard()
 {
  setBounds(0,0,1550,800);
  setLayout(null);
  
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
  Image i2 = i1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(0, 0,1550,800);
  add(image);
  
  JLabel text = new JLabel("THE HONOK MORVEON HOTAL WELCOME YOU");
  text.setBounds(250,80,1100,50);
  text.setFont(new Font("Tahoma",Font.PLAIN,45));
  text.setForeground(Color.WHITE);
  image.add(text);
  
  JMenuBar mb = new JMenuBar();
  mb.setBounds(0,0,1550,30);
  image.add(mb);
  
  JMenu hotal = new JMenu("HOTAL MANAGEMENT");
  hotal.setForeground(Color.RED);
  mb.add(hotal);
  
  JMenuItem reception = new JMenuItem("RECEPTION");
  reception.addActionListener(this);
  hotal.add(reception);
  
  JMenu admin = new JMenu("ADMIN ");
  admin.setForeground(Color.BLUE);
  mb.add( admin);
  
  
  JMenuItem addemployee= new JMenuItem("ADD EMPLOYEE");
  addemployee.addActionListener(this);
  admin.add(addemployee);
  
   JMenuItem addroom= new JMenuItem("ADD ROOMS");
   addroom.addActionListener(this);
   admin.add(addroom);
  
   JMenuItem adddriver= new JMenuItem("ADD DRIVER");
   adddriver.addActionListener(this);
   admin.add(adddriver);
  
  setVisible(true);    
 }   
 public static void main(String arg[])
 {
     new Dashboard();
 }       

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    if(ae.getActionCommand().equals("ADD EMPLOYEE")){
        new Addemployee();
    }  
    else if(ae.getActionCommand().endsWith("ADD ROOMS")){
        new AddRoom();
    }
    else if(ae.getActionCommand().equals("ADD DRIVER"))
    {
          new   AddDriver(); 
    }
    else if(ae.getActionCommand().equals("RECEPTION"))
    {
       new Reception();  
    }  
    }
}
