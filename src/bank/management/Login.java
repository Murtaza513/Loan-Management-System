package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signUp,employee_login,admin_login;
    JTextField cardTextField,pinTextField;
    
    Login(){
        setTitle("Login");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        i1=new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i1);
        imgLabel.setBounds(300,10,100,100);
        
        add(imgLabel);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankk.jpg"));
        Image img = img1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        
        ImageIcon i3 = new ImageIcon(img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,720); 
        add(image);
        
        JLabel text=new JLabel("Welcome");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setForeground(Color.black);
        text.setBounds(430,40,400,40);
        image.add(text);
        
        JLabel cardNo=new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        cardNo.setForeground(Color.black);
        cardNo.setBounds(230,195,150,40);
        image.add(cardNo);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(350,200,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(cardTextField);
        
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setForeground(Color.black);
        pin.setBounds(230,250,400,40);
        image.add(pin);
        
         pinTextField=new JPasswordField();
        pinTextField.setBounds(350,255,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD ,14));
        image.add(pinTextField);
        
         login=new JButton("Log in");
        login.setBounds(385,350,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
         clear=new JButton("Clear");
        clear.setBounds(390,550,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        image.add(clear);
        
         signUp=new JButton("Sign up");
        signUp.setBounds(370,400,130,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        image.add(signUp);
        
        employee_login=new JButton("Employee Login");
        employee_login.setBounds(360,450,150,30);
        employee_login.setBackground(Color.BLACK);
        employee_login.setForeground(Color.WHITE);
        employee_login.addActionListener(this);
        image.add(employee_login);
        
        admin_login=new JButton("Admin Login");
        admin_login.setBounds(360,500,150,30);
        admin_login.setBackground(Color.BLACK);
        admin_login.setForeground(Color.WHITE);
        admin_login.addActionListener(this);
        image.add(admin_login);
        
        getContentPane().setBackground(Color.white);
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        try{
        if(ae.getSource()==login){
            String pin =pinTextField.getText();
            String card_no =cardTextField.getText();
           Conn c=new Conn();
           String q  = "select * from signup where formno = '"+card_no+"' and pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
//                     int customer_id = rs.getInt(1);
                      String customer_name = rs.getString(2);
                  
                      new UserInterface(card_no,customer_name);
//                  new UserInterface(card_no);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
        }
        else if(ae.getSource()==clear){
            
            cardTextField.setText("");
            pinTextField.setText("");
       
           }
        else if(ae.getSource()==signUp){
            new SignupOne();
        }
        else if(ae.getSource()==employee_login){
            new Employee_login();
        }
        else if(ae.getSource() == admin_login)
            new Admin();
        
        
        
}   
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
        
    }
    
}
