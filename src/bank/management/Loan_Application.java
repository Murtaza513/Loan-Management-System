/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;  

public class Loan_Application extends JFrame implements ActionListener{

      long random;
    JTextField Professiontextfield,monthly_income_textfield,
            education_textfield,no_dependents_textfield,loan_amount_textfield,time_period_textfield;
    
    JRadioButton own,rental;
     
    JTextArea loan_explanation;
    JComboBox list;
    static String acc_no;
    Loan_Application(String card_no){
        acc_no = card_no;
        setLayout(null);
            Random rand=new Random();
            random=Math.abs((rand.nextLong()%9000L)+1000L);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/loan.jpg"));
        Image img = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); 
        add(image);
        
        
         JLabel text=new JLabel("Loan Application", JLabel.CENTER);
        text.setForeground(Color.black);
//        text.setBackground(Color.red);
        text.setFont(new Font("Osward",Font.BOLD,50));
        text.setBounds(190,20, 500,60);
        image.add(text);
      
        JLabel Profession=new JLabel("Profession:");
        Profession.setForeground(Color.black);
        Profession.setFont(new Font("Raleway",Font.BOLD,20));
        Profession.setBounds(80,100,150,40);
        image.add(Profession);
        
        Professiontextfield = new JTextField();
        Professiontextfield.setBounds(435,105,230,30);
        Professiontextfield.setFont(new Font("Arial",Font.BOLD,14));
        image.add(Professiontextfield);
        
        
        JLabel education=new JLabel("Education:");
        education.setForeground(Color.black);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(80,150,150,40);
        image.add(education);
        
        education_textfield = new JTextField();
        education_textfield.setBounds(435,155,230,30);
        education_textfield.setFont(new Font("Arial",Font.BOLD,14));
        image.add(education_textfield);
        
        JLabel no_dependents=new JLabel("Number Of Dependents:  ");
        no_dependents.setForeground(Color.black);
        no_dependents.setFont(new Font("Raleway",Font.BOLD,20));
        no_dependents.setBounds(80,200,240,40);
        image.add(no_dependents);
        
        no_dependents_textfield = new JTextField();
        no_dependents_textfield.setBounds(435,205,230,30);
        no_dependents_textfield.setFont(new Font("Arial",Font.BOLD,14));
        image.add(no_dependents_textfield);

        
        
        JLabel monthly_income=new JLabel("Montly Income:");
        monthly_income.setForeground(Color.black);
        monthly_income.setFont(new Font("Raleway",Font.BOLD,20));
        monthly_income.setBounds(80,250,150,40);
        image.add(monthly_income);
        
        monthly_income_textfield = new JTextField();
        monthly_income_textfield.setBounds(435,250,230,30);
        monthly_income_textfield.setFont(new Font("Arial",Font.BOLD,14));
        image.add(monthly_income_textfield);
        
        
        String[] Loans = {"Select Loan","Home Loan","Business Loan","Health Loan","Car Loan",
        "Student Loan"};
        
        
         JLabel loan_type=new JLabel("Loan Type:");
        loan_type.setForeground(Color.black);
        loan_type.setFont(new Font("Raleway",Font.BOLD,20));
        loan_type.setBounds(80,300,150,40);
        image.add(loan_type);
        
        list = new JComboBox(Loans);
        list.setForeground(Color.black);
        list.setBounds(435, 300, 150, 30);
        list.setBackground(Color.WHITE);
        image.add(list);
        
        JLabel address_proof=new JLabel("Address Proof: ");
        address_proof.setForeground(Color.black);
       address_proof.setFont(new Font("Raleway",Font.BOLD,20));
       address_proof.setBounds(80,350,150,30);
      image.add(address_proof);
       
       own =new JRadioButton("Own");
       own.setBounds(435,350,100,30);
       own.setBackground(Color.WHITE);
       image.add(own);
       
       rental =new JRadioButton("Rental");
       rental.setBounds(550,350,100,30);
       rental.setBackground(Color.WHITE);
       image.add(rental);
       
       ButtonGroup genderGroup=new ButtonGroup();
       genderGroup.add(own);
       genderGroup.add(rental);
       
        
        JLabel loan_amount=new JLabel("Loan Amount:");
        loan_amount.setForeground(Color.black);
        loan_amount.setFont(new Font("Raleway",Font.BOLD,20));
        loan_amount.setBounds(80,400,150,40);
        image.add(loan_amount);
        
        loan_amount_textfield = new JTextField();
        loan_amount_textfield.setBounds(435,400,230,30);
        loan_amount_textfield.setFont(new Font("Arial",Font.BOLD,14));
        add(loan_amount_textfield);
 
        JLabel time_period=new JLabel("Time Period (Years):");
        time_period.setForeground(Color.black);
        time_period.setFont(new Font("Raleway",Font.BOLD,20));
        time_period.setBounds(80,450,250,40);
        image.add(time_period);
        
        time_period_textfield = new JTextField();
        time_period_textfield.setBounds(435,450,230,30);
        time_period_textfield.setFont(new Font("Arial",Font.BOLD,14));
        add(time_period_textfield);
 
        JLabel Loan_purpose=new JLabel("Explain why you need this loan:");
        Loan_purpose.setForeground(Color.black);
        Loan_purpose.setFont(new Font("Raleway",Font.BOLD,20));
        Loan_purpose.setBounds(80,500,350,40);
        image.add(Loan_purpose);
        
        loan_explanation = new JTextArea();
//        loan_explanation.setBorder(black);
        loan_explanation.setBounds(435, 500, 400, 100);
        image.add(loan_explanation);
        
        
        JButton next=new JButton("Submit");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.green);
        next.setBounds(230,625,450,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        image.add(next);
        
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
        
       
        
    }
    public static void main(String args[]){
            new Loan_Application(acc_no);
        }
 
 public void actionPerformed(ActionEvent ae)
    {

        String form_no = "L" +random;
        String profession=Professiontextfield.getText();
        String education=education_textfield.getText();
        int no_dependents=Integer.parseInt(no_dependents_textfield.getText());
        double monthly_income=Double.parseDouble(monthly_income_textfield.getText());
        String address_proof;
        if(own.isSelected())
        {
         address_proof = "own";   
        }
        else
        {
         address_proof = "rental";   
        }
         
        Conn c=new Conn();
        double loan_amount=Double.parseDouble(loan_amount_textfield.getText());
        int time_period=Integer.parseInt(time_period_textfield.getText());
        String loan_exp=loan_explanation.getText();
        
      
        
        try
        {
            
//        String query="insert into test2 values('"+form_no+"')";
                String insertion="insert into Loan_Application(form_no,account_no,profession,education,no_dependents,monthly_income,address_proof,loan_type,loan_amount,time_period,loan_explanation) "
                        + "values ('"+form_no+"','"+acc_no+"','"+profession+"','"+education+"','"+no_dependents+"',"
                        + "'"+monthly_income+"','"+address_proof+"','"+list.getSelectedItem()+"','"+loan_amount+"','"+time_period+"','"+loan_exp+"')";
                c.s.executeUpdate(insertion);
                JOptionPane.showMessageDialog(null,"Application is Submitted!");
                setVisible(false);
                
    }
    catch(Exception e){
            System.out.println(e);
            
        }
        
        String nod=no_dependents_textfield.getText();
        String minc=monthly_income_textfield.getText();
        String lll=loan_amount_textfield.getText();
        String timp=time_period_textfield.getText();
        String le=loan_explanation.getText();
        
        if(profession.equals("") && education.equals("") && nod.equals("") && minc.equals("") 
                && lll.equals("") && timp.equals("") && le.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Kindly Fill the page completely");   
        }
        
        
    }
 
        
}
