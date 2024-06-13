package sachin.travel.and.tourism;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField TFuser,TFname,TFpassword,TFans;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);// combination of setsize and setlocation
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);// frame ke upar add kr rhe
        
        JLabel user = new JLabel("Username");
        user.setBounds(50,20,125,25);
        user.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(user);
        
        TFuser = new JTextField();
        TFuser.setBounds(190,20,180,25);
        TFuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFuser);
        // For Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,60,125,25);
        name.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(name);
        
        TFname = new JTextField();
        TFname.setBounds(190,60,180,25);
        TFname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFname);
        // For Password
        JLabel password = new JLabel("Password");
        password .setBounds(50,100,125,25);
        password .setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(password );
        
        TFpassword  = new JTextField();
        TFpassword.setBounds(190,100,180,25);
        TFpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFpassword);
        // Security Question
        JLabel sques = new JLabel("Security Questions");
        sques.setBounds(50,140,125,25);
        sques.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(sques);
        
        security = new Choice();
        security.add("Your Best Friend");
        security.add("Your Favorite Teacher");
        security.add("Your Favorite Book");
        security.add("Your favorite Dish");
        security.add("Your First School");
        security.add("Your place of Birth");
        security.add("Your NickName");
        security.setBounds(190,140,150,25);
        p1.add(security);
        // Answers
         JLabel ans = new JLabel("Answer");
        ans.setBounds(50,180,125,25);
       ans.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(ans);
        
        TFans  = new JTextField();
        TFans.setBounds(190,180,180,25);
        TFans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TFans);
        // Buttons
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahoma", Font.BOLD,14));
        create.addActionListener(this);// event trigger
        p1.add(create);
        
        // Back Button
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahoma", Font.BOLD,14));
        back.addActionListener(this);// event trigger
        p1.add(back);
        
        
        // image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,250,250);
        add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()== create){
            String username = TFuser.getText();
            String name = TFname.getText();
            String password = TFpassword.getText();
            String question = security.getSelectedItem();
            String answer = TFans.getText();
            
            String query = "Insert into account values(' "+username+" ',' "+name+" ',' "+password+" ',' "+question+" ',' "+answer+" ')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Created Successfuly");
                
                setVisible(false);
                 new Login();
                 
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ac.getSource()== back){
            setVisible(false);
            new Login();
        }
    }
     public static void main (String args[]){
         new Signup();// anonymous abject
     }
}
