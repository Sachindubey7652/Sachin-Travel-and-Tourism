package sachin.travel.and.tourism;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author SACHIN DUBEY
 */
public class AddCustomer extends JFrame implements ActionListener {
    JLabel User, name;
    JComboBox comboid;
    JTextField TFnumber, TFaddress, TFcountry, TFphoneno, TFemail;
    JRadioButton male, female;
    JButton add, back;

    AddCustomer(String username) {
        setBounds(450, 150, 770, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel user = new JLabel("Username");
        user.setBounds(30, 50, 150, 25);
        add(user);

        User = new JLabel("");
        User.setBounds(220, 50, 150, 25);
        add(User);

        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 150, 25);
        add(id);

        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card", "Voter ID"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel number = new JLabel("Number");
        number.setBounds(30, 130, 150, 25);
        add(number);

        TFnumber = new JTextField();
        TFnumber.setBounds(220, 130, 150, 25);
        add(TFnumber);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 170, 150, 25);
        add(nameLabel);

        name = new JLabel("");
        name.setBounds(220, 170, 150, 25);
        add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 210, 150, 25);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(220, 210, 70, 25);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 210, 70, 25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

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

        add = new JButton("ADD");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            String query = "select * from account where username = '"+username+"' ";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                User.setText(rs.getString("username"));
                name.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == add) {
            String username = User.getText();
            String Name = name.getText();
            String id = (String) comboid.getSelectedItem();
            String number = TFnumber.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = TFcountry.getText();
            String address = TFaddress.getText();
            String phone = TFphoneno.getText();
            String email = TFemail.getText();

            String query = "Insert into customer values('" +username+ "', '" +id+ "', '" +number+ "', '" +gender+ "', '" +country+ "', '" +address+ "', '" +phone+ "', '" +email+ "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");

                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new AddCustomer("Sachindubey_a1");
    }
}
