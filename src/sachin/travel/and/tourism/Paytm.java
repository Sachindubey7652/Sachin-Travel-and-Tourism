package sachin.travel.and.tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author SACHIN DUBEY
 */
public class Paytm extends JFrame implements ActionListener{
    Paytm(){
      setBounds(400,130,800,600);
      
      JEditorPane pane = new JEditorPane();
      pane.setEditable(false);
      try{
          pane.setPage("https://paytm.com/rent-payment");
          
      }catch(Exception e){
          pane.setContentType("text/html");
          pane.setText("<html>Could not load,Error Occured");
//          e.printStackTrace();
      }
      
      JScrollPane sp = new JScrollPane(pane);
      getContentPane().add(sp);
      
        JButton back = new JButton("Back");
        back.setBounds(610,20, 80, 40);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this); 
        pane.add(back);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ac) {
       
       setVisible(false);
         new Payment();
     }
    public static void main (String args[]){
        new Paytm();
    }
}
