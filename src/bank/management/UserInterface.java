/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author ayush
 */
public class UserInterface extends JFrame implements ActionListener {
    
    JButton loan_application,transaction;
    static String acc_no,cus_name;
    
    UserInterface(String card_no,String name)
    {
        setTitle("Bank");
        setLayout(null);
        acc_no = card_no;
        cus_name = name;
//        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank_1.jpg"));
//        Image img = img1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(img);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0,0,800,500); 
//        add(image);

        JLabel text=new JLabel("Welcome To XYZ Bank");
        text.setForeground(Color.black);
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(200,10,800,50);
        add(text);
        
        JLabel hi=new JLabel("Hello " + cus_name);
        hi.setForeground(Color.black);
        hi.setFont(new Font("Osward",Font.BOLD,40));
        hi.setBounds(300,80,800,50);
        add(hi);
        
        
        loan_application=new JButton("Loan Application");
        loan_application.setBounds(270,200,300,30);
        loan_application.setBackground(Color.BLACK);
        loan_application.setForeground(Color.WHITE);
        loan_application.addActionListener(this);
        add(loan_application);
        
        transaction=new JButton("Transaction");
        transaction.setBounds(270,300,300,30);
        transaction.setBackground(Color.BLACK);
        transaction.setForeground(Color.WHITE);
        transaction.addActionListener(this);
        add(transaction);
        
        
setSize(900,720);
        setLocation(260,30);
        setVisible(true);
    }
    
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == transaction)
        {
            new Transactions();
        }
        else if (ae.getSource() == loan_application)
        {
            new Loan_Application(acc_no);
        }
    }
    public static void main(String args[])
    {
        new UserInterface(acc_no,cus_name);
    }
}
