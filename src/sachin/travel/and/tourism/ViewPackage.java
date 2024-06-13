package sachin.travel.and.tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author SACHIN DUBEY
 */

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String username){
        setBounds(450, 200, 900,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60,0,300,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,90, 150, 25);
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,90, 150, 25);
        add(labelpackage);
        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(30,130, 150, 25);
        add(lblperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220,130, 150, 25);
        add(labelperson);
        
       JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,170, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,170, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,210, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,210, 150, 25);
        add(labelnumber);
        
        JLabel lblphoneno = new JLabel("Phone No");
        lblphoneno.setBounds(30,250, 150, 25);
        add(lblphoneno);
        
        JLabel labelphoneno = new JLabel();
        labelphoneno.setBounds(220,250, 150, 25);
        add(labelphoneno);
        
        
         JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,290, 150, 25);
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,290, 150, 25);
        add(labelprice);
        
       
        
        back = new JButton("Back");
        back.setBounds(130,360, 100, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);  // Corrected this line
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500,400);
        add(image);
        
        
         try {
            String query = "select * from bookpackage where username =' "+username+" '";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("person"));
                labelphoneno.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ac) {
       setVisible(false);
     }
    public static void main(String args []){
        new ViewPackage("Sachindubey_a1");
    }
}


