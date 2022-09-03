/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ayush
 */
public class Employee_login extends JFrame implements ActionListener{
    JButton login;
    JTextField idTextField,pinTextField;
    
    Employee_login()
    {
        setTitle("Employee Login");
        setLayout(null);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image img = img1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,720); 
        add(image);
        
        JLabel text=new JLabel("Welcome Employee");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setForeground(Color.black);
        text.setBounds(260,40,400,45);
        image.add(text);
        
        JLabel id=new JLabel("Enter Id:");
        id.setFont(new Font("Raleway",Font.BOLD,20));
        id.setForeground(Color.white);
        id.setBounds(250,500,150,40);
        image.add(id);
        
         idTextField=new JTextField();
        idTextField.setBounds(420,505,230,30);
        idTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(idTextField);
        
        
        JLabel pin=new JLabel("Enter Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setForeground(Color.white);
        pin.setBounds(250,550,150,40);
        image.add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(420,550,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(pinTextField);
        
        login=new JButton("Log in");
        login.setBounds(340,610,180,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
    }
    
      public void actionPerformed (ActionEvent ae){
          if(ae.getSource() == login)
          {
             String id =idTextField.getText();
             String pin =pinTextField.getText();
             Conn a = new Conn();
             String query = "select * from Employee where Employee_id = '"+id+"' and pin  = '"+pin+"'";
              try {
                  ResultSet rs = a.s.executeQuery(query);
                  if(rs.next())
                  {
//                      ResultSet result = null;
                      int employee_id = rs.getInt(1);
                      String employee_name = rs.getString(2);
                  
                      new loanManage(employee_name,employee_id);
                      
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null, "Incorrect Id or PIN");
                  }
              } catch (SQLException ex) {
                 System.out.print(ex);
              }
          }
          
      }
       public static void main(String args[]){
        new Employee_login();
        
    }
    
}
