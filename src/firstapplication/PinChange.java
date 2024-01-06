
package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class PinChange extends JFrame implements ActionListener{
    public static void main(String [] args)
    {
        PinChange obj= new PinChange();
    }
    JTextField accnotext,nametext,pintext;
    JButton proceed;
    PinChange()
    {
        setLayout(null);
        setTitle("Pin Change");
        setVisible(true);
        setSize(500, 480);
        setLocation(400, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 252, 232);
        getContentPane().setBackground(color);
        
        JLabel head = new JLabel("Enter Customer Details");
        head.setBounds(130, 10, 250, 50);
        head.setFont(new Font("Arial",Font.BOLD,20));
        add(head);
        
        JLabel accno = new JLabel("ACCOUNT NUMBER");
        accno.setBounds(50, 60, 170, 100);
        accno.setFont(new Font("Arial",Font.BOLD,16));
        add(accno);
        
       accnotext = new JTextField();
       accnotext.setBounds(50,140,400,30);
       add(accnotext);
       
        JLabel amount = new JLabel("ACCOUNT HOLDER");
        amount.setBounds(50, 150, 150, 100);
        amount.setFont(new Font("Arial",Font.BOLD,16));
        add(amount);
        
         nametext = new JTextField();
        nametext.setBounds(50,230,400,30);
        add(nametext);
        
         JLabel pin = new JLabel("ENTER OLD PIN");
        pin.setBounds(50, 240, 150, 100);
        pin.setFont(new Font("Arial",Font.BOLD,16));
        add(pin);
        
         pintext = new JTextField();
       pintext.setBounds(50,310,400,30);
       add(pintext);
     
       
       proceed = new JButton("PROCEED");
       proceed.setBounds(200,380,100,20);
       proceed.addActionListener(this);
       add(proceed);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String Account_Number=accnotext.getText();
        String Name=nametext.getText();
        String Pin=pintext.getText();
        
        if(ae.getSource()==proceed && !(Account_Number.equals("") && Name.equals("")))
        {
            try{
                Conn c=new Conn();
             String q  = "select * from customerdetails where Account_Number = '"+Account_Number+"' and Pin = '"+Pin+"'";
             ResultSet rs = c.s.executeQuery(q);
             if(rs.next())
            
            {
                 Random ran=new Random();
                 String newpin=Integer.toString(((ran.nextInt()%90)+5000));
                 String query="update bank set Pin ='"+newpin+"' where Pin ='"+Pin+"'";
                 String query1="update customerdetails set Pin ='"+newpin+"' where Pin ='"+Pin+"'";
                 
                 c.s.executeUpdate(query);
                 c.s.executeUpdate(query1);
                 JOptionPane.showMessageDialog(null,"PIN Change successful wiht new pin "+newpin);
                 setVisible(false);
                 new Employee_Dashboard("").setVisible(true);
             }
            else
            {
               JOptionPane.showMessageDialog(null, "Enter Correct Credentials");
            }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Enter the all fields");
        }
    }
}
