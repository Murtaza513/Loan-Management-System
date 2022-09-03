
package bank.management;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class loanManage extends JFrame implements ActionListener{
     JFrame frame1;
    JLabel l0, l1, l2;
    JComboBox c1;
    JButton b1,accept,reject;
    Conn con;
    ResultSet rs, rs1;
    Statement st, st1;
    PreparedStatement pst;
    String ids;
    static JTable table;
    String[] columnNames = {"formno", "profession", "education", "no_dependents","monthly_income",
    "address_proof","loan_type","loan_amount","time_period","loan_explanation"};
    String from;
    static int employee_idd;
    static String employee_name;
    
    
    public loanManage(String name,int employee_id){
        
        employee_idd = employee_id;
        employee_name = name;
        
        JLabel text=new JLabel("Welcome "+employee_name);
        text.setForeground(Color.red);
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(250,30,500,40);
        add(text);
        
        
        l0 = new JLabel("Fetching Loan Info");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select formNO");
        b1 = new JButton("submit");
        accept=new JButton("Accept");
        reject=new JButton("Reject");

        l0.setBounds(280, 60, 350, 40);
        l1.setBounds(250, 110, 75, 20);
        
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);
        accept.setBounds(150, 180, 150, 20);
        accept.addActionListener(this);
        reject.setBounds(150, 210, 150, 20);
        reject.addActionListener(this);

        setTitle("Fetching Loan Info From DataBase");
        setLayout(null);
        setSize(900,720);
        setVisible(true);
        setLocation(270,30);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(l0);
        add(l1);;
        add(b1);
        add(accept);
        add(reject);
        try {

            con =new Conn();
           
            rs = con.s.executeQuery("select form_no from Loan_Application");
            Vector v = new Vector();

            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }

            c1 = new JComboBox(v);
            c1.setForeground(Color.black);
            c1.setBounds(350, 110, 150, 20);
            add(c1);
            st.close();
            
        } 
        catch (Exception e)
        {
        }
        
    }
    public void actionPerformed(ActionEvent ae) {
        String query = "update loan_application set status=? where form_no=? ";
        String delete = "delete from loan_application where form_no=? ";
        String insert_employee_id_acc = "update loan_accept set employee_id = ? where loan_id = ?";
        String insert_employee_id_rej = "update loan_reject set employee_id = ? where loan_id = ?";
        
        Conn con=new Conn(query);
        Conn con2=new Conn(delete);
        Conn con3=new Conn(insert_employee_id_acc);
        Conn con4=new Conn(insert_employee_id_rej);
        
        PreparedStatement ps = null;
        if (ae.getSource() == b1) {
            showTableData();
        }
        if(ae.getSource() == accept){
            try{
                    
                 con.ps.setString(1, "accept");
                 con.ps.setString(2, c1.getSelectedItem().toString());
                 con.ps.executeUpdate();
                 con2.ps.setString(1, c1.getSelectedItem().toString());
                 con2.ps.executeUpdate();
                 con3.ps.setInt(1, employee_idd);
                 con3.ps.setString(2, c1.getSelectedItem().toString());
                 con3.ps.executeUpdate();
                 c1.removeItem(c1.getSelectedItem().toString());
            }
            catch(Exception e){
            e.printStackTrace();
      }
        }
        if(ae.getSource() == reject){
            try{
                 con.ps.setString(1, "reject");
                 con.ps.setString(2, c1.getSelectedItem().toString());
                 con.ps.executeUpdate();
                 con2.ps.setString(1, c1.getSelectedItem().toString());
                 con2.ps.executeUpdate();
                 con4.ps.setInt(1, employee_idd);
                 con4.ps.setString(2, c1.getSelectedItem().toString());
                 con4.ps.executeUpdate();   
                 c1.removeItem(c1.getSelectedItem().toString());
            }
            catch(Exception e){
            e.printStackTrace();
      }
        }
    }
    
     public void showTableData() {


        frame1 = new JFrame("Database Search Result");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        from = (String) c1.getSelectedItem();

        String form_no = "";
        String profession = "";
        String education = "";
        int no_dependents;
        double monthly_income;
        String address_proof="";
        String loan_type="";
        double loan_amount;
        int time_period;
        String loan_explanation;
        
       
        try {
            String q="select * from Loan_Application where form_no='" + from + "'";
             
            ResultSet rs = con.s.executeQuery(q);
            int i = 0;
            if (rs.next()) {
                form_no = rs.getString("form_no");
                profession = rs.getString("profession");
                education = rs.getString("education");
                no_dependents = rs.getInt("no_dependents");
                monthly_income=rs.getDouble("monthly_income");
                address_proof=rs.getString("address_proof");
                loan_type=rs.getString("loan_type");
                loan_amount=rs.getDouble("loan_amount");
                time_period=rs.getInt("time_period");
                loan_explanation=rs.getString("loan_explanation");
                
                
                model.addRow(new Object[]{form_no,profession,education,no_dependents,monthly_income,address_proof
                ,loan_type,loan_amount,time_period,loan_explanation});

                i++;
            }

            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(900, 720);
        frame1.setLocation(260,30);
    }

    public static void main(String args[]) {
        new loanManage(employee_name,employee_idd);
    }
}
  

