
package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class FastCash extends JFrame implements ActionListener{
    public static void main(String [] args)
    {
        FastCash obj= new FastCash();
    }
    JButton b100,b500,b1000,b2000,b5000,b10000,back;
     JTextField pintext,accnotext;
    FastCash()
    {
        setLayout(null);
        setTitle(" Fast Cash");
        setVisible(true);
        setSize(500, 550);
        setLocation(400, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 252, 232);
        getContentPane().setBackground(color);
        
        JLabel head = new JLabel("Enter Withdrawl Amount");
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
        
         back=new JButton("Back");
       back.setBounds(180,460,100,20);
       back.addActionListener(this);
       add(back);
        
       pintext = new JTextField();
       pintext.setBounds(50,215,400,30);
       add(pintext);
       
       
        b100 = new JButton("Rs 100");
        b100.setBounds(130, 270, 80, 20);
        b100.addActionListener(this);
        add(b100);
        
        b500 = new JButton("Rs 500");
        b500.addActionListener(this);
        b500.setBounds(260, 270, 80, 20);
        add(b500);
        
        b1000 = new JButton("Rs 1000");
        b1000.addActionListener(this);
        b1000.setBounds(130, 320, 80, 20);
        add(b1000);
        
        b2000 = new JButton("Rs 2000");
        b2000.addActionListener(this);
        b2000.setBounds(260, 320, 80, 20);
        add(b2000);
        
        b5000 = new JButton("Rs 5000");
        b5000.addActionListener(this);
        b5000.setBounds(130, 370, 80, 20);
        add(b5000);
        
          b10000 = new JButton("Rs 10000");
        b10000.addActionListener(this);
          b10000.setBounds(260, 370, 100, 20);
        add(b10000);    
        
      
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String Account_Number=accnotext.getText();
        String Pin=pintext.getText();
        
        String Amount="";
        if(ae.getSource()==b100)
        {
            Amount="100";
         }
        else if(ae.getSource()==b500)
        {
            Amount="500";
         }
        else if(ae.getSource()==b1000)
        {
            Amount="1000";
         }
        else if(ae.getSource()==b2000)
        {
            Amount="2000";
         }
        else if(ae.getSource()==b5000)
        {
            Amount="5000";
         }
        else if(ae.getSource()==b10000)
        {
            Amount="10000";
        }
        else if(ae.getSource()==back)
        {
              setVisible(false);
            new Employee_Dashboard("").setVisible(true);
        }
        
        try{
            Conn c=new Conn();
            if(!(Account_Number.equals("") && Pin.equals("")))
            {
             String q  = "select * from customerdetails where Account_Number = '"+Account_Number+"' and Pin = '"+Pin+"'";
             String q1 = "select * from bank where Pin ='"+Pin+"'";
             int balance=0;
             ResultSet rs = c.s.executeQuery(q);
             ResultSet rs1=c.s.executeQuery(q1);
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
             if(balance<Integer.parseInt(Amount))
             {
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
             }
             String query="insert into bank values('"+Pin+"','Withdraw','"+Amount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs "+Amount+" Debited successfully");
             setVisible(false);
             new Employee_Dashboard("").setVisible(true);
        }
        else
            {
                JOptionPane.showMessageDialog(null,"Enter all the fields");
            }}
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
