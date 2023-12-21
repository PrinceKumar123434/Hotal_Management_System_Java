
package hotalmanagement;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class HotalManagement extends JFrame implements ActionListener
{
HotalManagement()
{
    setSize(1366,565);
    setLocation(100,100);
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/first.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0, 0, 1366, 565);
    add(image);
    
    JLabel text=new JLabel("HOTAL MANAGEMENT SYSTEM");
    text.setBounds(20,410,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serif",Font.PLAIN,50));
    image.add(text);
    
    JButton next = new JButton("Next");
    next.setBounds(1150,450,120,40);
    next.setBackground(Color.WHITE);
    next.setForeground(Color.BLACK);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.PLAIN,20));
    image.add(next);
    
      setVisible(true);
      
      while(true)
      {
          text.setVisible(false);
          try{
              Thread.sleep(500);
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          text.setVisible(true);
            try{
              Thread.sleep(500);
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }

      }    
}       
    public static void main(String[] args) {
        new HotalManagement();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
    setVisible(false);
    new Login();
    
    }
    
}
