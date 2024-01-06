package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class CreateAccount extends JFrame implements ActionListener
{

  
    JTextField nametext,dobtext,fathertext,phonetext,emailtext,addresstext,citytext,statetext,pintext;
    JRadioButton male,female,married,unmarried,others;
    JButton next;
    
    CreateAccount() 
    {
        setTitle("Application Form");
        setLayout(null);
        setVisible(true);
        setSize(700, 700);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(227, 250, 249);
        getContentPane().setBackground(color);

        JLabel i1 = new JLabel("APPLICATION FORM");
        i1.setBounds(220, 8, 390, 100);
        i1.setFont(new Font("Arial", Font.BOLD, 26));
        add(i1);

        JLabel name = new JLabel("Name");                                    //name
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(40, 50, 70, 100);
        add(name);

        nametext = new JTextField();        
        nametext.setBounds(220, 85, 400, 30);
        add(nametext);

        JLabel dob = new JLabel("Date of Birth");                             //DOB
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setBounds(40, 100, 190, 100);
        add(dob);
        
        dobtext = new JTextField();
        dobtext.setBounds(220, 135, 400, 30);
        add(dobtext);

        JLabel father = new JLabel("Father's Name");                           //father
        father.setFont(new Font("Arial", Font.BOLD, 20));
        father.setBounds(40, 150, 190, 100);
        add(father);
        
        fathertext = new JTextField();
        fathertext.setBounds(220, 185, 400, 30);
        add(fathertext);

        JLabel gender = new JLabel("Gender");                                 //gender
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(40, 200, 100, 100);
        add(gender);
        
         male = new JRadioButton("Male");
        male.setBackground(color);
        male.setBounds(220,230,100,20);
        add(male);
        
         female = new JRadioButton("Female");
        female.setBackground(color);
        female.setBounds(350,230,100,20);
        add(female);
        
       others = new JRadioButton("Others");
        others.setBackground(color);
        others.setBounds(480,230,100,20);
        add(others);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);
        
        JLabel phone = new JLabel("Phone No.");                               //phone
        phone.setFont(new Font("Arial", Font.BOLD, 20));
        phone.setBounds(40, 250, 100, 100);
        add(phone);
        
        phonetext = new JTextField();
        phonetext.setBounds(220, 285, 400, 30);
        add(phonetext);

        JLabel email = new JLabel("Email");                                   //email
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(40, 300, 100, 100);
        add(email);
        
        emailtext = new JTextField();
        emailtext.setBounds(220, 335, 400, 30);
        add(emailtext);

        JLabel marital = new JLabel("Marital Status");                        //marital status
        marital.setFont(new Font("Arial", Font.BOLD, 20));
        marital.setBounds(40, 350, 190, 100);
        add(marital);
        
         married = new JRadioButton("Married");
        married.setBackground(color);
        married.setBounds(220,390,100,20);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(color);
        unmarried.setBounds(350,390,100,20);
        add(unmarried);
        
        ButtonGroup margroup = new ButtonGroup();
        margroup.add(married);
        margroup.add(unmarried);
        
        JLabel address = new JLabel("Address");                               //address
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(40, 400, 100, 100);
        add(address);
        
        addresstext = new JTextField();
        addresstext.setBounds(220, 435, 400, 30);
        add(addresstext);
 
        JLabel city = new JLabel("City");                                    //city
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(40, 450, 100, 100);
        add(city);
        
        citytext = new JTextField();
        citytext.setBounds(220, 485, 400, 30);
        add(citytext);

        JLabel state = new JLabel("State");                                    //state
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(40, 500, 100, 100);
        add(state);
        
        statetext = new JTextField();
        statetext.setBounds(220, 535, 400, 30);
        add(statetext);

        JLabel pin = new JLabel("Pin Code");                                     //pin
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        pin.setBounds(40, 550, 100, 100);
        add(pin);
        
        pintext = new JTextField();
        pintext.setBounds(220, 585, 400, 30);
        add(pintext);
        
        next = new JButton("Next");
        next.setBounds(300,630,110,20);
        next.addActionListener(this);
        add(next);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String Name=nametext.getText();
        String DOB=dobtext.getText();
        String FathersName=fathertext.getText();
        String Phone=phonetext.getText();
        String EMail=emailtext.getText();
        String Address=addresstext.getText();
        String City=citytext.getText();
        String State=statetext.getText();
      
        String PIN=pintext.getText();
        String Gender=null;
        if(male.isSelected())
        {
            Gender="Male";
        }
        else if(female.isSelected())
        {
            Gender="Female";
        }
        else if(others.isSelected())
        {
            Gender="Others";
        }
        
        String Marital=null;
        if(married.isSelected())
        {
            Marital="Married";
        }
        else if(unmarried.isSelected())
        {
            Marital="Unmarried";
        }
        
        try{
            if(Name.equals("")||FathersName.equals("") || DOB.equals("") ||EMail.equals("")  ||Phone.equals("") ||Address.equals("") || City.equals("") || State.equals("") || PIN.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into createaccount values('"+Name+"', '"+FathersName+"', '"+DOB+"', '"+Gender+"', '"+EMail+"', '"+Marital+"','"+Phone+"', '"+Address+"', '"+City+"', '"+State+"', '"+PIN+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new CreateAccount_AdditionalDetails(Name);
            }
            
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
    }
      public static void main(String[] args) {
        CreateAccount obj=new CreateAccount();
    }

    

}
