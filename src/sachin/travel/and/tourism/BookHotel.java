package sachin.travel.and.tourism;

import java.awt.Choice;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SACHIN DUBEY
 */

public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField TFperson,TFdays;
    String username;
    JLabel labelusername,lblnumber,lblphone,lbltotal,lblid,labelprice,labelnumber,labelid,labelphone;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username = username;
         setBounds(250, 150,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Book Hotel");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250,70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);
        
        JLabel lblpkg = new JLabel("Select Hotel");
        lblpkg.setBounds(40,110, 150, 20);
        lblpkg.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpkg);
        
        chotel = new Choice(); 
        chotel.setBounds(250,110, 200, 20);
        add(chotel);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(40,150, 150, 25);
        lblperson.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblperson);
        
        TFperson = new JTextField("1");
        TFperson.setBounds(250, 150, 200, 25);
        add(TFperson);
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40,190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);
        
        TFdays = new JTextField("1");
        TFdays.setBounds(250, 190, 200, 25);
        add(TFdays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);
        
        cac = new Choice(); 
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230, 200, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);
        
        cfood = new Choice(); 
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270, 200, 20);
        add(cfood);
        
        
        lblid = new JLabel("ID");
        lblid.setBounds(40,310, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,310,200, 25);
        add(labelid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,150, 25);
        add(labelnumber);
        
        lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,390,150, 25);
        add(labelphone);
        
        lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250,430,150, 25);
        add(labelprice);
        
        try {
            String query = "select * from customer where username =' "+username+" '";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setBackground(Color.WHITE);
        checkprice.setForeground(new Color(133, 193, 233));
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkprice.addActionListener(this);  // Corrected this line
        add(checkprice);
        
        bookpackage= new JButton("Book Hotel");
        bookpackage.setBounds(200, 490, 150, 25);
        bookpackage.setBackground(Color.WHITE);
        bookpackage.setForeground(new Color(133, 193, 233));
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookpackage.addActionListener(this);  // Corrected this line
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(380, 490, 100, 25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(150, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);  // Corrected this line
        add(back);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == checkprice){
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int acr = Integer.parseInt(rs.getString("acroom"));
                
                int persons = Integer.parseInt(TFperson.getText());
                int days = Integer.parseInt(TFdays.getText());
                String acselected = cac.getSelectedItem();
                String foodselected =cfood.getSelectedItem();
                if(persons*days >0){
                    int total = 0;
                    total += acselected.equals("AC") ? acr : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total+=cost;
                    total = total *persons*days;
                    labelprice.setText("Rs. "+ total);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Please Enter a valid Text");
                }
            }
            String pack = chotel.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            }else if (pack.equals("Silver Package")){
                cost += 16000;
            }else{
                cost += 18000;
            }
            
            int persons = Integer.parseInt((TFperson.getText()));
            cost*= persons;
            labelprice.setText("Rs. " + cost);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ac.getSource() == bookpackage){
            String query = "Insert into bookhotel values('" +labelusername.getText()+ "', '" +chotel.getSelectedItem()+ "', '" +TFperson.getText()+ "', '" +TFdays.getText()+ "','" +cac.getSelectedItem()+ "', '" +cfood.getSelectedItem()+ "', '" +labelid.getText()+ "', '" +labelnumber.getText()+ "', '" +labelphone.getText()+ "', '" +labelprice.getText()+ "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main (String args[]){
        new BookHotel("Sachindubey_a1");
    }
}

