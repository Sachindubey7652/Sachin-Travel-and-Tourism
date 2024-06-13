package sachin.travel.and.tourism;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * About class to display information about the travel and tourism company.
 * This class provides a brief introduction and overview of the company.
 * It includes a button to return to the previous screen.
 * 
 * @author SACHIN DUBEY
 */
public class About extends JFrame implements ActionListener{
    About(){
         setBounds(270, 130, 1000,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("ABOUT");
        text.setBounds(150,10,200,40);
        text.setForeground(Color.red);
        text.setFont(new Font("Tahoma", Font.BOLD,40));
        add(text);
        
        String aboutText = "HEY ! THIS IS SACHIN DUBEY AND I WELCOME YOU ALL TO SACHIN TRAVEL AND TOURISM \n" +
                "---\n" +
                "\n" +
                "**About Us**\n" +
                "\n" +
                "Welcome to SACHIN TRAVEL AND TOURISM, where we strive to provide a memorable and delightful experience for each of our guests. Established with a passion for [describe your establishment's theme or purpose, e.g., fine dining, casual atmosphere, cultural exploration], we are committed to offering exceptional service and culinary excellence.\n" +
                "\n" +
                "At [Your Establishment Name], we believe in [mention core values, such as quality, authenticity, sustainability, community engagement, etc.]. Our team of dedicated professionals works tirelessly to ensure that every aspect of your visit exceeds expectations, from the warm ambiance to the delectable dishes prepared with the freshest ingredients.\n" +
                "\n" +
                "Our menu reflects our commitment to [describe your cuisine style or specialty], featuring a diverse array of flavors and culinary creations crafted with care and creativity. Whether you're joining us for a romantic dinner, a casual lunch with friends, or a special celebration, we have something to delight every palate.\n" +
                "\n" +
                "We are proud to be a part of the [mention any affiliations, local community, or industry partnerships], and we continually seek ways to give back and support the communities we serve. Your satisfaction is our priority, and we are grateful for the opportunity to share our passion for [describe your cuisine or concept] with you.\n" +
                "\n" +
                "Thank you for choosing [Your Establishment Name]. We look forward to welcoming you and creating unforgettable memories together.\n" +
                "\n" +
                "---\n" +
                "\n";
        
        TextArea area = new TextArea(aboutText, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        area.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Adjust font style and size
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 20);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this); 
        add(back);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ac) {
        setVisible(false); // Hide the current frame when back button is clicked
    }
   
    public static void main (String args[]){
        new About();
    } 
}
