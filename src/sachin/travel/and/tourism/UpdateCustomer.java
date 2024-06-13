package sachin.travel.and.tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author SACHIN DUBEY
 */
public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel User, name;
    JComboBox comboid;
    JTextField TFnumber, TFaddress, TFcountry, TFphoneno, TFemail,TFid,TFname,TFgender;
    JRadioButton male, female;
    JButton add, back;
    
    UpdateCustomer(String username) {
        setBounds(400, 150, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(50,0, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(text);
        
        JLabel user = new JLabel("Username");
        user.setBounds(30, 50, 150, 25);
        add(user);

        User = new JLabel("");
        User.setBounds(220, 50, 150, 25);
        add(User);

        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 150, 25);
        add(id);

        TFid = new JTextField();
        TFid.setBounds(220, 90, 150, 25);
        add(TFid);

        JLabel number = new JLabel("Number");
        number.setBounds(30, 130, 150, 25);
        add(number);

        TFnumber = new JTextField();
        TFnumber.setBounds(220, 130, 150, 25);
        add(TFnumber);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 170, 150, 25);
        add(nameLabel);

        TFname = new JTextField();
        TFname.setBounds(220, 170, 150, 25);
        add(TFname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 210, 150, 25);
        add(gender);

        TFgender = new JTextField();
        TFgender.setBounds(220, 210, 150, 25);
        add(TFgender);

        JLabel country = new JLabel("Country");
        country.setBounds(30, 250, 150, 25);
        add(country);

        TFcountry = new JTextField();
        TFcountry.setBounds(220, 250, 150, 25);
        add(TFcountry);

        JLabel address = new JLabel("Address");
        address.setBounds(30, 290, 150, 25);
        add(address);

        TFaddress = new JTextField();
        TFaddress.setBounds(220, 290, 150, 25);
        add(TFaddress);

        JLabel email = new JLabel("Email");
        email.setBounds(30, 330, 150, 25);
        add(email);

        TFemail = new JTextField();
        TFemail.setBounds(220, 330, 150, 25);
        add(TFemail);

        JLabel phoneno = new JLabel("Phone No");
        phoneno.setBounds(30, 370, 150, 25);
        add(phoneno);

        TFphoneno = new JTextField();
        TFphoneno.setBounds(220, 370, 150, 25);
        add(TFphoneno);

        add = new JButton("Update");
        add.setBounds(70, 430, 100, 25);
        add.setBackground(Color.WHITE);
        add.setForeground(new Color(133, 193, 233));
        add.setFont(new Font("Tahoma", Font.BOLD, 14));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(400, 430, 100, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);  // Corrected this line
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 500);
        add(image);

        try {
            String query = "select * from customer where username =' "+username+" '";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                User.setText(rs.getString("username"));
                TFname.setText(rs.getString("name"));
                TFid.setText(rs.getString("id"));
                TFnumber.setText(rs.getString("number"));
                TFgender.setText(rs.getString("gender"));
                TFcountry.setText(rs.getString("country"));
                TFaddress.setText(rs.getString("address"));
                TFphoneno.setText(rs.getString("phone"));
                TFemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == add) {
            String username = User.getText();
            String Name = TFname.getText();
            String id =  TFid.getText();
            String number = TFnumber.getText();
            String gender = TFgender.getText();
            String country = TFcountry.getText();
            String address = TFaddress.getText();
            String phone = TFphoneno.getText();
            String email = TFemail.getText();

            String query = "Update  customer set username = '" +username+ "', id ='" +id+ "',number =  '" +number+ "', name = '"+Name+"',gender = '" +gender+ "',country = '" +country+ "', address ='" +address+ "',phone = '" +phone+ "',email = '" +email+ "'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new UpdateCustomer("Sachindubey_a1");
    }
}
