package firstapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class CreateAccount_AdditionalDetails extends JFrame implements ActionListener
{
    public static void main(String [] args)
    {
        CreateAccount_AdditionalDetails obj = new CreateAccount_AdditionalDetails("");
    }
    JTextField aadhartext,pantext,incometext;
    JComboBox religiontext,categorytext,accounttypetext;
    JRadioButton yes,no,yes1,no1;
    String Name;
    CreateAccount_AdditionalDetails(String Name) 
    {
    
        this.Name=Name;
        setLayout(null);
        setVisible(true);
        setSize(700, 600);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = new Color(227, 250, 249);
        getContentPane().setBackground(color);
        
        JLabel l1 = new JLabel("Additional Details");
        l1.setBounds(220, 10, 250, 100);
        l1.setFont(new Font("Arial",Font.BOLD,28));
        add(l1);
        
        JLabel aadhar = new JLabel("Aadhar Number");      
        aadhar.setBounds(80, 65, 150, 100);
        aadhar.setFont(new Font("Arial",Font.BOLD,16));
        add(aadhar);
        
        aadhartext = new JTextField();     
        aadhartext.setBounds(250,100,400,30);
        add(aadhartext);
        aadhartext.setVisible(true);
        
         JLabel pan = new JLabel("Pan No.");
        pan.setBounds(80, 105, 150, 100);
        pan.setFont(new Font("Arial",Font.BOLD,16));
        add(pan);
        
        pantext = new JTextField();
        pantext.setBounds(250,140,400,30);
        add(pantext);
        pantext.setVisible(true);
        
         JLabel religion = new JLabel("Religion");
        religion.setBounds(80, 145, 150, 100);
        religion.setFont(new Font("Arial",Font.BOLD,16));
        add(religion);
        
        String relval[]={"Hinduism","Islam","Christianity","Sikhism","Others"};
        religiontext = new JComboBox(relval);       
        religiontext.setBounds(250,180,400,30);
        add(religiontext);
        
        
        JLabel category = new JLabel("Category");
        category.setBounds(80, 185, 150, 100);
        category.setFont(new Font("Arial",Font.BOLD,16));
        add(category);
        
        String categoryval[]={"SC","ST","OBC","General"};
        categorytext=new JComboBox(categoryval);
        categorytext.setBounds(250,220,400,30);
        add(categorytext);
        
        
        JLabel income = new JLabel("Income");
        income.setBounds(80,225 , 150, 100);
        income.setFont(new Font("Arial",Font.BOLD,16));
        add(income);
        
        incometext = new JTextField();
        incometext.setBounds(250, 260, 400, 30);
        add(incometext);
        
        JLabel sen = new JLabel("Senior Citizen");
        sen.setBounds(80, 265, 150, 100);
        sen.setFont(new Font("Arial",Font.BOLD,16));
        add(sen);
        
        JRadioButton notsenior= new JRadioButton("Not a Senior Citizen");
        notsenior.setBackground(color);
        notsenior.setBounds(250,300,200,30);
        add(notsenior);
        
        JRadioButton senior= new JRadioButton("Senior Citizen");
        senior.setBounds(470,300,200,30);
        senior.setBackground(color);
        add(senior);
        
        ButtonGroup sengroup = new ButtonGroup();
        sengroup.add(senior);
        sengroup.add(notsenior);
        
        JLabel exisacc = new JLabel("Existing Account");
        exisacc.setBounds(80,305, 200, 100);
        exisacc.setFont(new Font("Arial",Font.BOLD,16));
        add(exisacc);
        
        yes = new JRadioButton("Yes");
        yes.setBackground(color);
        add(yes);
        yes.setBounds(250,340,50,30);
        
          no = new JRadioButton("No");
        no.setBackground(color);
        add(no);
        no.setBounds(370,340,50,30);
        
        ButtonGroup yesno = new ButtonGroup();
        yesno.add(yes);
        yesno.add(no);
        
        JLabel AccountType = new JLabel("Account Type");
        AccountType.setBounds(80, 355, 150, 100);
        AccountType.setFont(new Font("Arial",Font.BOLD,16));
        add(AccountType);
        
        String accounttypeval[]={"Savings","Current","Salary","Recurring Deposit Account"};
        accounttypetext=new JComboBox(accounttypeval);
        accounttypetext.setBounds(250,395,400,30);
        add(accounttypetext);
        
                JLabel mobilebanking = new JLabel("Mobile Banking");
        mobilebanking.setBounds(80,405, 200, 100);
        mobilebanking.setFont(new Font("Arial",Font.BOLD,16));
        add(mobilebanking);
        
         yes1 = new JRadioButton("Yes");
        yes1.setBackground(color);
        add(yes1);
        yes1.setBounds(250,440,50,30);
        
         no1 = new JRadioButton("No");
        no1.setBackground(color);
        add(no1);
        no1.setBounds(370,440,50,30);
        
        ButtonGroup yesno1 = new ButtonGroup();
        yesno1.add(yes1);
        yesno1.add(no1);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(280,500,110,20);
        submit.addActionListener(this);
        add(submit);
        }
    
    public void actionPerformed(ActionEvent ae)
    {
        String Aadhar=aadhartext.getText();
        String Pan=pantext.getText();
        String Religion = (String)religiontext.getSelectedItem();
        String Category=(String)categorytext.getSelectedItem();
        String Income=incometext.getText();
        String AccountType=(String)accounttypetext.getSelectedItem();
        String MobileBanking=null;
        if(yes1.isSelected())
        {
            MobileBanking="Yes";
        }
        else if(no1.isSelected())
        {
            MobileBanking="No";
        }
        String ExistingAccount=null;
         if(yes.isSelected())
        {
            ExistingAccount="Yes";
        }
         else if(no.isSelected())
        {
            ExistingAccount="No";
        }
         if(no.isSelected())
         {
             try{
            if(Aadhar.equals("")||Pan.equals("") || Religion.equals("") ||Category.equals("")  ||Income.equals("") ||AccountType.equals("") || MobileBanking.equals("") || ExistingAccount.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c=new Conn();
                String query="insert into createaccount_additionaldetails values('"+Aadhar+"', '"+Pan+"', '"+Religion+"', '"+Category+"', '"+Income+"', '"+ExistingAccount+"','"+AccountType+"', '"+MobileBanking+"')";
                c.s.executeUpdate(query);
                Random ran=new Random();
                long number = (ran.nextLong() % 90000000L) + 5040936000000000L;
                int pin=(ran.nextInt()%90)+2000;
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Account Number :- "+number+"\n"+"PIN :- "+pin);               
                String query1="insert into customerdetails values('"+Name+"', '"+number+"', '"+pin+"')";
                c.s.executeUpdate(query1);
                setVisible(false);
                new DepositFunds().setVisible(true);
            }
            
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
         }
         else
         {
             JOptionPane.showMessageDialog(null,"Customer already has an Account");
         }
         
    }
}
