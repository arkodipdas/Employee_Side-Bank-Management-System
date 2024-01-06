
package firstapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener{
    JTextField uidtext,numbertext,newpasstext;
    ForgotPassword()
            {
                setLayout(null);
                setVisible(true);
                setTitle("Forgot Password");
                setSize(400, 400);
                setLocation(300, 200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Color c=new Color(204, 252, 232);
                getContentPane().setBackground(c);
                
                JLabel userid = new JLabel("User ID");
                userid.setBounds(50, 5, 100, 100);
                userid.setFont(new Font("Arial",Font.BOLD,20));
                add(userid);
                
                uidtext = new JTextField();
                uidtext.setBounds(50, 75, 300, 30);
                add(uidtext);
                
                JLabel number = new JLabel("Phone");
                number.setBounds(50, 100, 100, 100);
                number.setFont(new Font("Arial",Font.BOLD,20));
                add(number);
                
                numbertext = new JTextField();
                numbertext.setBounds(50, 175, 300, 30);
                add(numbertext);
                
                 JLabel newpass = new JLabel("New Password");
                newpass.setBounds(50, 200, 300, 100);
                newpass.setFont(new Font("Arial",Font.BOLD,20));
                add(newpass);
                
                newpasstext = new JTextField();
                newpasstext.setBounds(50, 275, 300, 30);
                add(newpasstext);
                
                JButton set= new JButton("Set New Password");
                set.setBounds(117, 320, 150, 20);
                set.addActionListener(this);
                add(set);
            }
            public static void main(String [] args)
            {
                new ForgotPassword();
            }
            public void actionPerformed(ActionEvent ae)
            {
                String Account_Holder=uidtext.getText();
                String Number=numbertext.getText();
                String NPassword=newpasstext.getText();
                if(Account_Holder.equals("") && Number.equals("") && NPassword.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter all the fields");
                }
                else
                {
                try{
                Conn c=new Conn();
                String q  = "select * from employeedetails where Name = '"+Account_Holder+"' and Phone = '"+Number+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next())
                {                
                 String query="update employeedetails set Password ='"+NPassword+"' where Name ='"+Account_Holder+"'";
                 
                 
                 c.s.executeUpdate(query);
                
                 JOptionPane.showMessageDialog(null,"Password Change successful with new password "+NPassword);
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
            }
    
}
