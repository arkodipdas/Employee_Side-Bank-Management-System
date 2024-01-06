
package firstapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    public static void main(String [] args)
    {
    Login obj = new Login();    
    }
    JButton b,b2,b3;
    JTextField uidtext;
    JPasswordField passtext;
    
    Login() 
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/23388860.jpg"));
        Image i3=i1.getImage().getScaledInstance(100,100,100 );
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2= new JLabel(i4);
        i2.setBounds(150,10,100,100);
        add(i2);
        Color color = new Color(255,255,255);
        getContentPane().setBackground(color);
        
        
        
        JLabel l1= new JLabel("LOG IN");
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setBounds(300,10,400,100);
        add(l1);
        
        JLabel uid= new JLabel("ENTER USER ID");
        uid.setFont(new Font("Arial",Font.BOLD,18));
        uid.setBounds(150,100,150,100);
        add(uid);
        
         uidtext = new JTextField();
        uidtext.setBounds(150,185,400,30);
        add(uidtext);
        
        JLabel pass = new JLabel("ENTER PASSWORD");
        pass.setFont(new Font("Arial",Font.BOLD,18));
        pass.setBounds(150,200,400,100);
        add(pass);
        
         passtext = new JPasswordField();
        passtext.setBounds(150,285,400,30);
        add(passtext);
        
         b = new JButton("LOG IN");
        b.setBounds(170,350,150,20);
        add(b);
        b.addActionListener(this);
        
         b2 = new JButton("FORGOT PASSWORD");
        b2.setBounds(340,350,200,20);
        b2.addActionListener(this);
        add(b2);
        
         b3 = new JButton("SIGN UP");
        b3.setBounds(260,400,150,20);
        add(b3);
        b3.addActionListener(this);
        
        setTitle("LOG IN");
        setSize(700,500);
        setLayout(null);
        setVisible(true);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
      
        if(ae.getSource() == b)
        {
            if(uidtext.getText().equals("") || passtext.getText().equals(""))
            {
                 JOptionPane.showMessageDialog(null, "All Fields are Required");
            }
            else
            {
                Conn conn = new Conn();
                  String uid=uidtext.getText();
            String password=passtext.getText();
            String query="select * from employeedetails where Name ='"+uid+"' and Password ='"+password+"'";
            try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Employee_Dashboard(uid).setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Invalid User Id or Password");
               }
            }catch(Exception e)
            {
                
            }
            }
        }
        else if(ae.getSource() == b2)
        {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
        else if(ae.getSource() == b3)
        {
            setVisible(false);
            new Signup().setVisible(true);
        }
    }
    
}
