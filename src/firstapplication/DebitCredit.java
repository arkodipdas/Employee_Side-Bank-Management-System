
package firstapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DebitCredit extends JFrame implements ActionListener{
    public static void main(String[] args) {
        DebitCredit obj= new DebitCredit();
    }
    JButton proceed,back;
    JTextField scctext,accnotext;
    JComboBox card;
    DebitCredit()
    {
        setTitle("Debit/Credit");
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color =new Color(204, 252, 232);
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
       
        JLabel amount = new JLabel("Applying For");
        amount.setBounds(50, 150, 150, 100);
        amount.setFont(new Font("Arial",Font.BOLD,16));
        add(amount);
        
         String cards[]={"Credit","Debit","Both Debit & Credit"};
         card=new JComboBox(cards);
         card.setBounds(50,230,400,30);
         add(card);
         
         
         
       JLabel acc = new JLabel("Account Holder");
        acc.setBounds(50, 240, 150, 100);
        acc.setFont(new Font("Arial",Font.BOLD,16));
        add(acc);
        
        scctext = new JTextField();
       scctext.setBounds(50,310,400,30);
       add(scctext);
       
       proceed = new JButton("PROCEED");
       proceed.setBounds(200,380,100,20);
       proceed.addActionListener(this);
       add(proceed);
       
       back=new JButton("Back");
       back.setBounds(200,340,100,20);
       back.addActionListener(this);
       add(back);
    }
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Employee_Dashboard("").setVisible(true);
        }
        else{
             String Account_Number=accnotext.getText();
        String Account_Holder=scctext.getText();
        if((Account_Number.equals("") && Account_Holder.equals("")))
        {
            JOptionPane.showMessageDialog(null,"Enter all the fields");
        }
        else
        {
            String Card=(String)card.getSelectedItem();
            JOptionPane.showMessageDialog(null, Card+" card will be delivered");
        }
        }
       
    }
 }

