
package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener
{
    JTextField nametext,phonetext,passtext;
    JLabel heading,name,phone,password;
    JButton button,login1;
    public static void main(String[] args) {
        Signup obj =new Signup();
    }
    Signup()
    {
        setLayout(null);
        setTitle("Employee Sign Up");
        setVisible(true);
        setSize(400, 420);
        setLocation(500, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(204,252,232);
        getContentPane().setBackground(color);
        
        heading = new JLabel("Sign Up Form");
        heading.setBounds(130, 10, 200, 100);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        add(heading);
        
        name = new JLabel("NAME");
        name.setBounds(40, 80, 100, 30);
        name.setFont(new Font("Arial",Font.BOLD,16));
        add(name);
        
        nametext = new JTextField();
        nametext.setBounds(40, 120, 300, 30);
        add(nametext);
        
        phone = new JLabel("PHONE");
        phone.setBounds(40, 160, 100, 30);
        phone.setFont(new Font("Arial",Font.BOLD,16));
        add(phone);
        
        phonetext = new JTextField();
        phonetext.setBounds(40, 200, 300, 30);
        add(phonetext);
        
        password = new JLabel("Password");
        password.setBounds(40, 205, 100, 100);
        password.setFont(new Font("Arial",Font.BOLD,16));
        add(password);
        
        passtext = new JTextField();
        passtext.setBounds(40, 270, 300, 30);
        add(passtext);
        
        button = new JButton("SIGN UP");
        button.setBounds(200,330,100,30);
        button.addActionListener(this);
        add(button);
        
        login1 = new JButton("Back to Log In");
        login1.setBounds(60,330,130,30);
        login1.addActionListener(this);
        add(login1);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login1)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        else{
        String Name=nametext.getText();
        String Phone=phonetext.getText();
        //Random r = new Random();
        //String Password = String.format("%04d", r.nextInt(1001));
        //OptionPane.showMessageDialog(null, "Your Password is "+Password);
              String Password=passtext.getText();  
        try{
            if(Name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "All Fields are Required");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into employeedetails values('"+Name+"', '"+Phone+"','"+Password+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created");
                
                
            }
            
            
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        }
    }
    
}
