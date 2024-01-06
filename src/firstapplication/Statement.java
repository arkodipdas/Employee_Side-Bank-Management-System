
package firstapplication;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Statement extends JFrame implements ActionListener{
    public static void main(String [] args)
    {
        new Statement("");
    }
    JButton b;
    Statement(String Pin)
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("pics/23388860.jpg"));
        Image i3=i1.getImage().getScaledInstance(100,100,100 );
        ImageIcon i4 = new ImageIcon(i3);
        JLabel i2= new JLabel(i4);
        i2.setBounds(50,10,100,100);
        add(i2);
        
        
        setLayout(null);
        setTitle("Statement");
        setVisible(true);
        setSize(500, 600);
        setLocation(450, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(255, 255, 255);
        getContentPane().setBackground(color);
        
        JLabel text=new JLabel();
        text.setBounds(20,140,400,200);
        add(text);
        
           JLabel balance=new JLabel();
        balance.setBounds(20, 360, 300, 20);
        add(balance);
        
        b = new JButton("Dashboard");
        b.setBounds(160, 500, 150, 20);
        b.addActionListener(this);
        add(b);
        
        JLabel Account_Number=new JLabel();
        Account_Number.setBounds(20,80,300,20);
        add(Account_Number);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customerdetails where Pin = '"+Pin+"'");
            
            while(rs.next())
            {
                Account_Number.setText("Account Number: " + rs.getString("Account_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Account_Number").substring(12));
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+Pin+"'");
            int bal=0;
            while(rs.next())
            {
                text.setText(text.getText() + "<html>" + rs.getString("Transaction_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("Amount") + "<br><br><html>");
                if(rs.getString("Transaction_Type").equals("Deposit"))
                 {
                     bal+=Integer.parseInt(rs.getString("Amount"));
                 }
                 else
                 {
                     bal-=Integer.parseInt(rs.getString("Amount"));
                 }
            }
            balance.setText("Your current account balance is Rs "+bal);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b)
        {
            setVisible(false);
            new Employee_Dashboard("").setVisible(true);
        }
    }

}
