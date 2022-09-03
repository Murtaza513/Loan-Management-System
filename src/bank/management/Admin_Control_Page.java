/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management;

import static bank.management.loanManage.table;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class Admin_Control_Page extends JFrame implements ActionListener{
    static int admin_idd;
    static String admin_namee;
     
    JButton Subquery_1,Subquery_2,Subquery_3,Subquery_4,Subquery_5,Subquery_6,Subquery_7,Subquery_8,Subquery_9,Subquery_10;
    JTextField firstquery,Query3,Query4,Query5,Query6,Query6_2;
    
     static JTable table;
     JFrame frame1;
    String[] columnNames = {"formno", "account_no", "name", "email"};
    public Admin_Control_Page(int admin_id,String admin_name)
            
    {
        setLayout(null);
         ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin.jpg"));
        Image img = img1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,720); 
        add(image);
        
        admin_idd = admin_id ;
        admin_namee = admin_name;
        
        setTitle("Admin Control Page");
        setLayout(null);
        
        JLabel text=new JLabel("Welcome "+admin_name);
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(300,40,400,45);
        image.add(text);
        
        Subquery_1=new JButton("Loan Amount threshold");
        Subquery_1.setBounds(350,100,150,30);
        Subquery_1.setBackground(Color.BLACK);
        Subquery_1.setForeground(Color.WHITE);
        Subquery_1.addActionListener(this);
        image.add(Subquery_1);
        
        firstquery=new JTextField();
        firstquery.setBounds(500,100,150,30);
        firstquery.setFont(new Font("Arial",Font.BOLD,14));
        image.add(firstquery);
        
        Subquery_2=new JButton("Loan > Avg Loan");
        Subquery_2.setBounds(350,150,150,30);
        Subquery_2.setBackground(Color.BLACK);
        Subquery_2.setForeground(Color.WHITE);
        Subquery_2.addActionListener(this);
        image.add(Subquery_2);
        
        
        
        
        Subquery_3=new JButton("City");
        Subquery_3.setBounds(350,200,150,30);
        Subquery_3.setBackground(Color.BLACK);
        Subquery_3.setForeground(Color.WHITE);
        Subquery_3.addActionListener(this);
        image.add(Subquery_3);
        
        Query3=new JTextField();
        Query3.setBounds(500,200,150,30);
        Query3.setFont(new Font("Arial",Font.BOLD,14));
        image.add(Query3);
        
        Subquery_4=new JButton("Interest ");
        Subquery_4.setBounds(350,250,150,30);
        Subquery_4.setBackground(Color.BLACK);
        Subquery_4.setForeground(Color.WHITE);
        Subquery_4.addActionListener(this);
        image.add(Subquery_4);
        
       
        
        Subquery_5=new JButton("Ratio ");
        Subquery_5.setBounds(350,300,150,30);
        Subquery_5.setBackground(Color.BLACK);
        Subquery_5.setForeground(Color.WHITE);
        Subquery_5.addActionListener(this);
        image.add(Subquery_5);
        
        Query5=new JTextField();
        Query5.setBounds(500,200,150,30);
        Query5.setFont(new Font("Arial",Font.BOLD,14));
        image.add(Query5);
        
        Subquery_6=new JButton("Subquery 6 Result");
        Subquery_6.setBounds(350,350,150,30);
        Subquery_6.setBackground(Color.BLACK);
        Subquery_6.setForeground(Color.WHITE);
        Subquery_6.addActionListener(this);
        image.add(Subquery_6);
        
        Query6=new JTextField();
        Query6.setBounds(500,350,150,30);
        Query6.setFont(new Font("Arial",Font.BOLD,14));
        image.add(Query6);
        
       /* Subquery_7=new JButton("Subquery 7 Result");
        Subquery_7.setBounds(350,400,150,30);
        Subquery_7.setBackground(Color.BLACK);
        Subquery_7.setForeground(Color.WHITE);
        Subquery_7.addActionListener(this);
        image.add(Subquery_7);
        
        Subquery_8=new JButton("Subquery 8 Result");
        Subquery_8.setBounds(350,450,150,30);
        Subquery_8.setBackground(Color.BLACK);
        Subquery_8.setForeground(Color.WHITE);
        Subquery_8.addActionListener(this);
        image.add(Subquery_8);
        
        Subquery_9=new JButton("Subquery 9 Result");
        Subquery_9.setBounds(350,500,150,30);
        Subquery_9.setBackground(Color.BLACK);
        Subquery_9.setForeground(Color.WHITE);
        Subquery_9.addActionListener(this);
        image.add(Subquery_9);
        
        Subquery_10=new JButton("Subquery 10 Result");
        Subquery_10.setBounds(350,550,150,30);
        Subquery_10.setBackground(Color.BLACK);
        Subquery_10.setForeground(Color.WHITE);
        Subquery_10.addActionListener(this);
        image.add(Subquery_10);
        */
        
        setSize(900,720);
        setLocation(260,30);
        setVisible(true);
        
        
    }
//
//    try {
//                c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","cs201245");
//                calling = c.prepareCall("{call bonus(?,?)}");
//            } catch (SQLException ex) {
//                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
//            }
public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource()== Subquery_1){
            displayQuery1();
        }
       if(ae.getSource()== Subquery_2){
            displayQuery2();
        }
        if(ae.getSource()== Subquery_3){
            displayQuery3();
        }
        if(ae.getSource()== Subquery_4){
            displayQuery4();
        }
        if(ae.getSource()== Subquery_5){
            displayQuery5();
        }
        if(ae.getSource()== Subquery_6){
            displayQuery6();
        }
    }

public  void displayQuery1(){
   
        frame1 = new JFrame("Database Search Result");
       
        frame1.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        String form_no="";
        String account_no="";
        String name="";
        String email="";
        
    
   CallableStatement calling = null;
        Conn c=new Conn();
        ResultSet rs;
        double max_amount=Double.parseDouble(firstquery.getText());
             String query_1 = "select l.form_no,l.account_no,s.name,s.email from loan_application as l join signup as s on s.formno = "
                     + "l.account_no \n" +
                "where loan_amount > "+max_amount;
            try {
                rs = c.s.executeQuery(query_1);
                if(rs.next()){
                     form_no = rs.getString("form_no");
                     account_no=rs.getString("account_no");
                     name=rs.getString("name");
                     email=rs.getString("email");
                   
                model.addRow(new Object[]{form_no,account_no,name,email});
                
                while(rs.next()){
                     form_no = rs.getString("form_no");
                     account_no=rs.getString("account_no");
                     name=rs.getString("name");
                     email=rs.getString("email");
                   
                model.addRow(new Object[]{form_no,account_no,name,email});
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(900, 720);
        frame1.setLocation(260,30);
}

public  void displayQuery2(){
   frame1 = new JFrame("Database Search Result");
   
        frame1.setLayout(new BorderLayout());



        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);



        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        String form_no="";
        String account_no="";
        String name="";
        String email="";
        
    
   CallableStatement calling = null;
        Conn c=new Conn();
        ResultSet rs;
        
             String query_1 = "select l.form_no,l.account_no,s.name,s.email from loan_application as l join signup as s on s.formno = "
                     + "l.account_no \n" +
                "where loan_amount >(select avg(loan_amount) from loan_application)";
             
            try {
                rs = c.s.executeQuery(query_1);
                if(rs.next()){
                     form_no = rs.getString("form_no");
                     account_no=rs.getString("account_no");
                     name=rs.getString("name");
                     email=rs.getString("email");
                    
                model.addRow(new Object[]{form_no,account_no,name,email});
                
                while(rs.next()){
                    form_no = rs.getString("form_no");
                     account_no=rs.getString("account_no");
                     name=rs.getString("name");
                     email=rs.getString("email");
                    
                model.addRow(new Object[]{form_no,account_no,name,email});
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(900, 720);
        frame1.setLocation(260,30);
}

public  void displayQuery3(){
    
        frame1 = new JFrame("Database Search Result");
        
        frame1.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        String form_no="";
        String name="";
       
  
   CallableStatement calling = null;
        Conn c=new Conn();
        ResultSet rs;
        String city=Query3.getText();
             
             String query="select formno,name from signup where city= +'"+city+"'";
            try {
                rs = c.s.executeQuery(query);
                if(rs.next()){
                     form_no = rs.getString("formno");
                     name=rs.getString("name");
                model.addRow(new Object[]{form_no,name});
                    
                while(rs.next()){
                    form_no = rs.getString("formno");
                     name=rs.getString("name");
                model.addRow(new Object[]{form_no,name});
                    
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(900, 720);
        frame1.setLocation(260,30);
}

public  void displayQuery4(){
    
    
   CallableStatement calling = null;
        Conn c=new Conn();
        ResultSet rs;
        
            double interest;
             
             String query="select sum(loan_amount)*0.10 as Interest_Earned_By_Bank from loan_accept";
            try {
                rs = c.s.executeQuery(query);
                if(rs.next()){
                     interest = rs.getDouble("Interest_Earned_By_Bank");
                    
               
                    JOptionPane.showMessageDialog(null, "Total interest earned= "+interest);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
       
}

public  void displayQuery5(){
    Conn c=new Conn();
        ResultSet rs,rs2;
        float accept;
        float reject;
        float ratio;
            
             
             String query="select count(*) countA from loan_accept";
             String query2="select count(*) countR from loan_reject";
            try {
                rs = c.s.executeQuery(query);
                
                 
                if(rs.next()){
                    accept=rs.getInt("countA");
                     rs = c.s.executeQuery(query2);
                if(rs.next()){
                    reject=rs.getInt("countR");
                    ratio=(accept/reject);
                     JOptionPane.showMessageDialog(null, ratio);
                }
                }
               
                
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
       
}

public void displayQuery6(){
   
    frame1 = new JFrame("Database Search Result");
    
        frame1.setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    
        String emp_id="";
        String name="";
        int salary;
        
        
       
  
   CallableStatement calling = null;
        Conn c=new Conn();
        ResultSet rs;
        String date=Query6.getText();
             
             String query="select employee_id,name,salary from employees where salary >(Select avg(salary) from employee) data_hired >"
                     + date;
              
            try {
                rs = c.s.executeQuery(query);
                if(rs.next()){
                     emp_id = rs.getString("employee_id");
                     name=rs.getString("name");
                     salary=rs.getInt("salary");
                model.addRow(new Object[]{emp_id,name,salary});
                    
                while(rs.next()){
                     emp_id = rs.getString("employee_id");
                     name=rs.getString("name");
                     salary=rs.getInt("salary");
                model.addRow(new Object[]{emp_id,name,salary});
                    
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin_Control_Page.class.getName()).log(Level.SEVERE, null, ex);
            }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(900, 720);
        frame1.setLocation(260,30);
    
    
}
 public static void main(String args[])
 {
     new Admin_Control_Page(admin_idd,admin_namee);
 }
}
