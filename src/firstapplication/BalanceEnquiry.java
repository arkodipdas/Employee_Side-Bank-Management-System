
package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener{
    public static void main(String [] args)
    {
        BalanceEnquiry obj= new BalanceEnquiry();
    }
    JTextField accnotext,pintext;
    JButton back;
    BalanceEnquiry()
    {
        setLayout(null);
        setTitle("Balance Enquiry");
        setVisible(true);
        setSize(500, 450);
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
       accnotext.setBounds(50,140,400,30);
       add(accnotext);
       
       JLabel pin = new JLabel("PIN");
        pin.setBounds(50, 150, 100, 100);
        pin.setFont(new Font("Arial",Font.BOLD,16));
        add(pin);
        
       pintext = new JTextField();
       pintext.setBounds(50,230,400,30);
       add(pintext);
       
       JButton proceed = new JButton("PROCEED");
       proceed.setBounds(200,300,100,20);
       proceed.addActionListener(this);
       add(proceed);
       
       back=new JButton("Back");
       back.setBounds(200,350,100,20);
       back.addActionListener(this);
       add(back);
    }
    @Override
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
        if(!(Account_Number.equals("") && Pin.equals("")))
        {
             int balance=0;
            Conn c=new Conn();           
            try{
             String q  = "select * from customerdetails where Account_Number = '"+Account_Number+"' and Pin = '"+Pin+"'";
             ResultSet rs = c.s.executeQuery(q);
            
             if(rs.next())
             {
                    String q1  = "select * from bank where PIN = '"+Pin+"'";
                    
                    ResultSet rs1 = c.s.executeQuery(q1);
                     while(rs1.next())
                    {
                        if(rs1.getString("Transaction_Type").equals("Deposit"))
                    {
                         balance+=Integer.parseInt(rs1.getString("Amount"));
                    }
                     else
                    {
                       balance-=Integer.parseInt(rs1.getString("Amount"));
                    }
                    }
                 
            }
             else
             {
                 JOptionPane.showMessageDialog(null,"Enter the correct credentials");
             }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null,"Your Current Balance is Rs "+balance);
            
            
        
        }
             else
             {
                 JOptionPane.showMessageDialog(null,"Enter all the necessary fields");
             }
        }
    }
    
    }

