package sachin.travel.and.tourism;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author SACHIN DUBEY
 */
public class Welcome extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar ;
    String username;
    
    Welcome(String username){
    this.username = username;
    t = new Thread(this);
    setBounds(400,200,870,400);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel text = new JLabel("Sachin Travel And Tourism Management System");
    text.setBounds(30,30,800,60);
    text.setForeground(Color.BLUE);
    text.setFont(new Font("Railway", Font.BOLD,35));
    add(text);
    
    bar = new JProgressBar();
    bar.setBounds(250,100,300,35);
    bar.setStringPainted(true);
    add(bar);
    
    JLabel loading = new JLabel("Loading ! Please Wait...");
    loading.setBounds(320,170,180,40);
    loading.setForeground(Color.RED);
    loading.setFont(new Font("Railway", Font.BOLD,16));
    add(loading);
    
    
    JLabel lblusername = new JLabel("Welcome "+ username);
    lblusername.setBounds(20,310,400,40);
    lblusername.setForeground(Color.RED);
    lblusername.setFont(new Font("Railway", Font.BOLD,16));
    add(lblusername);

    t.start();
    setVisible(true);
}

    
     public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main (String args[]){
        new Welcome("Sachindubey_a1");
    }
}
