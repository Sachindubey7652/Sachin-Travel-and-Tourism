package sachin.travel.and.tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author SACHIN DUBEY
 */
public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    Payment(){
        setBounds(400,100,800,600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 800,600);
        add(image);
        
        pay= new JButton("Pay");
        pay.setBounds(420,0, 80,40);
        pay.setBackground(Color.WHITE);
        pay.setForeground(new Color(133, 193, 233));
        pay.setFont(new Font("Tahoma", Font.BOLD, 14));
        pay.addActionListener(this); 
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(520,0, 80, 40);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this); 
        image.add(back);
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ac) {
         if(ac.getSource()==pay){
             setVisible(false);
             new Paytm();
         }else{
       setVisible(false);
         }
     }
    public static void main (String args[]){
        new Payment();
    }
}
