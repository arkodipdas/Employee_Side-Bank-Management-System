 
package firstapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Employee_Dashboard extends JFrame implements ActionListener
{
    JButton b,b0,b1,b11,b2,b21,b3,b31,b4;
    
    Employee_Dashboard(String Name)
    {
       
        setLayout(null);
        setTitle("Employee Dashboard");
        setVisible(true);
        setSize(600, 500);
        setLocation(400,160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204, 252, 232);
        getContentPane().setBackground(color);
        
        
                JLabel i1 = new JLabel("Welcome to Dashboard");
                i1.setFont(new Font("Arial",Font.BOLD,26));
                i1.setBounds(150, 10, 300, 100);
                add(i1);
                
                JLabel name = new JLabel(Name);
                name.setFont(new Font("Arial",Font.BOLD,20));
                name.setBounds(230, 90, 80, 18);
                add(name);
                
                
                 b = new JButton("CREATE CUSTOMER ACCOUNT");
                b.setBounds(70, 140, 220, 20);
                b.addActionListener(this);
                add(b);
                
                 b0 = new JButton("ACCOUNT STATEMENT");
                b0.setBounds(320, 140, 220, 20);
                b0.addActionListener(this);
                add(b0);
                
                 b1 = new JButton("BALANCE ENQUIRY");
                b1.setBounds(100, 200, 150, 20);
                b1.addActionListener(this);
                add(b1);
                
                 b11 = new JButton("FAST CASH");
                b11.setBounds(340, 200, 150, 20);
                b11.addActionListener(this);
                add(b11);
                
                 b2 = new JButton("DEPOSIT FUNDS");
                b2.setBounds(100, 260, 150, 20);
                b2.addActionListener(this);
                add(b2);
                
                 b21 = new JButton("PIN CHANGE");
                b21.setBounds(340, 260, 150, 20);
                b21.addActionListener(this);
                add(b21);
                
                 b3 = new JButton("WITHDRAW FUNDS");
                b3.setBounds(100, 320, 150, 20);
                b3.addActionListener(this);
                add(b3);
                
                b31 = new JButton("DEBIT/CREDIT");
                b31.setBounds(340, 320, 150, 20);
                b31.addActionListener(this);
                add(b31);
                
                 b4 = new JButton("LOG OUT");
                b4.setBounds(220, 400, 150, 20);
                b4.addActionListener(this);
                add(b4);
                
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b)// create customer account
        {
            setVisible(false);
            new CreateAccount().setVisible(true);
        }
        else if(ae.getSource()==b0) // account statement
        {
              setVisible(false);
            new AccountStatement().setVisible(true);
        }
        else if(ae.getSource()==b1) // balance enquiry
        {
              setVisible(false);
            new BalanceEnquiry().setVisible(true);
        }
         else if(ae.getSource()==b11) // FastCash
        {
              setVisible(false);
            new FastCash().setVisible(true);
        }
         else if(ae.getSource()==b2)  // deposit funds
        {
              setVisible(false);
            new DepositFunds().setVisible(true);
        }
         else if(ae.getSource()==b21) // pin change
        {
              setVisible(false);
            new PinChange().setVisible(true);
        }
         else if(ae.getSource()==b3)  // withdraw funds
        {
              setVisible(false);
            new WithdrawFunds().setVisible(true);
        }
         else if(ae.getSource()==b31) // Debit Credit
        {
              setVisible(false);
            new DebitCredit().setVisible(true);
        }
         else if(ae.getSource()==b4) // Login
        {
              setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String [] args)
    {
        new Employee_Dashboard("");
    }
}
