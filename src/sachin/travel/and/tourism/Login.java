package sachin.travel.and.tourism;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
     JButton login,signup,frgtpswd;
     JTextField TFuser,TFpassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);// frame ke upar add kr rhe
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel user = new JLabel("Username");
        user.setBounds(60,20,100,25);
        user.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p2.add(user);
        
        TFuser = new JTextField();
        TFuser.setBounds(60,60,300,30);
        TFuser.setBorder(BorderFactory.createEmptyBorder());
        p2.add(TFuser);
        
        // for Password
        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN SERIF", Font.PLAIN,20));
        p2.add(password);
        
        TFpassword = new JTextField();
        TFpassword.setBounds(60,150,300,30);
        TFpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(TFpassword);
        
        // Buttons
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);// event trigger
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);// event trigger
        p2.add(signup);
        
        frgtpswd = new JButton("Forgot Password");
        frgtpswd.setBounds(150,250,130,30);
        frgtpswd.setBackground(new Color(133,193,233));
        frgtpswd.setForeground(Color.WHITE);
        frgtpswd.setBorder(new LineBorder(new Color(133,193,233)));
        frgtpswd.addActionListener(this);// event trigger
        p2.add(frgtpswd);
        
        JLabel text = new JLabel("Trouble In Login...");
        text.setBounds(320,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ac){
        if(ac.getSource()== login){
           if(ac.getSource()== login){
    try{
        String username = TFuser.getText();
        String pass = TFpassword.getText();
        
        String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        if(rs.next()){
            setVisible(false);
            new Welcome(username); // Pass username to Welcome class
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong Credentials Entered");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}

        }else if (ac.getSource()== signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
     }
    public static void main (String args[]){
        new Login();// anonymus object jb store na karaya jai
    }
}
