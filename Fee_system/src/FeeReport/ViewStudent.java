/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FeeReport;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author ayush
 */
public class ViewStudent extends JFrame{
    String x[]={"Roll no.","Name","Email","Course","Fee","Paid","Due","Address","city","State","Country","mobile"};
    String y[][]=new String[20][12];
    int i =0,j=0;
    JTable t;
    Font f;
    ViewStudent()
    {
        super("Student information");
        setSize(1300,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try {
            ConnectionClass obj=new ConnectionClass();
            String q="Select * from add_student";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("rollno");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("course");
                y[i][j++]=rest.getString("fee");
                y[i][j++]=rest.getString("paid");
                y[i][j++]=rest.getString("due");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("city");
                y[i][j++]=rest.getString("state");
                y[i][j++]=rest.getString("country");
                y[i][j++]=rest.getString("mobile");
                i++;
                j=0;
               
            }
            t=new JTable(y,x);
            t.setFont(f);
           
        }catch(Exception ee){
            ee.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
       
    }
    public static void main(String[] args)
    {
        new ViewStudent().setVisible(true);
    }
   
}