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
public class Admin extends JFrame implements ActionListener{
    JButton login;
    JTextField idTextField,pinTextField;
    
    
    
    public Admin()
    {
        setLayout(null);
         ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin1.png"));
        Image img = img1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,720); 
        add(image);
        
        setTitle("Admin Login");
        
        
//         JLabel text=new JLabel("Welcome Admin");
//        text.setFont(new Font("Osward",Font.BOLD,40));
//        text.setForeground(Color.white);
//        text.setBounds(500,140,400,45);
//        add(text);
        
        JLabel id=new JLabel("Enter Id:");
        id.setFont(new Font("Raleway",Font.BOLD,20));
        id.setBounds(250,530,150,40);
        id.setForeground(Color.white);
        image.add(id);
        
         idTextField=new JTextField();
        idTextField.setBounds(400,535,230,30);
        idTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(idTextField);
        
        
        JLabel pin=new JLabel("Enter Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(250,575,150,40);
        pin.setForeground(Color.white);
        image.add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(400,580,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("Log in");
        login.setBounds(340,630,180,30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this);
        image.add(login);
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
         
    }

 public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login)
        {
            String id =idTextField.getText();
             String pin =pinTextField.getText();
             Conn a = new Conn();
             String query = "select * from Manager where Manager_id= '"+id+"' and pin  = '"+pin+"'";
              try {
                  ResultSet rs = a.s.executeQuery(query);
                  if(rs.next())
                  {
//                      ResultSet result = null;
                      int admin_id = rs.getInt(1);
                      String admin_name = rs.getString(2);
                  
                      new Admin_Control_Page(admin_id,admin_name);
                      
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
 public static void main(String args[])
 {
     new Admin();
 }
}