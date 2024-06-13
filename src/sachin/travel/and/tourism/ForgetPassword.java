package sachin.travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author SACHIN DUBEY
 */
public class ForgetPassword extends JFrame implements ActionListener {
    
    JLabel user,name,sques,sans,password;
    JTextField TFuser,TFname,TFsques,TFsans,TFpassword;
    JButton search,retrieve,back;
    Choice security;
    ForgetPassword(){
        setBounds(350,200,850,370);// combination of setsize and setlocation
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
           
            
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,200,200);
        add(image);
        
    
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(30,30,500,260);
        p1.setLayout(null);
        add(p1);// frame ke upar add kr rhe
     
        
        user = new JLabel("Username");
        user.setBounds(40,20,100,25);
        user.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p1.add(user);
        
        TFuser = new JTextField();
        TFuser.setBounds(220,20,150,25);
        TFuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFuser);
        
        //Button
        search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(Color.GRAY);
        search.setForeground(new Color(133,193,233));
        search.setFont(new Font("Tahoma", Font.BOLD,14));
        search.addActionListener(this);// event trigger
        p1.add(search);
        // name 
        name = new JLabel("name");
        name.setBounds(40,60,100,25);
        name.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p1.add(name);
        
        TFname = new JTextField();
        TFname.setBounds(220,60,150,25);
        TFname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFname);
        // security ques
        sques = new JLabel("Security Question");
        sques.setBounds(40,100,170,25);
        sques.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p1.add(sques);
        
        TFsques = new JTextField();
        TFsques.setBounds(220,100,150,25);
        TFsques.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFsques);
         // security answers
        sans = new JLabel("Answer");
        sans.setBounds(40,140,170,25);
        sans.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p1.add(sans);
        
        TFsans = new JTextField();
        TFsans.setBounds(220,140,150,25);
        TFsans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFsans);
         //Button
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380,140,100,25);
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(new Color(133,193,233));
        retrieve.setFont(new Font("Tahoma", Font.BOLD,14));
        retrieve.addActionListener(this);// event trigger
        p1.add(retrieve);
        
         // Password
        password = new JLabel("Password");
        password.setBounds(40,180,150,25);
        password.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p1.add(password);
        
        TFpassword = new JTextField();
        TFpassword.setBounds(220,180,150,25);
        TFpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFpassword);
        
        //Button
        back = new JButton("Back");
        back.setBounds(150,230,100,25);
        back.setBackground(Color.GRAY);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma", Font.BOLD,14));
        back.addActionListener(this);// event trigger
        p1.add(back);
        
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()== search){
            try{
                String query ="select * from account where username = ' "+TFuser.getText()+" '";
                Conn c = new Conn();
               ResultSet rs= c.s.executeQuery(query);
               while(rs.next()){
                   TFname.setText(rs.getString("name"));
                   TFsques.setText(rs.getString("security"));
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ac.getSource()== retrieve){
             try{
                String query ="select * from account where answer = ' "+TFsans.getText()+" ' AND username = ' "+TFuser.getText()+" ' ";
                Conn c = new Conn();
               ResultSet rs= c.s.executeQuery(query);
               while(rs.next()){
                   TFpassword.setText(rs.getString("password"));
                
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ac.getSource()== back){
            setVisible(false);
            new Login();
        }
    }
    public static void main (String args[]){
        new ForgetPassword();
    }
}
