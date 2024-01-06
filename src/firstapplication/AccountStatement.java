
package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AccountStatement extends JFrame implements ActionListener
{
    public static void main(String [] args)
    {
        AccountStatement obj= new AccountStatement();
    }
    JTextField accnotext,pintext;
    JButton back;
    AccountStatement()
    {
        setLayout(null);
        setTitle("Account Statement");
        setVisible(true);
        setSize(500, 400);
        setLocation(400, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 252, 232);
        getContentPane().setBackground(color);
        
        JLabel head = new JLabel("Enter Customer Details");
        head.setBounds(130, 10, 250, 50);
        head.setFont(new Font("Arial",Font.BOLD,20));
        add(head);
        
        JLabel accno = new JLabel("Account Number");
        accno.setBounds(50, 60, 150, 100);
        accno.setFont(new Font("Arial",Font.BOLD,16));
        add(accno);
        
       accnotext = new JTextField();
       accnotext.setBounds(50,130,400,30);
       add(accnotext);
       
       JLabel pin = new JLabel("PIN");
        pin.setBounds(50, 150, 100, 100);
        pin.setFont(new Font("Arial",Font.BOLD,16));
        add(pin);
        
          back=new JButton("Back");
       back.setBounds(200,340,100,20);
       back.addActionListener(this);
       add(back);
        
     
        
       pintext = new JTextField();
       pintext.setBounds(50,220,400,30);
       add(pintext);
       
       JButton proceed = new JButton("PROCEED");
       proceed.setBounds(200,300,100,20);
       proceed.addActionListener(this);
       add(proceed);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String Account_Number=accnotext.getText();
        String Pin=pintext.getText();
        if(ae.getSource()==back)
        {
             setVisible(false);
            new Employee_Dashboard("").setVisible(true);
        }
        else{
        Conn c=new Conn();
        if(!(Account_Number.equals("") && Pin.equals("")))
        {
        try
        {
            String q="select * from customerdetails where Account_Number ='"+Account_Number+"' and Pin ='"+Pin+"'";
            ResultSet rs=c.s.executeQuery(q);
            if(rs.next())
            {
                setVisible(false);
                new Statement(Pin).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Credentials");
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Enter all the fields");
        }
    }
    }
}
