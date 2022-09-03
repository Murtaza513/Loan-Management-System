package bank.management;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField
            ,pinTextField,cnicTextField,amoundTextField;
    JButton next;
    JRadioButton male,female,yes,no;
    JDateChooser dateChooser; 
    
    
    SignupOne(){
             Conn c=new Conn();
        setLayout(null);
        boolean c1= true;
        Random rand = new Random();
       while(c1){
        
                 try {
                     random=Math.abs((rand.nextLong()%9000L)+1000L);
                     String q1  = "select * from signup where formno = '"+rand+"'";
                     ResultSet rs = c.s.executeQuery(q1);
                     if(!(rs.next()))
                         c1=false;
                 } catch (Exception e) {
                     System.out.println("ERRROR : "+ e.getMessage());
                 }
        }
        JLabel form_no=new JLabel("Application Form No: "+random);
        form_no.setFont(new Font("Raleway",Font.BOLD,38));
        form_no.setBounds(140,20,600,40);
        add(form_no);
        
        JLabel personal_details=new JLabel("Page 1: Personal Details");
        personal_details.setFont(new Font("Raleway",Font.BOLD,22));
        personal_details.setBounds(290,80,400,40);
        add(personal_details);
        
       JLabel name=new JLabel("Name: ");
       name.setFont(new Font("Raleway",Font.BOLD,22));
       name.setBounds(100,140,100,30);
       add(name);
       
       nameTextField=new JTextField();
       nameTextField.setBounds(300,140,400,30);
       add(nameTextField);
       
       JLabel fname=new JLabel("Fathers Name: ");
       fname.setFont(new Font("Raleway",Font.BOLD,22));
       fname.setBounds(100,190,200,30);
       add(fname);
       
       fnameTextField=new JTextField();
       fnameTextField.setBounds(300,190,400,30);
       add(fnameTextField);
       
       JLabel dob=new JLabel("Date of birth: ");
       dob.setFont(new Font("Raleway",Font.BOLD,22));
       dob.setBounds(100,240,200,30);
       add(dob);
       
       dateChooser=new JDateChooser();
       dateChooser.setBounds(300,240,400,30);
       dateChooser.setForeground(Color.BLACK);
       add(dateChooser);
       
       JLabel gender=new JLabel("Gender: ");
       gender.setFont(new Font("Raleway",Font.BOLD,22));
       gender.setBounds(100,290,200,30);
       add(gender);
       
       male=new JRadioButton("Male");
       male.setBounds(300,290,60,30);
       male.setBackground(Color.WHITE);
       add(male);
       
       female=new JRadioButton("Female");
       female.setBounds(450,290,80,30);
       female.setBackground(Color.WHITE);
       add(female);
       
       
       ButtonGroup genderGroup=new ButtonGroup();
       genderGroup.add(male);
       genderGroup.add(female);
      
       
       
       JLabel email=new JLabel("Email: ");
       email.setFont(new Font("Raleway",Font.BOLD,22));
       email.setBounds(100,340,200,30);
       add(email);
       
        emailTextField=new JTextField();
        emailTextField.setBounds(300,340,400,30);
       add(emailTextField);
        
       JLabel marital_status=new JLabel("Marital Status: ");
       marital_status.setFont(new Font("Raleway",Font.BOLD,22));
       marital_status.setBounds(100,390,200,30);
       add(marital_status);
       
       yes =new JRadioButton("Yes");
       yes.setBounds(300,390,100,30);
       yes.setBackground(Color.WHITE);
       add(yes);
       
       no =new JRadioButton("No");
       no.setBounds(450,390,100,30);
       no.setBackground(Color.WHITE);
       add(no);
       
       ButtonGroup maritalGroup=new ButtonGroup();
       maritalGroup.add(yes);
       maritalGroup.add(no);
       
       JLabel address=new JLabel("Address: ");
       address.setFont(new Font("Raleway",Font.BOLD,22));
       address.setBounds(100,440,200,30);
       add(address);
       
        addressTextField=new JTextField();
        addressTextField.setBounds(300,440,400,30);
       add(addressTextField);
       
       JLabel city=new JLabel("City: ");
       city.setFont(new Font("Raleway",Font.BOLD,22));
       city.setBounds(100,490,200,30);
       add(city);
       
        cityTextField=new JTextField();
       cityTextField.setBounds(300,490,400,30);
       add(cityTextField);
       
       JLabel state=new JLabel("State: ");
       state.setFont(new Font("Raleway",Font.BOLD,22));
       state.setBounds(100,540,200,30);
       add(state);
       
       stateTextField=new JTextField();
       stateTextField.setBounds(300,540,400,30);
       add(stateTextField);
       
       JLabel pin_code=new JLabel("Pin Code: ");
       pin_code.setFont(new Font("Raleway",Font.BOLD,22));
       pin_code.setBounds(100,590,200,30);
       add(pin_code);
       
       pinTextField=new JTextField();
       pinTextField.setBounds(300,590,400,30);
       add(pinTextField);
       
       JLabel cnic=new JLabel("Cnic: ");
       cnic.setFont(new Font("Raleway",Font.BOLD,22));
       cnic.setBounds(100,640,200,30);
       add(cnic);
     
       cnicTextField=new JTextField();
       cnicTextField.setBounds(300,640,400,30);
       add(cnicTextField);
       
       JLabel Amount =new JLabel("Amount: ");
       Amount.setFont(new Font("Raleway",Font.BOLD,22));
       Amount.setBounds(100,690,200,30);
       add(Amount);
     
       amoundTextField=new JTextField();
       amoundTextField.setBounds(300,690,400,30);
       add(amoundTextField);
        
        JButton next=new JButton("Back");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,730,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);
        
        
//        JOptionPane.showMessageDialog(rootPane,"Button cliked");
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
    }
    
   
   public static void main(String args[]){
       new SignupOne();
     }

    @Override
    public void actionPerformed(ActionEvent ae){
         boolean c2 = true;
        String form_no = "CR" +random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String pin=pinTextField.getText();
        long amount=0;
             amount=   Long.parseLong(amoundTextField.getText());
        String gender=null;
        
        Conn c=new Conn();
        try{
             if(male.isSelected()){
            gender="male";
             }
            else if(female.isSelected()){
                gender="female";
            }

            String email=emailTextField.getText();
            String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
          //  String Patern = "^[a-zA-Z0-9]{0,30}@[A-ZA-Z]{0,10}.[A-ZA-Z]$";
            Pattern pattern;
            pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(email);
            

            String marital=null;

            if(yes.isSelected()){
                marital="Married";
            }
            else if(no.isSelected()){
                marital="Unmarried";
            }

        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String cnic=cnicTextField.getText();
        
         if(!male.isSelected() && !female.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Kindly Select Gender");
        }
        if(!yes.isSelected() && !no.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Kindly Select Martial Status");
        }
            /*String query="Select cnic from signup where cnic='"+cnic+"'";
            
            if()
            ResultSet rs=c.s.executeQuery(query);*/
            if(!match.matches())
            {
              JOptionPane.showMessageDialog(null, "Kindly enter correct email");   
            }
            else if(name.trim().isEmpty() && cnic.trim().isEmpty() &&
              fname.trim().isEmpty() &&
              dob.trim().isEmpty()&&
              address.trim().isEmpty()&&
             
              city.trim().isEmpty()&&
              state.trim().isEmpty()&&
              pin.trim().isEmpty()) 
            {
             JOptionPane.showMessageDialog(null, "Kindly Fill the page completely");   
            }
            else if(cnic.trim().isEmpty() ){
                JOptionPane.showMessageDialog(null, "Enter cnic!");
            }
//            else if(c2){
//                
//                 while(c2){
//        
//                 try {
//                  
//                     String q1  = "select * from signup where cnic = '"+cnic+"'";
//                     ResultSet rs = c.s.executeQuery(q1);
//                     if(!(rs.next()))
//                         c2=false;
//                 } catch (Exception e) {
//                     System.out.println("ERRROR : "+ e.getMessage());
//                 }
//                 if(c2=false){
//                     JOptionPane.showMessageDialog(null, "User Already Exsits with this CNIC. ");
//                 }
//        }
//            }
            
            else if(name.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter name!");
            }
            else if(fname.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter father name!");
            }
            else if(dob.trim().isEmpty())
            {
                  JOptionPane.showMessageDialog(null, "Enter Date of Birth!");
            }
            else if(address.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter Address!");
            }
//            else if(email.trim().isEmpty())
//            {
//                JOptionPane.showMessageDialog(null, "Enter Email!");
//            }
            else if(city.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter City!");
            }
            else if(state.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter State!");
            }
            else if( pin.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter Pin code!");
            }
            else if (amount ==0)
            {
                JOptionPane.showMessageDialog(null, "Enter Amount to Deposit!");
            }
            
          /*  if(rs.next()){
                JOptionPane.showMessageDialog(null, "Account already registered with same cnic");
            }*/
            
            else{
                String query="insert into test2 values('"+form_no+"')";
                String query2="insert into signup values('"+form_no+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+""+marital+"',"
                        + "'"+address+"','"+city+"','"+state+"','"+pin+"','"+amount+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Your cardNo is "+form_no+"\n Your pin is "+pin);
            }
        }
        catch(Exception e){
            System.out.println(e);
            
        }
               
    }
    
}
