package sachin.travel.and.tourism;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author SACHIN DUBEY
 */
public class ViewCustomer extends JFrame implements ActionListener{
    JButton back;
    ViewCustomer(String username){
         setBounds(350, 180, 870, 525);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,110, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,170, 150, 25);
        add(labelnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230, 150, 25);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220,230, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290, 150, 25);
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,290, 150, 25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50, 150, 25);
        add(lblcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690,50, 150, 25);
        add(labelcountry);
        
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,110, 150, 25);
        add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(600,110, 250, 25);
        add(labeladdress);
        
        JLabel lblphoneno = new JLabel("Phone No");
        lblphoneno.setBounds(500,170, 150, 25);
        add(lblphoneno);
        
        JLabel labelphoneno = new JLabel();
        labelphoneno.setBounds(690,170, 150, 25);
        add(labelphoneno);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,230, 150, 25);
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(600,230, 250, 25);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBounds(450,280, 100, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);  // Corrected this line
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 300, 600, 200);
        add(image);
        
         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 300, 600, 200);
        add(image2);
        
         try {
            String query = "select * from customer where username =' "+username+" '";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelgender.setText(rs.getString("gender"));
                labelname.setText(rs.getString("name"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphoneno.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
                
                
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
        new ViewCustomer("Sachindubey_a1");
    }
}
