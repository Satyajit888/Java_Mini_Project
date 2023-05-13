/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FeeReport;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class Admin extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf;
    JPasswordField pf;
    Font f,f1;
    Admin()
    {
        super("Admin Login Page");
        setLocation(100,100);
        setSize(400,200);
        
        l1=new JLabel("Admin Login");
        l2=new JLabel("Name");
        l3=new JLabel("Password");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBackground(Color.BLACK);
        l1.setForeground(Color.BLUE);
        
        bt1=new JButton("Login");
        bt2=new JButton("Cancel");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        tf=new JTextField();
        pf=new JPasswordField();
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf.setFont(f1);
        pf.setFont(f1);
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf);
        p2.add(l3);
        p2.add(pf);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"Center");
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String name=tf.getText();
        String pass=pf.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "SELECT * FROM admin WHERE username = ? AND password = ?";
                PreparedStatement pstmt = obj.con.prepareStatement(q);
                pstmt.setString(1, name);
                pstmt.setString(2, pass);
                ResultSet rest = pstmt.executeQuery();

                if(rest.next())
                {  
                    System.out.println("you are logged in");
                    new AdminSection().setVisible(true);
                    this.setVisible(false);
                }
                 else
                {
                    JOptionPane.showMessageDialog(null,"Your name OR password OR both is wrong!");
                    this.setVisible(true);
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            
        }
        if(e.getSource()==bt2)
        {
            new Index().setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args)
    {
        new Admin().setVisible(true);
    }
}
